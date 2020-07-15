package com.animusgames.summerengagementprogramjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/*
 *Author: Schafer Cunningham
 *Date: 7/15/2020
 * Page Description:  The purpose of this Activity is to display the Admin's Meeting Editor Screen
 */

public class addNote extends AppCompatActivity {
    Button meetingOne, meetingTwo, meetingThree, back;
    EditText noteEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        meetingOne = findViewById(R.id.addNoteButtonOne);
        meetingTwo = findViewById(R.id.addNoteButtonTwo);
        meetingThree = findViewById(R.id.addNoteButtonThree);
        back = findViewById(R.id.btnBackLogin);



        noteEditText = findViewById(R.id.noteEditText);

        final AdminEditor adminChange = new AdminEditor();


        //Edits the Meeting date for Meeting One
        meetingOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminChange.dateChangerOne = noteEditText.getText().toString();
                Intent intentMainPG = new Intent(addNote.this, MainActivity.class);
                intentMainPG.putExtra("dateOneChange", adminChange.dateChangerOne);
                startActivity(intentMainPG);

                Intent intentCalendarPG = new Intent(addNote.this, CalendarPage.class);
                intentCalendarPG.putExtra("dateOneChange", adminChange.dateChangerOne);
                startActivity(intentCalendarPG);

                //meetingSlotOne.setText("Meeting on: " + adminChange.dateChangerOne);
            }
        });

        //Edits the Meeting date for Meeting Two
        meetingTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminChange.dateChangerTwo = noteEditText.getText().toString();
                Intent intentMainPGTwo = new Intent(addNote.this, MainActivity.class);
                intentMainPGTwo.putExtra("dateTwoChange", adminChange.dateChangerTwo);
                startActivity(intentMainPGTwo);

                Intent intentCalendarPGTwo = new Intent(addNote.this, CalendarPage.class);
                intentCalendarPGTwo.putExtra("dateTwoChange", adminChange.dateChangerTwo);
                startActivity(intentCalendarPGTwo);
            }
        });

        //Edits the Meeting date for Meeting Three
        meetingThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminChange.dateChangerThree = noteEditText.getText().toString();
                Intent intentMainPGThree = new Intent(addNote.this, MainActivity.class);
                intentMainPGThree.putExtra("dateThreeChange", adminChange.dateChangerThree);
                startActivity(intentMainPGThree);

                Intent intentCalendarPGThree = new Intent(addNote.this, CalendarPage.class);
                intentCalendarPGThree.putExtra("dateThreeChange", adminChange.dateChangerThree);
                startActivity(intentCalendarPGThree);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin  = new Intent( addNote.this, Login.class);
                startActivity(intentLogin);
            }
        });
    }
    }

