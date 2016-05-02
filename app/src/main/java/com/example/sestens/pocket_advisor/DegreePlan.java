package com.example.sestens.pocket_advisor;

import java.util.ArrayList;

public class DegreePlan {

    private String degreeName;
    private double gpa;
    private int totalHours;
    private int currentHours;
    private ArrayList<Course> courseList = new ArrayList<Course>();

    public DegreePlan(){


    }

    public String getDegreeName(){
        return degreeName;
    }

    public double getGpa(){
        return gpa;
    }

    public int getTotalHours(){
        return totalHours;
    }

    public int getCurrentHours(){
        return currentHours;
    }

    public ArrayList<Course> getCourseList(){
        return courseList;
    }
}


