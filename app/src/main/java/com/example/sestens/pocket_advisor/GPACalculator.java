package com.example.sestens.pocket_advisor;

public class GPACalculator {
    private int totalHours = 0;
    private double totalGradePoints = 0;


    public double getGpa() {
        return this.totalGradePoints/this.totalHours;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public double getTotalGradePoints(){
        return totalGradePoints;
    }

    public void addCourse(int hours, double grade) {
        this.totalHours += hours;
        if(grade >= 90) {
            this.totalGradePoints += hours*4.0;
        }
        else if (grade >= 80 && grade < 90) {
            this.totalGradePoints += hours*3.0;
        }
        else if (grade >= 70 && grade < 80) {
            this.totalGradePoints += hours*2.0;
        }
        else if (grade >= 60 && grade < 70) {
            this.totalGradePoints += hours*1.0;
        }
        else if (grade < 60){
            this.totalGradePoints += hours*0.0;
        }

    }
}
