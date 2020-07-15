package com.animusgames.summerengagementprogramjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 *Author: Schafer Cunningham
 *Date: 7/15/2020
 * Page Description:  The purpose of this Activity is to display all the essential items to create an account or login to a previously made account
 */

public class Login extends AppCompatActivity {
    String savedUsername = "";
    String savedPassword = "";

    EditText txtEditUsername, txtEditPassword, txtEditCreateUsername, txtEditCreatePassword;
    TextView txtUsername, txtPassword, txtCreateAccountUsername, txtCreateAccountPassword;
    Button btnLogin, btnCreate, btnNext, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Linking the LOGIN TextViews/Edit text boxes to their appropriate variables
        txtEditUsername = findViewById(R.id.editTextUsername);
        txtEditPassword = findViewById(R.id.editTextPassword);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        //Linking the CREATE TextViews/Edit text boxes to their appropriate variables
        txtEditCreateUsername = findViewById(R.id.editTextCreateUsername);
        txtEditCreatePassword = findViewById(R.id.editTextCreateAccountPassword);
        txtCreateAccountUsername = findViewById(R.id.txtCreateAccountUsername);
        txtCreateAccountPassword = findViewById(R.id.txtCreateAccountPassword);


        btnLogin = findViewById(R.id.btnLogin);
        btnCreate = findViewById(R.id.btnCreate);
        btnNext = findViewById(R.id.btnNext);
        btnSave = findViewById(R.id.btnSave);

        loginHide();
        createHide();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show all the textView/boxes relating to LOGIN
                loginShow();
                //Hide all the textView/boxes relating to CREATE
                createHide();

            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show all the textView/boxes relating to CREATE
                createShow();

                //Hide all the textView/boxes relating to LOGIN
                loginHide();
            }
        });

        //The NEXT button takes in the text from the LOGIN Text Boxes and checks to see if it is a valid User.  Will implement Room db in the future
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtEditUsername.getText().toString();
                String password = txtEditPassword.getText().toString();

                SharedPreferences accountUsername = getSharedPreferences("UserCreatedAccountName", Context.MODE_PRIVATE);
                savedUsername = accountUsername.getString("username", null);
                savedPassword = accountUsername.getString("password", null);

                if (username.isEmpty() && password.isEmpty()){
                    txtEditUsername.setError("Error - Empty Fields");
                    txtEditUsername.requestFocus();

                    txtEditPassword.setError("Error - Empty Fields");
                    txtEditPassword.requestFocus();
                }



                if (username.equals("admin") && password.equals("root")){
                    Intent intent = new Intent(Login.this, addNote.class); //Admin should lead to a different page
                    startActivity(intent);
                }else if (username.equals(savedUsername) && password.equals(savedPassword) && username != ""){
                    Toast.makeText(getApplicationContext(), "Welcome " + savedUsername,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }


            }
        });

        //The SAVE button takes in the user input from the CREATE Text Boxes and saves it to the internal storage
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String createUsername = txtEditCreateUsername.getText().toString();
                String createPassword = txtEditCreatePassword.getText().toString();

                if (createUsername.isEmpty() && createPassword.isEmpty()){
                    txtEditCreateUsername.setError("Error - Empty Fields");
                    txtEditCreateUsername.requestFocus();

                    txtEditCreatePassword.setError("Error - Empty Fields");
                    txtEditCreatePassword.requestFocus();
                }

                //This saves the Username and Password into the devices internal storage
                SharedPreferences accountUsername = getSharedPreferences("UserCreatedAccountName", MODE_PRIVATE);
                SharedPreferences.Editor editor = accountUsername.edit();
                editor.putString("username", createUsername);
                editor.putString("password", createPassword);
                editor.apply();

                editor.putString("UserCreatedAccountName", createUsername);

                txtEditCreateUsername.setVisibility(View.GONE);
                txtEditCreatePassword.setVisibility(View.GONE);
                txtCreateAccountUsername.setVisibility(View.GONE);
                txtCreateAccountPassword.setVisibility(View.GONE);

                btnSave.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(), "Account successfully created! - Please Login",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void loginHide(){
        txtEditUsername.setVisibility(View.GONE);
        txtEditPassword.setVisibility(View.GONE);
        txtUsername.setVisibility(View.GONE);
        txtPassword.setVisibility(View.GONE);

        btnNext.setVisibility(View.GONE);
    }
    private void loginShow(){
        txtEditUsername.setVisibility(View.VISIBLE);
        txtEditPassword.setVisibility(View.VISIBLE);
        txtUsername.setVisibility(View.VISIBLE);
        txtPassword.setVisibility(View.VISIBLE);

        btnNext.setVisibility(View.VISIBLE);
    }
    private void createShow(){
        txtEditCreateUsername.setVisibility(View.VISIBLE);
        txtEditCreatePassword.setVisibility(View.VISIBLE);
        txtCreateAccountUsername.setVisibility(View.VISIBLE);
        txtCreateAccountPassword.setVisibility(View.VISIBLE);

        btnSave.setVisibility(View.VISIBLE);
    }
    private void createHide(){
        txtEditCreateUsername.setVisibility(View.GONE);
        txtEditCreatePassword.setVisibility(View.GONE);
        txtCreateAccountUsername.setVisibility(View.GONE);
        txtCreateAccountPassword.setVisibility(View.GONE);

        btnSave.setVisibility(View.GONE);
    }
}