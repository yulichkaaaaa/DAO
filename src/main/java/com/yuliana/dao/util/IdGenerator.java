package com.yuliana.dao.util;

public class IdGenerator {
    private static long counter = 0;

    private IdGenerator() {}

    public static long generateId() {
        return ++counter;
    }
}
