package com.yuliana.dao.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidator {

    private static final Pattern GROUP_NUMBER = Pattern.compile("\\d{6}");
    private static final Pattern NAME_AND_SURNAME = Pattern.compile("\\b[A-Z].*?\\b");
    private static final Pattern FACULTY = Pattern.compile("[a-zA-Z]\\s+");
    private StudentValidator() {}

    public static boolean isGroupNumber(String group) {
        Matcher matcher = GROUP_NUMBER.matcher(group);
        return matcher.matches();
    }
    public static boolean isNameAndSurname(String name) {
        Matcher matcher = NAME_AND_SURNAME.matcher(name);
        return matcher.matches();
    }

    public static boolean isFaculty(String address) {
        Matcher matcher = FACULTY.matcher(address);
        return matcher.matches();
    }
}
