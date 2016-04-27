package com.example.sestens.pocket_advisor;

public class GradeCalculator {
    private int finalPercentage=0;
    private double finalGrade=0.0;


    public double getFinalGrade(){
        return this.finalGrade;
    }
    public int getFinalPercentage(){
        return this.finalPercentage;
    }

    public void addGrade(double grade, int percentage){
        this.finalPercentage += percentage;
    }
}
