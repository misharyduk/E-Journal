CREATE SEQUENCE journal_id_sequence INCREMENT BY 1;
CREATE SEQUENCE lesson_id_sequence INCREMENT BY 1;
CREATE SEQUENCE acad_module_id_sequence INCREMENT BY 1;
CREATE SEQUENCE exer_work_id_sequence INCREMENT BY 1;
CREATE SEQUENCE contr_work_id_sequence INCREMENT BY 1;
CREATE SEQUENCE lesson_attend_id_sequence INCREMENT BY 1;
CREATE SEQUENCE lesson_journal_id_sequence INCREMENT BY 1;
CREATE SEQUENCE practice_journal_id_sequence INCREMENT BY 1;
CREATE SEQUENCE work_student_id_sequence INCREMENT BY 1;
CREATE SEQUENCE control_journal_id_sequence INCREMENT BY 1;
CREATE SEQUENCE sem_stud_grade_id_sequence INCREMENT BY 1;
CREATE SEQUENCE cont_work_student_id_sequence INCREMENT BY 1;
CREATE SEQUENCE mod_stud_contr_id_sequence INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS journal
(
    journal_id                 BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    semester_number            VARCHAR(10) CHECK (semester_number IN ('FIRST', 'SECOND')),
    first_acad_year            INT    NOT NULL,
    second_acad_year           INT    NOT NULL,
    subject_id                 BIGINT NOT NULL,
    group_id                   BIGINT NOT NULL,
    lecture_teacher_id         BIGINT NOT NULL,
    practical_teacher_id       BIGINT NOT NULL,
    lecture_lesson_journal_id  BIGINT,
    practice_lesson_journal_id BIGINT,
    exercise_work_journal_id   BIGINT,
    control_journal_id         BIGINT
);

CREATE TABLE IF NOT EXISTS lesson_journal
(
    lesson_journal_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS practice_journal
(
    practice_journal_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS control_journal
(
    control_journal_id        BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS academic_module
(
    acad_module_id  BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    module_number   INT    NOT NULL,
    start_date      TIMESTAMP NOT NULL,
    end_date      TIMESTAMP NOT NULL,
    journal_id      BIGINT NOT NULL,
    control_work_id BIGINT
);

CREATE TABLE IF NOT EXISTS lesson
(
    lesson_id      BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    lesson_type    VARCHAR(100) NOT NULL,
    lesson_date    TIMESTAMP    NOT NULL,
    lesson_order   INT          NOT NULL,
    auditory       VARCHAR(50)  NOT NULL,
    les_journal_id BIGINT
);

CREATE TABLE IF NOT EXISTS lesson_attendance
(
    lesson_attend_id BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    attendance_val   VARCHAR(25) NOT NULL,
    student_id       BIGINT      NOT NULL,
    lesson_id        BIGINT      NOT NULL
);

CREATE TABLE IF NOT EXISTS exercise_work
(
    exer_work_id       BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    work_number        INT         NOT NULL,
    exercise_work_type VARCHAR(50) NOT NULL CHECK (exercise_work_type IN ('LABORATORY', 'INDIVIDUAL')),
    academic_module_id BIGINT      NOT NULL,
    prac_journal_id    BIGINT      NOT NULL
);

CREATE TABLE IF NOT EXISTS work_student
(
    work_student_id BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id      BIGINT      NOT NULL,
    exec_date       TIMESTAMP,
    def_date        TIMESTAMP,
    mark            DOUBLE,
    exer_work_id    BIGINT      NOT NULL
);

CREATE TABLE IF NOT EXISTS control_work
(
    contr_work_id BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    exec_date     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS control_work_student
(
    cont_work_student_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id           BIGINT,
    mark                 DOUBLE
);

CREATE TABLE IF NOT EXISTS module_student_control
(
    mod_stud_contr_id       BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id              BIGINT,
    module_id               BIGINT,
    work_sum_grade          DOUBLE,
    control_work_student_id BIGINT,
    final_grade             DOUBLE
);

CREATE TABLE IF NOT EXISTS control_journal_and_module_student_control
(
    control_journal_id        BIGINT,
    module_student_control_id BIGINT
);

CREATE TABLE IF NOT EXISTS control_journal_and_semester_student_grade
(
    control_journal_id        BIGINT,
    semester_student_grade_id BIGINT
);

CREATE TABLE IF NOT EXISTS control_work_and_control_work_student
(
    control_work_id         BIGINT,
    control_work_student_id BIGINT
);

CREATE TABLE IF NOT EXISTS semester_student_grade
(
    sem_stud_grade_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id        BIGINT,
    mark              DOUBLE
);

ALTER TABLE journal ADD FOREIGN KEY (lecture_lesson_journal_id) REFERENCES lesson_journal (lesson_journal_id) ON DELETE SET NULL;
ALTER TABLE journal ADD FOREIGN KEY (practice_lesson_journal_id) REFERENCES lesson_journal (lesson_journal_id) ON DELETE SET NULL;
ALTER TABLE journal ADD FOREIGN KEY (exercise_work_journal_id) REFERENCES practice_journal (practice_journal_id) ON DELETE SET NULL;
ALTER TABLE journal ADD FOREIGN KEY (control_journal_id) REFERENCES control_journal (control_journal_id) ON DELETE SET NULL;

ALTER TABLE academic_module ADD FOREIGN KEY (journal_id) REFERENCES journal (journal_id) ON DELETE CASCADE;
ALTER TABLE academic_module ADD FOREIGN KEY (control_work_id) REFERENCES control_work (contr_work_id) ON DELETE SET NULL;

ALTER TABLE lesson ADD FOREIGN KEY (les_journal_id) REFERENCES lesson_journal (lesson_journal_id) ON DELETE CASCADE;
ALTER TABLE lesson_attendance ADD FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE;

ALTER TABLE exercise_work ADD FOREIGN KEY (academic_module_id) REFERENCES academic_module (acad_module_id) ON DELETE CASCADE;
ALTER TABLE exercise_work ADD FOREIGN KEY (prac_journal_id) REFERENCES lesson_journal (lesson_journal_id) ON DELETE SET NULL;

ALTER TABLE work_student ADD FOREIGN KEY (exer_work_id) REFERENCES exercise_work (exer_work_id) ON DELETE SET NULL;

ALTER TABLE control_work_and_control_work_student ADD FOREIGN KEY (control_work_id) REFERENCES control_work (contr_work_id) ON DELETE SET NULL;
ALTER TABLE control_work_and_control_work_student ADD FOREIGN KEY (control_work_student_id) REFERENCES control_work_student (cont_work_student_id) ON DELETE SET NULL;

ALTER TABLE module_student_control ADD FOREIGN KEY (control_work_student_id) REFERENCES control_work_student (cont_work_student_id) ON DELETE SET NULL;
ALTER TABLE module_student_control ADD FOREIGN KEY (module_id) REFERENCES academic_module (acad_module_id) ON DELETE SET NULL;

ALTER TABLE control_journal_and_module_student_control ADD FOREIGN KEY (control_journal_id) REFERENCES control_journal (control_journal_id) ON DELETE SET NULL;
ALTER TABLE control_journal_and_module_student_control ADD FOREIGN KEY (module_student_control_id) REFERENCES module_student_control (mod_stud_contr_id) ON DELETE SET NULL;

ALTER TABLE control_journal_and_semester_student_grade ADD FOREIGN KEY (control_journal_id) REFERENCES control_journal (control_journal_id) ON DELETE SET NULL;
ALTER TABLE control_journal_and_semester_student_grade ADD FOREIGN KEY (semester_student_grade_id) REFERENCES semester_student_grade (sem_stud_grade_id) ON DELETE SET NULL;