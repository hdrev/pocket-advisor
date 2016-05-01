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

    public void addCourse(int hours, char grade) {
        this.totalHours += hours;
        if(grade == 'A') {
            this.totalGradePoints += hours*4.0;
        }
        else if (grade == 'B') {
            this.totalGradePoints += hours*3.0;
        }
        else if (grade == 'C') {
            this.totalGradePoints += hours*2.0;
        }
        else if (grade == 'D') {
            this.totalGradePoints += hours*1.0;
        }
        else if (grade == 'F'){
            this.totalGradePoints += hours*0.0;
        }

    }
}
