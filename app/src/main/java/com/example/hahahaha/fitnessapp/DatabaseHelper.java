package com.example.hahahaha.fitnessapp;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by hahahaha on 28/01/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="student.db";
    public static final String DATABASE_TABLE="Student_Table";
    public static final String COL_1="id";
    public static final String COL_2="name";
    public static final String COL_3="surname";
    public static final String COL_4="marks";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+DATABASE_TABLE+"(id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT,surname TEXT,marks INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String name,String surname,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result= db.insert(DATABASE_TABLE,null,contentValues);
        if(result==-1){

            return false;

        }
        else{
            return true;
        }

    }
}

