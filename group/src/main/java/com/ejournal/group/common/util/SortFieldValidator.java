package com.ejournal.group.common.util;

import lombok.Getter;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

public class SortFieldValidator {

    @Getter
    public enum GroupField{

        GROUP_ID(Set.of("id", "identifier", "number"), "id"),
        GROUP_NUMBER(Set.of("number", "group", "name", "group_number", "group_name"), "groupNumber"),
        STUDENTS(Set.of("students", "student"), "students");

        private GroupField(Collection<String> fieldNameVariations, String validHQLField){
            this.fieldNameVariations = fieldNameVariations;
            this.validHQLField = validHQLField;
        }

        private final Collection<String> fieldNameVariations;
        private final String validHQLField;

        public static GroupField validate(String inputFieldName){
            EnumSet<GroupField> enumSet = EnumSet.allOf(GroupField.class);
            return enumSet.stream()
                    .filter(field -> field.getFieldNameVariations().contains(inputFieldName))
                    .findFirst()
                    .orElse(GROUP_ID);
        }
    }

    @Getter
    public enum StudentField {

        STUDENT_ID(Set.of("id", "identifier", "number"), "id"),
        FIRST_NAME(Set.of("first_name", "firstName", "first"), "firstName"),
        LAST_NAME(Set.of("last_name", "lastName", "last", "surname", "name"), "lastName");

        StudentField(Collection<String> fieldNameVariations, String validHQLField){
            this.fieldNameVariations = fieldNameVariations;
            this.validHQLField = validHQLField;
        }

        private final Collection<String> fieldNameVariations;
        private final String validHQLField;

        public static StudentField validate(String inputFieldName){
            EnumSet<StudentField> enumSet = EnumSet.allOf(StudentField.class);
            return enumSet.stream()
                    .filter(field -> field.getFieldNameVariations().contains(inputFieldName))
                    .findFirst()
                    .orElse(STUDENT_ID);
        }
        }

}
