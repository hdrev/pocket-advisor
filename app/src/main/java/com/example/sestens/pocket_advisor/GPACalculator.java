package com.example.sestens.pocket_advisor;


public class GPACalculator {
    private int totalHours = 0;
    private double gpa = 0;


    public double getGpa() {
        return gpa;
    }

    public int getTotalhours() {
        return totalHours;
    }

    public void addCourse(int hours, char grade) {
        grade = Character.toUpperCase(grade);
        this.totalHours += hours;
        if(grade == 'A') {
            this.gpa += 4.0;
        }
        else if (grade == 'B') {
            this.gpa += 3.0;
        }
        else if (grade == 'C') {
            this.gpa += 2.0;
        }
        else if (grade == 'D') {
            this.gpa += 1.0;
        }
        else if (grade == 'F'){
            this.gpa += 0.0;
        }

    }
}
