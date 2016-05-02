package com.example.sestens.pocket_advisor;

public class GradeCalculator {
    private int currentPercentage=0; //keeps track of percent of final grade that has been added so far
    private double finalGrade=0.0;  //grade with potentially empty other grades
    private double currentGrade=0.0; //grade without potentially empty other grades


    public double getFinalGrade(){
        return this.finalGrade;
    }
    public int getCurrentPercentage(){
        return this.currentPercentage;
    }

    public void addGrade(double grade, int percentage){
        currentPercentage += percentage;
        finalGrade += (grade*percentage)/100;
    }
}
