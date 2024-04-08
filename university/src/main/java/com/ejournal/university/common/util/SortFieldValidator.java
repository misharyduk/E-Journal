package com.ejournal.university.common.util;

import lombok.Getter;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

public class SortFieldValidator {

    @Getter
    public enum UniversityField{

        UNIVERSITY_ID(Set.of("id", "identifier", "number"), "id"),
        UNIVERSITY_NAME(Set.of("name", "title"), "universityName"),
        ACCREDITATION(Set.of("accreditation", "acc"), "accreditation"),
        FACULTIES(Set.of("faculties", "faculty"), "faculties"),
        DEPARTMENTS(Set.of("departments", "department"), "departments"),
        STUDENTS(Set.of("students", "student"), "students"),
        TEACHERS(Set.of("teachers", "teacher", "personal"), "teachers");

        private UniversityField(Collection<String> fieldNameVariations, String validHQLField){
            this.fieldNameVariations = fieldNameVariations;
            this.validHQLField = validHQLField;
        }

        private final Collection<String> fieldNameVariations;
        private final String validHQLField;

        public static UniversityField validate(String inputFieldName){
            EnumSet<UniversityField> enumSet = EnumSet.allOf(UniversityField.class);
            return enumSet.stream()
                    .filter(field -> field.getFieldNameVariations().contains(inputFieldName))
                    .findFirst()
                    .orElse(UNIVERSITY_ID);
        }
    }

    @Getter
    public enum FacultyField{

        FACULTY_ID(Set.of("id", "identifier", "number"), "id"),
        FACULTY_NAME(Set.of("name", "title"), "facultyName"),
        DEPARTMENTS(Set.of("departments", "department"), "departments"),
        STUDENTS(Set.of("students", "student"), "students"),
        TEACHERS(Set.of("teachers", "teacher", "personal"), "teachers");

        FacultyField(Collection<String> fieldNameVariations, String validHQLField){
            this.fieldNameVariations = fieldNameVariations;
            this.validHQLField = validHQLField;
        }

        private final Collection<String> fieldNameVariations;
        private final String validHQLField;

        public static FacultyField validate(String inputFieldName){
            EnumSet<FacultyField> enumSet = EnumSet.allOf(FacultyField.class);
            return enumSet.stream()
                    .filter(field -> field.getFieldNameVariations().contains(inputFieldName))
                    .findFirst()
                    .orElse(FACULTY_ID);
        }
    }

    @Getter
    public enum DepartmentField{

        DEPARTMENT_ID(Set.of("id", "identifier", "number"), "id"),
        DEPARTMENT_NAME(Set.of("name", "title"), "departmentName"),
        STUDENTS(Set.of("students", "student"), "studentsAmount");

        DepartmentField(Collection<String> fieldNameVariations, String validHQLField){
            this.fieldNameVariations = fieldNameVariations;
            this.validHQLField = validHQLField;
        }

        private final Collection<String> fieldNameVariations;
        private final String validHQLField;

        public static DepartmentField validate(String inputFieldName){
            EnumSet<DepartmentField> enumSet = EnumSet.allOf(DepartmentField.class);
            return enumSet.stream()
                    .filter(field -> field.getFieldNameVariations().contains(inputFieldName))
                    .findFirst()
                    .orElse(DEPARTMENT_ID);
        }
    }

    @Getter
    public enum TeacherField {

        TEACHER_ID(Set.of("id", "identifier", "number"), "id"),
        FIRST_NAME(Set.of("first_name", "firstName", "first"), "firstName"),
        LAST_NAME(Set.of("last_name", "lastName", "last", "surname", "name"), "lastName");

        TeacherField(Collection<String> fieldNameVariations, String validHQLField){
            this.fieldNameVariations = fieldNameVariations;
            this.validHQLField = validHQLField;
        }

        private final Collection<String> fieldNameVariations;
        private final String validHQLField;

        public static TeacherField validate(String inputFieldName){
            EnumSet<TeacherField> enumSet = EnumSet.allOf(TeacherField.class);
            return enumSet.stream()
                    .filter(field -> field.getFieldNameVariations().contains(inputFieldName))
                    .findFirst()
                    .orElse(TEACHER_ID);
        }
        }

}
