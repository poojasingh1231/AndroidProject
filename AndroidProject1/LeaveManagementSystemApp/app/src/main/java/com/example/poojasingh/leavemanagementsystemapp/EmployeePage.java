package com.example.poojasingh.leavemanagementsystemapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.icu.text.DateFormat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EmployeePage extends AppCompatActivity{


    DatePickerDialog datePickerDialog;
    Cursor cursor;
    EditText toda;
    Intent intent;
    DatabaseHelper databaseHelper;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText e_id,e_name,e_number;
        setContentView(R.layout.activity_employee_page);
        intent = getIntent();
        userid=intent.getStringExtra("userid");



        databaseHelper = new DatabaseHelper(getApplicationContext());
        e_id=findViewById(R.id.edit1);
        e_name=findViewById(R.id.edit2);
        e_number=findViewById(R.id.edit3);


        cursor = MainActivity.databaseHelper.getalldata();
        if(cursor.getCount()<0)
            Toast.makeText(this, "No Employee exist", Toast.LENGTH_SHORT).show();
        else
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                if(userid.equals(cursor.getString(3)))
                {
                    e_id.setText(cursor.getString(3));
                    e_name.setText(cursor.getString(1) + " "+cursor.getString(2));
                    e_number.setText(cursor.getString(4));
                }
                cursor.moveToNext();
            }
        }


        final EditText fromDate1 = findViewById(R.id.fromDate);

        fromDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year1 = calendar.get(Calendar.YEAR);
                int month1=calendar.get(Calendar.MONTH);
                final int day1 = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(EmployeePage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fromDate1.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },year1,month1,day1);
                datePickerDialog.show();
            }
        });

        toda=findViewById(R.id.toDate);
        toda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(EmployeePage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        toda.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });





    }




}
