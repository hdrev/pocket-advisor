package com.example.sestens.pocket_advisor;

public class Course {

    private String coursePrefixNumber;
    private String courseTitle;
    private String courseDescription;
    private String prerequisites;
    private String corequisites;
    private char grade = 'E';
    private double gpa = -1;


    public Course(String coursePrefixNumber, String courseTitle, String courseDescription, String prerequisites, String corequisites){
        this.coursePrefixNumber = coursePrefixNumber;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.prerequisites = prerequisites;
        this.corequisites = corequisites;

    }

    public String getCoursePrefixNumber(){
        return coursePrefixNumber;
    }

    public String getCourseTitle(){
        return courseTitle;
    }

    public String getCourseDescription(){
        return courseDescription;
    }

    public String getPrerequisites(){
        return prerequisites;
    }

    public String getCorequisites(){
        return corequisites;
    }

    public char getGrade(){
        if(grade!='E')
            return grade;
        else
            return ' ';
    }

    public double getGpa(){
        return gpa;
    }
    public void setGrade(char x){
        this.grade = x;
    }

    public void setGpa(double x){
        this.gpa = x;
    }
}
