package com.animusgames.summerengagementprogramjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



/*
 *Author: Schafer Cunningham
 *Date: 7/15/2020
 * Page Description:  The purpose of this Activity is to display the time and members for Meeting Three
 */

public class AttendeesListThree extends AppCompatActivity {
    TextView date, AttendeeList;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendees_list_three);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        String currentTime = "3:00pm";
        goBack = findViewById(R.id.btnBack);


        date = findViewById(R.id.txtDateAttendeeListThree);
        AttendeeList = findViewById(R.id.txtAttendeeListThree);

        Intent incomingIntent = getIntent();
        String dateThree = incomingIntent.getStringExtra("dateThree");
        date.setText("Date: " + dateThree + " at " + currentTime);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendeesListThree.this, CalendarPage.class);
                startActivity(intent);
            }
        });

    }
}