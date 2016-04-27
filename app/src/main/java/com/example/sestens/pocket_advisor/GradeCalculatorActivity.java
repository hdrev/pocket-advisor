package com.example.sestens.pocket_advisor;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GradeCalculatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradecalculator);

        final GradeCalculator calc = new GradeCalculator();
        final TextView totalPercent = (TextView) findViewById(R.id.totalPercent);
        final TextView finalGrade = (TextView) findViewById(R.id.finalGrade);
        final EditText gradeReceived = (EditText) findViewById(R.id.gradeReceived);
        final EditText percentFinalGrade = (EditText) findViewById(R.id.percentFinalGrade);
        Button addGradeButton = (Button) findViewById(R.id.addGradeButton);

        addGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeReceivedString = gradeReceived.getText().toString();
                String percentFinalGradeString = percentFinalGrade.getText().toString();
                int percentFinalGradeInt = Integer.parseInt(percentFinalGradeString);
                double gradeReceivedDouble = Double.parseDouble(gradeReceivedString);

                calc.addGrade(gradeReceivedDouble, percentFinalGradeInt);
               // finalGrade.setText("TEST");
            }
        });

    }

}
