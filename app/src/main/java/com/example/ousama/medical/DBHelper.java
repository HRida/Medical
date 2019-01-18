package com.example.ousama.medical;

        import android.content.ContentValues;
        import android.content.Context;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.DatabaseUtils;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "medical.db";
    public static final int DATABASE_VERSION = 1;
    // define constants for students table
    public static final String MEDICAL_TABLE_NAME = "Doctor";
    public static final String MEDICAL_COLUMN_PHONE = "phone";
    public static final String MEDICAL_COLUMN_NAME = "name";
    public static final String MEDICAL_COLUMN_EMAIL = "email";
    public static final String MEDICAL_COLUMN_ADDRESS = "address";
    public static final String MEDICAL_COLUMN_SPECIALIST = "specialist";
    public static final String MEDICAL_COLUMN_REGION = "region";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table students
        db.execSQL("create table " + MEDICAL_TABLE_NAME + " (" +
                MEDICAL_COLUMN_PHONE + " char(8) primary key, " +
                MEDICAL_COLUMN_NAME + " varchar(50) not null, " +
                MEDICAL_COLUMN_EMAIL + " varchar(100) not null, " +
                MEDICAL_COLUMN_ADDRESS + " varchar(100) not null, " +
                MEDICAL_COLUMN_SPECIALIST + " varchar(50) not null, " +
                MEDICAL_COLUMN_REGION + " varchar(50) not null)"
        );

        // insert some initial data into table courses
        db.execSQL("insert into " + MEDICAL_TABLE_NAME + " values ('70606070', 'Doctor 1', 'doctor1@mobile.com', 'address1', " +
                "'Allergist', 'Beirut')");
        db.execSQL("insert into " + MEDICAL_TABLE_NAME + " values ('71989987', 'Doctor 2', 'doctor2@mobile.com', 'address2', " +
                "'Cardiologist', 'Tripoli')");
        db.execSQL("insert into " + MEDICAL_TABLE_NAME + " values ('03885554', 'Doctor 3', 'doctor3@mobile.com', 'address3', " +
                "'Pediatrician', 'Saida')");
        db.execSQL("insert into " + MEDICAL_TABLE_NAME + " values ('71900801', 'Doctor 4', 'doctor4@mobile.com', 'address4', " +
                "'Psychiatrist', 'Sour')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MEDICAL_TABLE_NAME);
        onCreate(db);
    }



    public ArrayList<Doctor> findDoctor(String specialist, String region) {
        ArrayList<Doctor> array_list = new ArrayList<Doctor>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from " +
                MEDICAL_TABLE_NAME + " where specialist = '" + specialist.trim() + "' and " +
                "region = '" + region + "'", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(new Doctor(res.getString(0), res.getString(1),res.getString(2),res.getString(3),
                    res.getString(4), res.getString(5)));
            res.moveToNext();
        }
        db.close();
        return array_list;
    }
}

