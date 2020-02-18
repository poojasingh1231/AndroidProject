package com.example.poojasingh.leavemanagementsystemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {
    EditText edittext1,edittext2;
    Button button1;
    static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        edittext1=findViewById(R.id.edittext1);
        edittext2=findViewById(R.id.edittext2);
        button1=findViewById(R.id.button1);
        databaseHelper=new DatabaseHelper(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID=edittext1.getText().toString();
                String pwd=edittext2.getText().toString();

                if(ID.equals("11612977")&& pwd.equals("Pooja123"))
                {
                    Intent intent=new Intent(AdminPage.this,ShowallActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(AdminPage.this, "wrong username or  password", Toast.LENGTH_SHORT).show();
                }

            }



        });
        }

    public void admin(View view) {
    }
}




