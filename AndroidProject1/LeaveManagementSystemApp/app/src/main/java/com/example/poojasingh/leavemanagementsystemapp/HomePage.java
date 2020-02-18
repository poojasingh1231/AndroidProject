package com.example.poojasingh.leavemanagementsystemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void employee(View view) {
        Intent intent=new Intent(HomePage.this,MainActivity.class);
        startActivity(intent);
    }

    public void adminpage(View view) {
        Intent intent=new Intent(HomePage.this,AdminPage.class);
        startActivity(intent);
    }
}
