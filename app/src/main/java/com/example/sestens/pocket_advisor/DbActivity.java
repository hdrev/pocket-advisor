package com.example.sestens.pocket_advisor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Created by sestens on 4/27/2016.
 */
public class DbActivity extends android.app.Activity {
    Button btnViewGrades;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_info);

        //Buttons
        btnViewGrades = (Button) findViewById(R.id.btnViewGrades);

        //view grades click event
        btnViewGrades.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //launching grades activity
                Intent i = new Intent(getApplicationContext(),GradesActivity.class);
                startActivity(i);
            }
        });

    }
//    public void viewGradesBtn(View view){
//        Intent i = new Intent(getApplicationContext(),GradesActivity.class);
//        startActivity(i);
//    }

}
