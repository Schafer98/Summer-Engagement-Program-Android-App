package com.animusgames.summerengagementprogramjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/*
 *Author: Schafer Cunningham
 *Date: 7/15/2020
 * Page Description:  The purpose of this Activity is to display all the Upcoming Events/Meetings a user may have
 */

public class MainActivity extends AppCompatActivity {
    TextView SlotOne, SlotTwo, SlotThree;
    private String dateOneEdit, dateTwoEdit, dateThreeEdit;
    Button btnGoBack;
    FloatingActionButton btnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnCalendar = findViewById(R.id.btnCalendarAction);
        btnGoBack = findViewById(R.id.btnUpcomingEventsBack);

        SlotOne = findViewById(R.id.textView);
        SlotTwo = findViewById(R.id.textView2);
        SlotThree = findViewById(R.id.textView3);

        Intent incomingIntent = getIntent();
        dateOneEdit = incomingIntent.getStringExtra("dateOneChange");
        dateTwoEdit = incomingIntent.getStringExtra("dateTwoChange");
        dateThreeEdit = incomingIntent.getStringExtra("dateThreeChange");

        dateOneCheck();
        dateTwoCheck();
        dateThreeCheck();

        //Brings user to the Calendar View page
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalendarPage.class);
                startActivity(intent);
            }
        });
        //Brings user to LOGIN screen
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });




    }

    private void dateOneCheck(){
        if(dateOneEdit != null){
            SlotOne.setText("Meeting On: " + dateOneEdit);
        }
    }
    private void dateTwoCheck(){
        if(dateTwoEdit != null){
            SlotTwo.setText("Meeting On: " + dateTwoEdit);
        }
    }
    private void dateThreeCheck(){
        if(dateThreeEdit != null){
            SlotThree.setText("Meeting On: " + dateThreeEdit);
        }
    }
}