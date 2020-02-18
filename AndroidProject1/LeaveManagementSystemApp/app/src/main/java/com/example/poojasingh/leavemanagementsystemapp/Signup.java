package com.example.poojasingh.leavemanagementsystemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText firstname,lastname,employeeId,password,confirmPassword,Mobile_Number;
    Button signup;
    CheckBox checkBox;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        employeeId=findViewById(R.id.employeeId);
        Mobile_Number=findViewById(R.id.Mobile_Number);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);


        signup=findViewById(R.id.signup);

        checkBox=findViewById(R.id.checkBox);
        databaseHelper=new DatabaseHelper(getApplicationContext());

    }

    public void text(View view) {
        Intent intent = new Intent(Signup.this,MainActivity.class);
        startActivity(intent);
    }

    public void signup(View view) {

        String pwd=password.getText().toString().trim();
        String cnfpwd=confirmPassword.getText().toString().trim();






        if (firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty()
                || employeeId.getText().toString().isEmpty() || Mobile_Number.getText().toString().isEmpty()|| password.getText().toString().isEmpty() ||
                confirmPassword.getText().toString().isEmpty())
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        else {
            if (!checkBox.isChecked())
                Toast.makeText(this, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
            else {

                if(pwd.equals(cnfpwd))

                {
                    boolean res = databaseHelper.insertedata(firstname.getText().toString().trim(), lastname.getText().toString().trim(),
                            employeeId.getText().toString().trim(),
                            Mobile_Number.getText().toString().trim(),
                            password.getText().toString().trim(), confirmPassword.getText().toString().trim());


                    if (res == true && checkBox.isChecked()) {
                        Intent intent = new Intent(Signup.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(this, "Added Successfull", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
