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
    Boolean blanco;

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

    public void Registrador(View view) {
        helper = new SQLiteHelper(this);

        db = helper.getWritableDatabase();
        alerta.setText("");
        blanco = false;

        String nombre = String.valueOf(editnombre.getText());
        if (nombre.isEmpty()){
            blanco = true;
        }
        String apellidos = String.valueOf(editapellidos.getText());
        if (apellidos.isEmpty()){
            blanco = true;
        }
        String edad = String.valueOf(editedad.getText());
        if (edad.isEmpty()){
            blanco = true;
        }
        String usuario = String.valueOf(editusuario.getText());
        if (usuario.isEmpty()){
            blanco = true;
        }
        String password = String.valueOf(editpassword.getText());
        if (password.isEmpty()){
            blanco = true;
        }
        String correo = String.valueOf(editcorreo.getText());
        if (correo.isEmpty()){
            blanco = true;
        }

        if(blanco = false ){
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



        }else {
            alerta.setText("Uno o varios de los campos esta vacio");
        }



    }
}