package com.example.poojasingh.leavemanagementsystemapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowallActivity extends AppCompatActivity {
    Toolbar toolbar;

    Cursor cursor;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);
        listView = findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.list,arrayList);
        listView.setAdapter(arrayAdapter);

        toolbar=findViewById(R.id.toolbarshow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        cursor = AdminPage.databaseHelper.getalldata();

        if(cursor.getCount() < 0)
            Toast.makeText(getApplicationContext(),"No User",Toast.LENGTH_SHORT).show();
        else {
            //Toast.makeText(getApplicationContext(),"Cursor",Toast.LENGTH_SHORT).show();
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                arrayList.add("FIRST NAME : "+cursor.getString(1) + "\n\n" +
                        "LAST NAME : " +cursor.getString(2) + "\n\n"
                        +"EMAIL : "+ cursor.getString(3) + "\n\n "
                        +"CONTACT NUMBER : "+cursor.getString(4)+"\n\n "
                        +"CITY : "+cursor.getString(5)+"\n\n"
                        +"BLOOD GROUP : "+cursor.getString(6));
                arrayAdapter.notifyDataSetChanged();
                cursor.moveToNext();
            }
        }


    }

}

