package com.ejournal.university.common.util;

import lombok.Getter;

import java.util.Collection;
import java.util.Set;

public class SortFieldValidator {

    @Getter
    public enum UniversityField{

        ID(Set.of("id", "identifier", "number")),
        NAME(Set.of("name", "title")),
        ACCREDITATION(Set.of("accreditation", "acc")),
        FACULTIES(Set.of("faculties", "faculty")),
        DEPARTMENTS(Set.of("departments", "department")),
        STUDENTS(Set.of("students", "student")),
        TEACHERS(Set.of("teachers", "teacher", "personal"));

        private UniversityField(Collection<String> fieldNameVariations){
            this.fieldNameVariations = fieldNameVariations;
        }

        private final Collection<String> fieldNameVariations;

    }

    @Getter
    public enum FacultyField{

        ID(Set.of("id", "identifier", "number")),
        NAME(Set.of("name", "title")),
        DEPARTMENTS(Set.of("departments", "department")),
        STUDENTS(Set.of("students", "student")),
        TEACHERS(Set.of("teachers", "teacher", "personal"));

        FacultyField(Collection<String> fieldNameVariations){
            this.fieldNameVariations = fieldNameVariations;
        }

        private final Collection<String> fieldNameVariations;

    }

    @Getter
    public enum DepartmentField{

        ID(Set.of("id", "identifier", "number")),
        NAME(Set.of("name", "title")),
        STUDENTS(Set.of("students", "student"));

        DepartmentField(Collection<String> fieldNameVariations){
            this.fieldNameVariations = fieldNameVariations;
        }

        private final Collection<String> fieldNameVariations;

    }

    @Getter
    public enum TeacherField {

        ID(Set.of("id", "identifier", "number")),
        FIRST_NAME(Set.of("first_name", "firstName", "first")),
        LAST_NAME(Set.of("last_name", "lastName", "last", "surname", "name")),
        MIDDLE_NAME(Set.of("middle_name", "middleName", "middle"));

        TeacherField(Collection<String> fieldNameVariations){
            this.fieldNameVariations = fieldNameVariations;
        }

        private final Collection<String> fieldNameVariations;

        }

}
