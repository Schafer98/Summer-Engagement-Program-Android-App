package com.animusgames.summerengagementprogramjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/*
*Author: Schafer Cunningham
*Date: 7/15/2020
* Page Description:  The purpose of this Activity is to display the interactive calendar in which you can click to explore meeting times/members
 */


public class CalendarPage extends AppCompatActivity {
    final String TAG = "CalendarPage";
    final AdminEditor adminChange = new AdminEditor();
    TextView SlotOne, SlotTwo, SlotThree;
    private String dateOneEdit, dateTwoEdit, dateThreeEdit;
    Button goBack, goBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        CalendarView MeetingCalendar = findViewById(R.id.MeetingCalendarView);

        //Slots 1-3 contain the values of the 3 meetings
        SlotOne = findViewById(R.id.txtDateOne);
        SlotTwo = findViewById(R.id.txtDateTwo);
        SlotThree = findViewById(R.id.txtDateThree);

        goBack = findViewById(R.id.btnCalendarBack);
        goBackToLogin = findViewById(R.id.btnCalendarBackLogin);


        Intent incomingIntentDate = getIntent();
        dateOneEdit = incomingIntentDate.getStringExtra("dateOneChange");
        dateTwoEdit = incomingIntentDate.getStringExtra("dateTwoChange");
        dateThreeEdit = incomingIntentDate.getStringExtra("dateThreeChange");

        //Checks to see if the Admin changes are NULL
        dateOneCheck();
        dateTwoCheck();
        dateThreeCheck();


        MeetingCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = (month + 1) + "/" + dayOfMonth + "/" + year;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy: " + selectedDate);

                if (selectedDate.equals(dateOneEdit)){
                    newIntent(selectedDate, "dateOne", 0);
                }else if(selectedDate.equals(dateTwoEdit)){
                    newIntent(selectedDate, "dateTwo", 1);
                }else if(selectedDate.equals(dateThreeEdit)){
                    newIntent(selectedDate, "dateThree", 2);
                }
            }
        });


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        goBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarPage.this, Login.class);
                startActivity(intent);
            }
        });
    }

    //This function opens the appropriate Activity relating to which meeting is selected1
    private void newIntent(String selectedDate, String putExtraInfo, int newClass){

        switch (newClass){

            case 0:
                Intent intent = new Intent(CalendarPage.this, AttendeesListOne.class);
                intent.putExtra(putExtraInfo, selectedDate);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(CalendarPage.this, AttendeesListTwo.class);
                intent.putExtra(putExtraInfo, selectedDate);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(CalendarPage.this, AttendeesListThree.class);
                intent.putExtra(putExtraInfo, selectedDate);
                startActivity(intent);
                break;

            default:
                break;

        }


    }

    private void dateOneCheck(){


        if(dateOneEdit != null){
            SlotOne.setText(dateOneEdit);
            Log.e("myTest", "Inside dateOneEdit != null " + dateOneEdit);

        }else{
            dateOneEdit = SlotOne.getText().toString();
            Log.e("myTest", "Inside dateOneEdit == null " + dateOneEdit);
        }
    }
    private void dateTwoCheck(){
        if(dateTwoEdit != null){
            SlotTwo.setText(dateTwoEdit);
            Log.e("myTest", "Inside dateTwoEdit != null");
        }else{
            dateTwoEdit = SlotTwo.getText().toString();
            Log.e("myTest", "Inside dateTwoEdit == null");
        }
    }
    private void dateThreeCheck(){
        if(dateThreeEdit != null){
            SlotThree.setText(dateThreeEdit);
            Log.e("myTest", "Inside dateThreeEdit != null");
        }else{
            dateThreeEdit = SlotThree.getText().toString();
            dateThreeEdit = "8/3/2020";
            Log.e("myTest", "Inside dateThreeEdit == null");
        }
    }
}
