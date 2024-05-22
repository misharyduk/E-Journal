package com.ejournal.journal.lesson_journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.lesson_journal.dto.*;
import com.ejournal.journal.lesson_journal.entity.Lesson;
import com.ejournal.journal.lesson_journal.entity.LessonAttendance;
import com.ejournal.journal.lesson_journal.entity.LessonJournal;
import com.ejournal.journal.lesson_journal.entity.LessonRepeat;
import com.ejournal.journal.lesson_journal.mapper.LessonMapper;
import com.ejournal.journal.lesson_journal.repository.LessonAttendanceRepository;
import com.ejournal.journal.lesson_journal.repository.LessonJournalRepository;
import com.ejournal.journal.lesson_journal.repository.LessonRepository;
import com.ejournal.journal.lesson_journal.service.LessonJournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LessonJournalServiceImpl implements LessonJournalService {

    private final LessonJournalRepository lessonJournalRepository;
    private final LessonRepository lessonRepository;
    private final LessonAttendanceRepository lessonAttendanceRepository;

    private static final Locale uaLocale = new Locale("uk", "UA");

    @Override
    public LessonJournalResponseDto fetchById(Long lessonJournalId) {
        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));
        return LessonJournalResponseDto.builder()
                .id(lessonJournal.getId())
                .lessons(lessonJournal.getLessons().stream()
                        .map(this::mapLessonDto)
                        .sorted(Comparator.comparing(LessonResponseDto::getDate))
                        .toList())
                .build();
    }

    @Override
    public Journal enrichAndSaveLessonJournal(Journal journal, String lessonJournalType) {
        LessonJournal lessonJournal = new LessonJournal();
        lessonJournalRepository.saveLessonJournal(lessonJournal);
        if(lessonJournalType.equals("LECTURE")){
            journal.setLectureLessonJournalId(lessonJournal.getId());
        } else {
            journal.setPracticeLessonJournalId(lessonJournal.getId());
        }
        return journal;
    }

    @Override
    public LessonJournalResponseDto createLesson(Long lessonJournalId, LessonRequestDto lessonRequestDto) {

        if(lessonJournalId == null || lessonJournalId <= 0)
            throw new RuntimeException("Journal id cannot be less than 1");

        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));

        // repeat lesson
        LessonRepeat lessonRepeat = EnumSet.allOf(LessonRepeat.class).stream()
                .filter(lr -> lr.getValue().equalsIgnoreCase(lessonRequestDto.getRepeat())).findFirst().get();

        switch (lessonRepeat) {
            case ONCE -> saveLesson(lessonJournal, lessonRequestDto);
            case ONCE_A_WEEK_PER_MONTH -> {
                Calendar calendar = Calendar.getInstance(uaLocale);
                calendar.setTime(lessonRequestDto.getDate());

                Calendar calendarNextMonth = getNextMonthFirstDay(lessonRequestDto.getDate());
                while (calendar.before(calendarNextMonth)){
                    saveLesson(lessonJournal, lessonRequestDto);
                    calendar.add(Calendar.WEEK_OF_YEAR, 1);
                    lessonRequestDto.setDate(calendar.getTime());
                }
            }
            case ONCE_A_WEEK_PER_SEMESTER -> {
                Calendar requestDate = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());

                Calendar startOfFirstSemester = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());
                startOfFirstSemester.set(Calendar.DAY_OF_MONTH, 1);
                startOfFirstSemester.set(Calendar.MONTH, Calendar.AUGUST);

                Calendar endOfCurrentSemester = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());
                endOfCurrentSemester.set(Calendar.DAY_OF_MONTH, 31);

                if(requestDate.after(startOfFirstSemester)){ // first semester
                    endOfCurrentSemester.set(Calendar.MONTH, Calendar.DECEMBER);
                } else { // second semester
                    endOfCurrentSemester.set(Calendar.MONTH, Calendar.MAY);
                }

                while (requestDate.before(endOfCurrentSemester)){
                    saveLesson(lessonJournal, lessonRequestDto);
                    requestDate.add(Calendar.WEEK_OF_YEAR, 1);
                    lessonRequestDto.setDate(requestDate.getTime());
                }
            }
            case ONCE_AN_EVEN_WEEK_PER_MONTH -> {
                Calendar calendar = Calendar.getInstance(uaLocale);
                calendar.setTime(lessonRequestDto.getDate());

                Calendar calendarNextMonth = getNextMonthFirstDay(lessonRequestDto.getDate());
                while (calendar.before(calendarNextMonth)){
                    if(calendar.get(Calendar.WEEK_OF_MONTH) % 2 == 0) {
                        saveLesson(lessonJournal, lessonRequestDto);
                    }
                    calendar.add(Calendar.WEEK_OF_YEAR, 1);
                    lessonRequestDto.setDate(calendar.getTime());
                }
            }
            case ONCE_AN_ODD_WEEK_PER_MONTH -> {
                Calendar calendar = Calendar.getInstance(uaLocale);
                calendar.setTime(lessonRequestDto.getDate());

                Calendar calendarNextMonth = getNextMonthFirstDay(lessonRequestDto.getDate());
                while (calendar.before(calendarNextMonth)){
                    if(calendar.get(Calendar.WEEK_OF_MONTH) % 2 != 0) {
                        saveLesson(lessonJournal, lessonRequestDto);
                    }
                    calendar.add(Calendar.WEEK_OF_YEAR, 1);
                    lessonRequestDto.setDate(calendar.getTime());
                }
            }
            case ONCE_AN_EVEN_WEEK_PER_SEMESTER -> {
                Calendar requestDate = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());

                Calendar startOfFirstSemester = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());
                startOfFirstSemester.set(Calendar.DAY_OF_MONTH, 1);
                startOfFirstSemester.set(Calendar.MONTH, Calendar.AUGUST);

                Calendar endOfCurrentSemester = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());
                endOfCurrentSemester.set(Calendar.DAY_OF_MONTH, 31);

                if(requestDate.after(startOfFirstSemester)){ // first semester
                    endOfCurrentSemester.set(Calendar.MONTH, Calendar.DECEMBER);
                } else { // second semester
                    endOfCurrentSemester.set(Calendar.MONTH, Calendar.MAY);
                }

                while (requestDate.before(endOfCurrentSemester)){
                    if(requestDate.get(Calendar.WEEK_OF_YEAR) % 2 == 0) {
                        saveLesson(lessonJournal, lessonRequestDto);
                    }
                    requestDate.add(Calendar.WEEK_OF_YEAR, 1);
                    lessonRequestDto.setDate(requestDate.getTime());
                }
            }
            case ONCE_AN_ODD_WEEK_PER_SEMESTER -> {
                Calendar requestDate = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());

                Calendar startOfFirstSemester = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());
                startOfFirstSemester.set(Calendar.DAY_OF_MONTH, 1);
                startOfFirstSemester.set(Calendar.MONTH, Calendar.AUGUST);

                Calendar endOfCurrentSemester = Calendar.getInstance(uaLocale);
                requestDate.setTime(lessonRequestDto.getDate());
                endOfCurrentSemester.set(Calendar.DAY_OF_MONTH, 31);

                if(requestDate.after(startOfFirstSemester)){ // first semester
                    endOfCurrentSemester.set(Calendar.MONTH, Calendar.DECEMBER);
                } else { // second semester
                    endOfCurrentSemester.set(Calendar.MONTH, Calendar.MAY);
                }

                while (requestDate.before(endOfCurrentSemester)){
                    if(requestDate.get(Calendar.WEEK_OF_YEAR) % 2 != 0) {
                        saveLesson(lessonJournal, lessonRequestDto);
                    }
                    requestDate.add(Calendar.WEEK_OF_YEAR, 1);
                    lessonRequestDto.setDate(requestDate.getTime());
                }
            }
        }

        return LessonJournalResponseDto.builder()
                .id(lessonJournal.getId())
                .lessons(lessonJournal.getLessons().stream()
                        .map(this::mapLessonDto)
                        .toList())
                .build();
    }

    private Calendar getNextMonthFirstDay(Date sourceDate){
        Calendar calendarNextMonth = Calendar.getInstance(uaLocale);
        calendarNextMonth.setTime(sourceDate);
        calendarNextMonth.set(Calendar.DAY_OF_MONTH, 1);
        calendarNextMonth.add(Calendar.MONTH, 1);
        return calendarNextMonth;
    }

    private LessonJournal saveLesson(LessonJournal lessonJournal, LessonRequestDto lessonRequestDto) {

        Lesson lesson = LessonMapper.mapToEntity(lessonRequestDto, new Lesson());

        lessonJournal.getLessons().add(lesson);
        lesson.setLessonJournal(lessonJournal);

        lessonRepository.createInstance(lesson);
        lessonJournalRepository.saveLessonJournal(lessonJournal);
        return lessonJournal;
    }

    @Override
    public LessonJournalResponseDto markStudentAttendance(Long lessonJournalId, StudentAttendanceRequestDto attendanceRequestDto) {
        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));

        Lesson lesson = lessonRepository.fetchInstanceById(attendanceRequestDto.getLessonId())
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id", String.valueOf(attendanceRequestDto.getLessonId())));

        LessonAttendance lessonAttendance = new LessonAttendance();
        String validAttendanceValue = switch (attendanceRequestDto.getAttendanceValue()) {
            case "not-present" -> "н";
            case "ill" -> "хв";
            case "not-attestation" -> "н/а";
            default -> attendanceRequestDto.getAttendanceValue();
        };

        lessonAttendance.setAttendanceValue(validAttendanceValue);
        lessonAttendance.setStudentId(attendanceRequestDto.getStudentId());
        lessonAttendance.setLesson(lesson);

        lessonAttendanceRepository.saveLessonAttendance(lessonAttendance);
        lesson.getLessonAttendances().add(lessonAttendance);

        lessonJournalRepository.saveLessonJournal(lessonJournal);
        return LessonJournalResponseDto.builder()
                .id(lessonJournal.getId())
                .lessons(lessonJournal.getLessons().stream()
                        .map(this::mapLessonDto)
                        .toList())
                .build();
    }

    @Override
    public LessonJournalResponseDto updateStudentAttendance(Long lessonJournalId, Long attendanceId, StudentAttendanceRequestDto attendanceRequestDto) {

        LessonAttendance lessonAttendance = lessonAttendanceRepository.fetchLessonAttendance(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance", "id", String.valueOf(attendanceId)));

        if(attendanceRequestDto.getAttendanceValue() != null && !attendanceRequestDto.getAttendanceValue().isBlank()){
            String validAttendanceValue = switch (attendanceRequestDto.getAttendanceValue()) {
                case "not-present" -> "н";
                case "ill" -> "хв";
                case "not-attestation" -> "н/а";
                default -> null;
            };
            lessonAttendance.setAttendanceValue(validAttendanceValue);
            lessonAttendanceRepository.saveLessonAttendance(lessonAttendance);
        } else {
            Lesson lesson = lessonAttendance.getLesson();
            lesson.getLessonAttendances().removeIf(la -> la.getId().equals(attendanceId));
            lessonRepository.updateInstance(lesson);
            lessonAttendanceRepository.deleteLessonAttendance(lessonAttendance);
        }

        LessonJournal lessonJournal = lessonJournalRepository.fetchLessonJournal(lessonJournalId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson journal", "id", String.valueOf(lessonJournalId)));

        return LessonJournalResponseDto.builder()
                .id(lessonJournal.getId())
                .lessons(lessonJournal.getLessons().stream()
                        .map(this::mapLessonDto)
                        .toList())
                .build();
    }

    private LessonResponseDto mapLessonDto(Lesson lesson){
        LessonResponseDto responseDto = LessonMapper.mapToDto(lesson, new LessonResponseDto());
        responseDto.setLessonAttendances(lesson.getLessonAttendances().stream()
                .map(la -> new LessonAttendanceResponseDto(la.getId(), la.getStudentId(), lesson.getId(), la.getAttendanceValue())).toList());
        return responseDto;
    }
}
