package com.example.sestens.pocket_advisor;
import org.junit.Test;

public class GradeCalculatorTest {
    GradeCalculator calc = new GradeCalculator();

    @Test
     public void addGrade_expectedFinalGrade(double grade, int percentage){
        grade = 100.0;
        percentage = 40;
        calc.addGrade(grade,percentage);
        assertEquals(calc.getFinalGrade(), 40);
    }

    @Test
    public void addGrade_expectedCurrentPercentage(double grade, int percentage){
        grade = 100.0;
        percentage = 20;
        calc.addGrade(grade,percentage);
        assertEquals(calc.getFinalGrade(), 20);
    }
}
