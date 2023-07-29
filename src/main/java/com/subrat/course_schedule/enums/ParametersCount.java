package com.subrat.course_schedule.enums;

public enum ParametersCount {

    ADD_COURSE_OFFERING(5),
    CANCEL(1),
    REGISTER(2),
    ALLOT(1);

    ParametersCount(Integer numParams){
        this.numberOfParameters = numParams;
    }

    private final Integer numberOfParameters;

    public Integer getNumberOfParameters() {
        return numberOfParameters;
    }
    
}
