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
    TextView alerta,boo;
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
        editusuario = findViewById(R.id.editUser);
        editpassword = findViewById(R.id.editPasswords);
        editcorreo = findViewById(R.id.editCorreo);
        alerta = findViewById(R.id.txtAdevertencia);
        boo = findViewById(R.id.TXTBOOL);
        blanco=false;

    }




    public void Registrar(View view) {

        helper = new SQLiteHelper(this);

        db = helper.getWritableDatabase();
        blanco=false;
        alerta.setText("");
        String nombre = String.valueOf(editnombre.getText());
        String apellidos = String.valueOf(editapellidos.getText());
        String edad = String.valueOf(editedad.getText());
        String usuario = String.valueOf(editusuario.getText());
        String password = String.valueOf(editpassword.getText());
        String correo = String.valueOf(editcorreo.getText());

        if (editnombre.getText().toString().trim().equalsIgnoreCase("")){
            alerta.setText("Todos los datos deben ser nombre");
            blanco = true;
        }

        if (editapellidos.getText().toString().trim().equalsIgnoreCase("")){
            alerta.setText("Todos los datos deben ser apellidos");
            blanco = true;
        }

        if (editedad.getText().toString().trim().equalsIgnoreCase("")){
            alerta.setText("Todos los datos deben ser edad");
            blanco = true;
        }

        if (editusuario.getText().toString().trim().equalsIgnoreCase("")){
        alerta.setText("Todos los datos deben ser user");
            blanco = true;
        }

        if (editpassword.getText().toString().trim().equalsIgnoreCase("")){
        alerta.setText("Todos los datos deben ser password");
            blanco = true;
        }
        if (editcorreo.getText().toString().trim().equalsIgnoreCase("")){
        alerta.setText("Todos los datos deben ser correo");
            blanco = true;
        }
        boo.setText(String.valueOf(blanco));

        if(blanco == true){
            alerta.setText("Todos los datos deben ser rellenados");

        }else{
            alerta.setText("");
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

        }





    }
}