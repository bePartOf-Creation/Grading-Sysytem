package com.student;

import com.enums.Grade;
import com.exceptions.SubjectException;

public enum Subject {
    MATHEMATICS, ENGLISH, PHYSICS, BIOLOGY, CHEMISTRY, GEOGRAPHY, YORUBA, FURTHER_MATHEMATICS;


    public static Grade estimateGrade(double scores) throws SubjectException {
        Grade grade;
        if(scores >= 90 && scores <= 100){
            grade = Grade.EXCELLENT;
        }else if(scores >= 75 && scores <= 90){
            grade = Grade.VERY_GOOD;
        }else if(scores >= 60 && scores <=75){
            grade = Grade.CREDIT;
        }else if(scores >= 40 && scores <= 60){
            grade =Grade.PASS;
        }else if(scores >= 0 && scores <= 40){
            grade = Grade.FAIL;
        }else{
            throw new SubjectException("Please add A Valid Scores for this Subject");
        }

        return grade;
    }


}
