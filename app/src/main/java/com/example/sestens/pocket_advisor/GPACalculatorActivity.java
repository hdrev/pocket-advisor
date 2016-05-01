package com.example.sestens.pocket_advisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GPACalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalculator);

        final GPACalculator calc = new GPACalculator();

        final TextView current_hours = (TextView) findViewById(R.id.currentHours);
        final TextView current_gpa = (TextView) findViewById(R.id.currentGpa);
        final EditText hours = (EditText) findViewById(R.id.courseHours);
        final EditText gpa = (EditText) findViewById(R.id.courseGrade);
        final EditText course = (EditText) findViewById(R.id.courseName);
        final TextView coursesList = (TextView) findViewById(R.id.coursesList);
        Button addCourseButton = (Button) findViewById(R.id.addCourseButton);

       addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Button Adds Course and updates Total GPA and Total Hours
                //adds course
                String courseString = course.getText().toString();
                String hoursString = hours.getText().toString();
                String gpaString = gpa.getText().toString();
                if(courseString.matches("")){
                    Toast.makeText(GPACalculatorActivity.this, "You did not enter a course name.", Toast.LENGTH_SHORT).show();
                }
                else if(hoursString.matches("")){
                    Toast.makeText(GPACalculatorActivity.this, "You did not enter course hours.", Toast.LENGTH_SHORT).show();
                }
                else if(gpaString.matches("")){
                    Toast.makeText(GPACalculatorActivity.this, "You did not enter a course grade.", Toast.LENGTH_SHORT).show();
                }
                else{
                    int hoursInt = Integer.parseInt(hoursString);
                    double gpaDouble = Double.parseDouble(gpaString);
                    calc.addCourse(hoursInt, gpaString.toUpperCase());
                    coursesList.append(courseString + "\n\n");

                    //updates total gpa and total hours
                    current_hours.setText("" + calc.getTotalHours());
                    current_gpa.setText(String.valueOf(calc.getGpa()));
                    hours.setText("");
                    gpa.setText("");
                    course.setText("");
                }




           }
        });


    }



}
