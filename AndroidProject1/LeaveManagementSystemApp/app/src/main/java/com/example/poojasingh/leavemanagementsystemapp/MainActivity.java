package com.example.poojasingh.leavemanagementsystemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user1,pass;
    Button button;
    static DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new DatabaseHelper(this);
       user1=findViewById(R.id.e1);
       pass=findViewById(R.id.e2);
       button=findViewById(R.id.b1);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String user=user1.getText().toString().trim();
               String pwd=pass.getText().toString().trim();
             Boolean result = databaseHelper.checkUser(user,pwd);
               if(result == true)
               {
                   Intent homepage = new Intent(MainActivity.this,EmployeePage.class);
                   homepage.putExtra("userid",user1.getText().toString());
                   startActivity(homepage);
               }
               else
               {
                   Toast.makeText(MainActivity.this, "Wrong employee id or password", Toast.LENGTH_SHORT).show();
               }

        }
       });

    }



    public void signUp(View view) {
        Intent intent = new Intent(MainActivity.this,Signup.class);
        startActivity(intent);
    }
}
