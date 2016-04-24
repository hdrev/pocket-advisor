package com.example.sestens.pocket_advisor;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by sestens on 3/7/2016.
 */
public class MainActivity extends android.app.Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);             //Display Main Menu (Degree Plans)
    }


    public void showPopUp(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.gpa_calculator) {
                            Toast.makeText(MainActivity.this, "GPA Calculator",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent("com.example.sestens.pocket_advisor.GPACalculator");
                            startActivity(intent);
                        }
                        if (item.getItemId() == R.id.log_out) {
                            Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_LONG).show();
                            finish();
                        }
                        if (item.getItemId() == R.id.degree1) {
                            Toast.makeText(MainActivity.this, "Degree Plan 1", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent("com.example.sestens.pocket_advisor.SemesterActivity");
                            startActivity(intent);
                        }
                        if (item.getItemId() == R.id.degree2){
                            Toast.makeText(MainActivity.this, "Degree Plan 2", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.sestens.pocket_advisor.SemesterActivity");
                            startActivity(intent);
                        }
                            return false;
                    }
                }
        );

    }

    public void onClickDegreePlan(View view){
        Intent intent = new Intent("com.example.sestens.pocket_advisor.SemesterActivity");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}

