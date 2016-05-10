package com.example.sestens.pocket_advisor;
import org.junit.Test;

public class GPACalculatorTest {
    GPACalculator calc = new GPACalculator();

    @Test
    public void addCourse_expectedGPA(int hours, char grade){
        hours = 3;
        grade = 'A';
        calc.addCourse(hours,grade);
        assertEquals(calc.getGpa(), 4.0);
    }

    @Test
    public void addCourse_expectedTotalHours(int hours, char grade){
        hours = 3;
        grade = 'A';
        calc.addCourse(hours,grade);
        assertEquals(calc.getGpa(), 3);
    }
}