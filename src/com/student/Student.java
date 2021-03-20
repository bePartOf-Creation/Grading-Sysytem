package com.student;

import com.enums.Department;
import com.enums.Gender;
import com.enums.Grade;
import com.exceptions.StudentIdentityException;
import com.exceptions.SubjectException;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Department department;
    private Grade grade;
    private final Map<Subject,Double> subjects;

    public Student(String firstName, String LastName) {
        this.firstName = firstName;
        this.lastName = LastName;
        subjects = new HashMap<>();
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) throws StudentIdentityException {
        boolean firstNameIsNull = firstName == null;
        if(firstNameIsNull){
            throw new StudentIdentityException("Enter your Valid name as FirstName");
        }else{
        this.firstName = firstName;
        }
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) throws StudentIdentityException {
        boolean lastNameIsNull = lastName == null;
        if (lastNameIsNull) {
            throw new StudentIdentityException("Enter your Valid name as LastName.");
        } else {
            this.lastName = lastName;
        }
    }
    public void setGender(Gender gender) throws StudentIdentityException {
        boolean genderIsNull = gender == null;
        if(genderIsNull){
            throw new StudentIdentityException("This field is required. Select your Gender.");
        }
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void selectYourGender(String gender) throws StudentIdentityException {
        if(gender.toLowerCase().equals("male")) {
            setGender(Gender.MALE);
        }else{
            setGender(Gender.FEMALE);
        }
    }
    public void setDepartment(Department department) throws StudentIdentityException {
        boolean departmentIsNull = department == null;
        if(departmentIsNull){
            throw new StudentIdentityException("PLease his field is Required, Kindly Select Your Department");
        }
        this.department = department;
    }
    public Department getDepartment() {
        return department;
    }
    public void selectYourDepartment(String department) throws StudentIdentityException {
        switch (department.toLowerCase()) {
            case "science" -> setDepartment(Department.SCIENCE);
            case "commercial" -> setDepartment(Department.COMMERCIAL);
            case "art" -> setDepartment(Department.ART);
            default -> setDepartment(Department.DEPARTMENT_NOT_FOUND);
        }
    }
    public boolean addSubject(Subject desiredSubjects) throws SubjectException {
       if(desiredSubjects == null){
          throw new SubjectException("Add Your Desired Subjects");
       }else{
           subjects.put(desiredSubjects,null);
           return true;
       }
    }
    public Map<Subject, Double> getSubjects() {
        return subjects;
    }
    public boolean addScoreAndSubject(Subject desiredSubjects, Double scores) throws SubjectException {
        if(desiredSubjects == null && scores == null){
            throw new SubjectException("Add Your Desired Subjects");
        }else
            if(subjects.containsKey(desiredSubjects)) {
                subjects.replace(desiredSubjects, scores);
            }
            else {
                subjects.put(desiredSubjects,scores);
            }
            return true;
    }
    public Grade gradeScores(Subject desiredSubjects, Double scores) throws SubjectException {
        addScoreAndSubject(desiredSubjects,scores);
        Subject.estimateGrade(scores);
        return grade;
    }

}
