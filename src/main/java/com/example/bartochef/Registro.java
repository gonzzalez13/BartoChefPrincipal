package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity {


    EditText editnombre,editapellidos,editedad,editcontraseña,editusuario,editpassword,editcorreo;
    TextView alerta;
    SQLiteDatabase db;
    SQLiteHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editnombre = findViewById(R.id.editNombre);
        editapellidos = findViewById(R.id.editApellidos);
        editedad = findViewById(R.id.editEdad);
        editusuario = findViewById(R.id.editUsuario);
        editpassword = findViewById(R.id.editPasswords);
        editcorreo = findViewById(R.id.editCorreo);
        alerta = findViewById(R.id.txtAdevertencia);


    }




    public void Registro(View view) {
/*
        helper = new SQLiteHelper(this);

        db = helper.getWritableDatabase();

        String nombre = String.valueOf(editnombre.getText());
        String apellidos = String.valueOf(editapellidos.getText());
        String edad = String.valueOf(editedad.getText());
        String usuario = String.valueOf(editusuario.getText());
        String password = String.valueOf(editpassword.getText());
        String correo = String.valueOf(editcorreo.getText());


        ContentValues values = new ContentValues();
        values.put(EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_NOMBRE,nombre);
        values.put(EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_APELLIDOS,apellidos);
        values.put(EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_EDAD,edad);
        values.put(EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_USUARIO,usuario);
        values.put(EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_PASSWORD,password);
        values.put(EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_CORREO,correo);

        db.insert(EstructuraBBDD.EstructuraUsuario.TABLE_NAME_USUARIO,null,values);
        db.close();

        editnombre.setText("");
        editapellidos.setText("");
        editedad.setText("");
        editusuario.setText("");
        editpassword.setText("");
        editcorreo.setText("");

 */


    }



}