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

    public void addCourse(int hours, String grade) {
        this.totalHours += hours;
        if(grade.equalsIgnoreCase("A") || grade.equalsIgnoreCase("A-") || grade.equalsIgnoreCase("A+")) {
            this.totalGradePoints += hours*4.0;
        }
        else if (grade.equalsIgnoreCase("B") || grade.equalsIgnoreCase("B-") || grade.equalsIgnoreCase("B+")) {
            this.totalGradePoints += hours*3.0;
        }
        else if (grade.equalsIgnoreCase("C") || grade.equalsIgnoreCase("C-") || grade.equalsIgnoreCase("C+")) {
            this.totalGradePoints += hours*2.0;
        }
        else if (grade.equalsIgnoreCase("D") || grade.equalsIgnoreCase("D-") || grade.equalsIgnoreCase("D+")) {
            this.totalGradePoints += hours*1.0;
        }
        else if (grade.equalsIgnoreCase("F") || grade.equalsIgnoreCase("F-") || grade.equalsIgnoreCase("F+")){
            this.totalGradePoints += hours*0.0;
        }

    }
}
