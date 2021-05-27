package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }


    public void inicio(View view) {
        Intent i = new Intent(this,Perfil.class);
        startActivity(i);
    }

    public void registro(View view) {
        Intent i = new Intent(this,Registro.class);
        startActivity(i);

    }
}