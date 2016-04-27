package com.example.sestens.pocket_advisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GPACalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalculator);
        GPACalculator calc = new GPACalculator();

        //int totalHours = calc.getTotalHours();
        final TextView current_hours = (TextView) findViewById(R.id.currentHours);

        current_hours.setText("");
        Button addCourseButton = (Button) findViewById(R.id.addCourse);

       addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //current_hours.setText("");

           }
        });


    }



}
