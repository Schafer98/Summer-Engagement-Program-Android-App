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
 * Page Description:  The purpose of this Activity is to display the time and members for Meeting One
 */

public class AttendeesListOne extends AppCompatActivity {
    TextView Date, AttendeeList;
    Button goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendees_list_one);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        String currentTime = "3:00pm";

        goBack = findViewById(R.id.btnBack);

        Date = findViewById(R.id.txtDateAttendeeListOne);
        AttendeeList = findViewById(R.id.txtAttendeeListOne);

        Intent incomingIntent = getIntent();
        String dateOne = incomingIntent.getStringExtra("dateOne");
        Date.setText("Date: " + dateOne + " at " + currentTime);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendeesListOne.this, CalendarPage.class);
                startActivity(intent);
            }
        });

    }
}