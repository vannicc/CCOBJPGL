package com.example.studentgradingsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class InfoEncode extends AppCompatActivity {

    private TextView txtLastName, txtFirstName, txtCourse, txtYear, txtEmail, txtContactNumber, txtBirthYear;
    private Button buttonRegister, buttonToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_encode);

        txtLastName = (TextView) findViewById(R.id.txtLastName);
        txtFirstName = (TextView) findViewById(R.id.txtFirstName);
        txtCourse = (TextView) findViewById(R.id.txtCourse);
        txtYear = (TextView) findViewById(R.id.txtYear);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtContactNumber = (TextView) findViewById(R.id.txtContactNumber);
        txtBirthYear = (TextView) findViewById(R.id.txtBirthYear);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtLastName.getText().toString().equals("") || txtFirstName.getText().toString().equals("") || txtCourse.getText().toString().equals("")
                || txtYear.getText().toString().equals("") || txtEmail.getText().toString().equals("") || txtContactNumber.getText().toString().equals("")
                || txtBirthYear.getText().toString().equals("")) {
                    Toast.makeText(InfoEncode.this, "PLEASE INPUT ALL YOUR CREDENTIALS!", Toast.LENGTH_SHORT).show();
                } else if (Character.isLowerCase(txtLastName.getText().toString().charAt(0)) || Character.isLowerCase(txtFirstName.getText().toString().charAt(0))
                        || Character.isLowerCase(txtCourse.getText().toString().charAt(0))){
                    Toast.makeText(InfoEncode.this, "First letter of Name and Course should be capital. Please try again.", Toast.LENGTH_SHORT).show();
                } else if ((Integer.parseInt(txtYear.getText().toString()) > 4 || Integer.parseInt(txtYear.getText().toString()) == 0) ||
                        txtContactNumber.getText().toString().length() > 11 || Integer.parseInt(txtBirthYear.getText().toString()) > 2007 || !(isValid(txtEmail.getText().toString()))) {
                    Toast.makeText(InfoEncode.this, "PLEASE INPUT VALID CREDENTIALS.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InfoEncode.this, "Registration Complete!", Toast.LENGTH_SHORT).show();

                    String displayLastName = txtLastName.getText().toString();
                    String displayFirstName = txtFirstName.getText().toString();
                    String displayCourse = txtCourse.getText().toString();
                    String displayYear = txtYear.getText().toString();
                    String displayEmail = txtEmail.getText().toString();
                    String displayContact = txtContactNumber.getText().toString();
                    String displayBirthYear = txtBirthYear.getText().toString();

                    Intent intent = new Intent(InfoEncode.this, InfoView.class);
                        intent.putExtra("ivLastName", displayLastName);
                        intent.putExtra("ivFirstName", displayFirstName);
                        intent.putExtra("ivCourse", displayCourse);
                        intent.putExtra("ivYear", displayYear);
                        intent.putExtra("ivEmail", displayEmail);
                        intent.putExtra("ivContact", displayContact);
                        intent.putExtra("ivBirthYear", displayBirthYear);

                        startActivity(intent);

                }
            }
        });



        buttonToMenu = (Button) findViewById(R.id.buttonToMenu);
        buttonToMenu.setOnClickListener(new View.OnClickListener() {
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

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
