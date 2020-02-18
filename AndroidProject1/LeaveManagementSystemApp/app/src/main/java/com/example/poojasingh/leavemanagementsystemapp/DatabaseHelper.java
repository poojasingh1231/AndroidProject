package com.example.poojasingh.leavemanagementsystemapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="mydb.db";
    public static final String Table_Name="Employee";
    public static final String Col_1 ="ID";
    public static final String Col_2="First_Name";
    public static final String Col_3="Last_Name";
    public static final String Col_4="Employee_Id";
    public static final String Col_5="Mobile_Number";
    public static final String Col_6="Password";
    public static final String Col_7="Confirm_Password";

    public static final String Table_Name1="new";
    public static final String COL_1="";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " +Table_Name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,First_Name TEXT,Last_Name TEXT,Employee_Id INTEGER,Mobile_Number INTEGER,Password TEXT,Confirm_Password TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " +Table_Name);
        onCreate(db);

    }
    public boolean insertedata(String First_Name,String Last_Name,String Employee_Id,
                               String Mobile_Number,String Password,String Confirm_Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col_2, First_Name);
        cv.put(Col_3, Last_Name);
        cv.put(Col_4, Employee_Id);
        cv.put(Col_5, Mobile_Number);
        cv.put(Col_6, Password);
        cv.put(Col_7, Confirm_Password);
        long result = db.insert(Table_Name, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " +Table_Name,null);
        return res;
    }

    public boolean checkUser(String EmployeeId,String password)
    {
        String[] columns = { Col_1};
        SQLiteDatabase db=getReadableDatabase();
        String selection= Col_4 + "=?" +" and " + Col_6 + "=?";
        String[] selectionArgs= { EmployeeId,password};
        Cursor cursor=db.query(Table_Name,columns,selection,selectionArgs,null,null,null);
        int count =cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;
    }


}


