package com.subrat.course_schedule.enums;

public enum Constants {
    ACCEPTED("ACCEPTED"),
    CANCEL_REJECTED("CANCEL_REJECTED"),
    CANCEL_ACCEPTED("CANCEL_ACCEPTED"),
    INPUT_DATA_ERROR("INPUT_DATA_ERROR"),
    COURSE_ALLOTED("CONFIRMED"),
    COURSE_FULL_ERROR("COURSE_FULL_ERROR"),
    COURSE_CANCELED("COURSE_CANCELED"),
    NOT_CONFIRMED("NOT_CONFIRMED");

    Constants(String status){
        this.status = status;
    }

    private final String status;

    public String getStatus() {
        return status;
    }
}
