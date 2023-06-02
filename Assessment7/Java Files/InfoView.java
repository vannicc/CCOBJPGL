package com.example.studentgradingsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoView extends AppCompatActivity {
    private TextView txtLastN, txtFirstN, txtCour, txtYr, txtEmailAdd, txtContactNum, txtBirthYr, txtAge;
    private Button buttonBackToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_view);

        txtLastN = (TextView) findViewById(R.id.txtLastN);
        txtFirstN = (TextView) findViewById(R.id.txtFirstN);
        txtCour = (TextView) findViewById(R.id.txtCour);
        txtYr = (TextView) findViewById(R.id.txtYr);
        txtEmailAdd = (TextView) findViewById(R.id.txtEmailAdd);
        txtContactNum = (TextView) findViewById(R.id.txtContactNum);
        txtBirthYr = (TextView) findViewById(R.id.txtBirthYr);
        txtAge = (TextView) findViewById(R.id.txtAge);

        String disLastN = getIntent().getStringExtra("ivLastName");
        String disFirstN = getIntent().getStringExtra("ivFirstName");
        String disCourse = getIntent().getStringExtra("ivCourse");
        String disYear = getIntent().getStringExtra("ivYear");
        String disEmail = getIntent().getStringExtra("ivEmail");
        String disContactN = getIntent().getStringExtra("ivContact");
        String disBirthYear = getIntent().getStringExtra("ivBirthYear");

        int age = 2023 - Integer.parseInt(disBirthYear);
        String disAge = Integer.toString(age);

        txtLastN.setText("Last Name: " + disLastN);
        txtFirstN.setText("First Name: " + disFirstN);
        txtCour.setText("Course: " + disCourse);
        txtYr.setText("Year: " + disYear);
        txtEmailAdd.setText("Email: " + disEmail);
        txtContactNum.setText("Contact #: " + disContactN);
        txtBirthYr.setText("Birth Year: " + disBirthYear);
        txtAge.setText("Age: " + disAge);

        buttonBackToMenu = (Button) findViewById(R.id.buttonBackToMenu);
        buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMenu(v);
            }
        });
    }

    public void backToMenu(View v) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}
