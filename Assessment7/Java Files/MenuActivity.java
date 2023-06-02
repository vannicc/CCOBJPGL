package com.example.studentgradingsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonLogOut = (Button) findViewById(R.id.buttonLogOut);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut(v);
            }
        });

        Button buttonInfoEncode = (Button) findViewById(R.id.buttonInfoEncode);
        buttonInfoEncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoEncode(v);
            }
        });

        Button buttonGradeEncode = (Button) findViewById(R.id.buttonGradeEncode);
        buttonGradeEncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeEncode(v);
            }
        });
    }

    public void logOut(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void InfoEncode(View v){
        Intent i = new Intent(this, InfoEncode.class);
        startActivity(i);
    }

    public void GradeEncode(View v){
        Intent i = new Intent (this, GradeEncode.class);
        startActivity(i);
    }
}
