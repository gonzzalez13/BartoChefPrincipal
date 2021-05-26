package com.example.bartochef;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;


public class SQLiteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bdRecetas.db";

    public SQLiteHelper(@Nullable Context context){
      super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

   @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(EstructuraBBDD.SQL_CREATE_ENTRIES);
        db.execSQL(EstructuraBBDD.SQL_CREATE_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(EstructuraBBDD.SQL_DELETE_ENTRIES);
        db.execSQL(EstructuraBBDD.SQL_DELETE_USUARIO);

    }

}
