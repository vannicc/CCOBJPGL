package com.example.studentgradingsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GradeEncode extends AppCompatActivity {
    TextView txtLastName,txtFirstName, txtAttendanceGrade, txtQ1Score, txtQ2Score, txtQ3Score, txtQ4Score, txtExamScore;
    Button buttonCompute, buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_encode);

        txtLastName = (TextView) findViewById(R.id.txtLastName);
        txtFirstName = (TextView) findViewById(R.id.txtFirstName);
        txtAttendanceGrade = (TextView) findViewById(R.id.txtAttendanceGrade);
        txtQ1Score = (TextView) findViewById(R.id.txtQ1Score);
        txtQ2Score = (TextView) findViewById(R.id.txtQ2Score);
        txtQ3Score = (TextView) findViewById(R.id.txtQ3Score);
        txtQ4Score = (TextView) findViewById(R.id.txtQ4Score);
        txtExamScore = (TextView) findViewById(R.id.txtExamScore);

        buttonCompute = (Button) findViewById(R.id.buttonCompute);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtLastName.getText().toString().equals("") || txtFirstName.getText().toString().equals("") || txtAttendanceGrade.getText().toString().equals("") ||
                txtQ1Score.getText().toString().equals("") || txtQ2Score.getText().toString().equals("")
                || txtQ3Score.getText().toString().equals("") || txtQ4Score.getText().toString().equals("") || txtExamScore.getText().toString().equals("")) {
                    Toast.makeText(GradeEncode.this, "PLEASE INPUT ALL REQUIRED CREDENTIALS!", Toast.LENGTH_SHORT).show();
                } else if ((Integer.parseInt(txtAttendanceGrade.getText().toString()) > 100 || Integer.parseInt(txtAttendanceGrade.getText().toString()) < 1)
                || (Integer.parseInt(txtQ1Score.getText().toString()) > 100 || Integer.parseInt(txtQ1Score.getText().toString()) < 1)
                || (Integer.parseInt(txtQ2Score.getText().toString()) > 100 || Integer.parseInt(txtQ2Score.getText().toString()) < 1)
                || (Integer.parseInt(txtQ3Score.getText().toString()) > 100 || Integer.parseInt(txtQ3Score.getText().toString()) < 1)
                || (Integer.parseInt(txtQ4Score.getText().toString()) > 100 || Integer.parseInt(txtQ4Score.getText().toString()) < 1)
                || (Integer.parseInt(txtExamScore.getText().toString()) > 100 || Integer.parseInt(txtExamScore.getText().toString()) < 1)) {
                    Toast.makeText(GradeEncode.this, "INPUT MUST BE AT LEAST 1 AND SHOULD NOT EXCEED 100.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GradeEncode.this, "GRADE COMPUTED!", Toast.LENGTH_SHORT).show();

                    String displayLastName = txtLastName.getText().toString();
                    String displayFirstName = txtFirstName.getText().toString();
                    String displayAttendance = txtAttendanceGrade.getText().toString();
                    String displayQ1 = txtQ1Score.getText().toString();
                    String displayQ2 = txtQ2Score.getText().toString();
                    String displayQ3 = txtQ3Score.getText().toString();
                    String displayQ4 = txtQ4Score.getText().toString();
                    String displayExam = txtExamScore.getText().toString();

                    Intent intent =  new Intent(GradeEncode.this, GradeView.class);
                        intent.putExtra("gvLastN", displayLastName);
                        intent.putExtra("gvFirstN", displayFirstName);
                        intent.putExtra("gvAttend", displayAttendance);
                        intent.putExtra("gvQ1", displayQ1);
                        intent.putExtra("gvQ2", displayQ2);
                        intent.putExtra("gvQ3", displayQ3);
                        intent.putExtra("gvQ4", displayQ4);
                        intent.putExtra("gvExam", displayExam);

                        startActivity(intent);

                }
            }
        });

        buttonMenu = (Button) findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMenu(v);
            }
        });

    }

    public void returnToMenu(View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}
