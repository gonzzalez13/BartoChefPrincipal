package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

    }



    public void home(View view) {
        Intent i = new Intent(this,inicio.class);
        startActivity(i);
    }

    public void buscar(View view) {
        Intent i = new Intent(this,Buscador.class);
        startActivity(i);
    }

    public void perfil(View view) {
        Intent i = new Intent(this,Perfil.class);
        startActivity(i);
    }
}