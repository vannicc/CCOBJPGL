package com.example.studentgradingsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GradeView extends AppCompatActivity {
    private TextView txtLN, txtFN, txtAG, txtAGScore, txtQuizScores, txtQuizScore, txtES, txtESScore, txtAverage, txtRemark;
    private Button buttonReturntoMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_view);

        txtLN = (TextView) findViewById(R.id.txtLN);
        txtFN = (TextView) findViewById(R.id.txtFN);
        txtAG = (TextView) findViewById(R.id.txtAG);
        txtAGScore = (TextView) findViewById(R.id.txtAGScore);
        txtQuizScores = (TextView) findViewById(R.id.txtQuizScores);
        txtQuizScore = (TextView) findViewById(R.id.txtQuizScore);
        txtES = (TextView) findViewById(R.id.txtES);
        txtESScore = (TextView) findViewById(R.id.txtESScore);
        txtAverage = (TextView) findViewById(R.id.txtAverage);
        txtRemark = (TextView) findViewById(R.id.txtRemark);

        String disLN = getIntent().getStringExtra("gvLastN");
        String disFN = getIntent().getStringExtra("gvFirstN");
        String disAG = getIntent().getStringExtra("gvAttend");
        String disQ1 = getIntent().getStringExtra("gvQ1");
        String disQ2 = getIntent().getStringExtra("gvQ2");
        String disQ3 = getIntent().getStringExtra("gvQ3");
        String disQ4 = getIntent().getStringExtra("gvQ4");
        String disEG = getIntent().getStringExtra("gvExam");

        double attendanceAverage = Math.round((Integer.parseInt(disAG) * 0.2)*100)/100.0;
        String attendGrade = Double.toString(attendanceAverage);

        int quizTotal = Integer.parseInt(disQ1) + Integer.parseInt(disQ2) + Integer.parseInt(disQ3) + Integer.parseInt(disQ4);
        double quizAverage = Math.round((((quizTotal / 4) * 0.3))*100)/100.0;
        String quizGrade = Double.toString(quizAverage);

        double examAverage = Math.round((Integer.parseInt(disEG) * 0.5)*100)/100.0;
        String examGrade = Double.toString(examAverage);

        double studentAverage = (attendanceAverage + quizAverage + examAverage);
        String studentGrade = Double.toString(studentAverage);

        String gradeStatus = gradeStatus(studentAverage);
        String gradeRemark = gradeRemark(studentAverage);

        txtLN.setText("Last Name: " + disLN);
        txtFN.setText("First Name: " + disFN);
        txtAG.setText("Score: " + disAG);
        txtAGScore.setText("Att: " + attendGrade);
        txtQuizScores.setText("Scores: " + disQ1 + "-" + disQ2 + "-" + disQ3 + "-" + disQ4);
        txtQuizScore.setText("Quizzes: " + quizGrade);
        txtES.setText("Score: " + disEG);
        txtESScore.setText("Exam: " + examGrade);
        txtAverage.setText("Ave: " + studentGrade + " : " + gradeStatus);
        txtRemark.setText("Grade: " + gradeRemark);

        buttonReturntoMenu = (Button) findViewById(R.id.buttonReturnToMenu);
        buttonReturntoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMenu(v);
            }
        });
    }

    public void returnToMenu(View v) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public static String gradeStatus(double grade) {
        String status = "";
        if (grade >= 60) {
            status = "PASSED";
        } else {
            status = "FAILED";
        }

        return status;
    }

    public static String gradeRemark(double grade) {
        String remark = "";
        if (grade >= 96 && grade <= 100) {
            remark = "4.00";
        } else if (grade >= 90 && grade < 96) {
            remark = "3.50";
        } else if (grade >= 84 && grade < 90) {
            remark = "3.00";
        } else if (grade >= 78 && grade < 84) {
            remark = "2.50";
        } else if (grade >= 72 && grade < 78) {
            remark = "2.00";
        } else if (grade >= 66 && grade < 72) {
            remark = "1.50";
        } else if (grade >= 60 && grade < 66) {
            remark = "1.00";
        } else {
            remark = "INC";
        }
        return remark;
    }
}
