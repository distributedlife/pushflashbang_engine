package com.distributedlife.pushflashbang.engine.api;

public class Intervals {
    private static final Integer[] INTERVALS = new Integer[] {
            seconds(25),
            minutes(2),
            minutes(10),
            minutes(60),
            hours(5),
            hours(24),
            days(5)};

    private static Integer days(int days) {
        return hours(days * 24);
    }

    private static Integer hours(int hours) {
        return minutes(hours * 60);
    }

    private static Integer minutes(int minutes) {
        return seconds(minutes * 60);
    }

    private static Integer seconds(int seconds) {
        return seconds;
    }

    public Integer getFirst() {
        return INTERVALS[0];
    }

    public Integer getPrevious(Integer seconds) {
        for(int i = 0; i < INTERVALS.length; i++) {
            if (INTERVALS[i].equals(seconds)) {
                if (i == 0) {
                    return INTERVALS[0];
                }

                return INTERVALS[i-1];
            }
        }

        return INTERVALS[0];
    }

    public Integer getNext(Integer seconds) {
        for(int i = 0; i < INTERVALS.length; i++) {
            if (INTERVALS[i].equals(seconds)) {
                if (i == INTERVALS.length - 1) {
                    return INTERVALS[i];
                }

                return INTERVALS[i+1];
            }
        }

        return INTERVALS[0];
    }

    public static boolean isReview(Integer seconds) {
        for (int i = 0; i < INTERVALS.length; i++) {
            if (INTERVALS[i].equals(seconds)) {
                return i % 2 == 0;
            }
        }

        return true;
    }
}