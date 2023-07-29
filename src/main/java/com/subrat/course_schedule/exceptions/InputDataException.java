package com.subrat.course_schedule.exceptions;

import com.subrat.course_schedule.enums.Constants;

public class InputDataException extends Exception{
    
    public InputDataException(){
        //Constants
        System.out.println(Constants.INPUT_DATA_ERROR.getStatus());
    }
}