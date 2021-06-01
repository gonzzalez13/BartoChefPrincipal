package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InicioSesion extends AppCompatActivity {
    Usuario cocinero;
    SQLiteDatabase db;
    SQLiteHelper helper;
    String usuario,contra;
    EditText user,password;
    TextView alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        user = findViewById(R.id.editUsuario);
        password = findViewById(R.id.editPassword);
        alerta = findViewById(R.id.txtAlerta);
    }


    public void inicio(View view) {

        usuario = String.valueOf(user.getText());
        contra = String.valueOf(password.getText());
        verificar(usuario,contra);
    }



    public void verificar(String usuario,String contra){

        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        String[] columns = {EstructuraBBDD.EstructuraUsuario._ID, EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_NOMBRE, EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_APELLIDOS, EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_EDAD, EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_USUARIO, EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_PASSWORD, EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_CORREO};
        String selection = EstructuraBBDD.EstructuraUsuario.COLUMN_NAME_USUARIO +" = (?)";
        String[] SelectionArgs = {usuario};
        String groupBy= null;
        String having = null;
        String orderBy = null;

        Cursor curso = db.query(EstructuraBBDD.EstructuraUsuario.TABLE_NAME_USUARIO,columns,selection,SelectionArgs,groupBy,having,orderBy);

        if (curso.moveToFirst()) {

            String nombre = curso.getString(curso.getColumnIndex("nombre"));
            String apellidos = curso.getString(curso.getColumnIndex("apellidos"));
            String edad = curso.getString(curso.getColumnIndex("edad"));
            String username = curso.getString(curso.getColumnIndex("usuario"));
            String password = curso.getString(curso.getColumnIndex("password"));
            String correo = curso.getString(curso.getColumnIndex("correo"));

            cocinero = new Usuario(nombre,apellidos,edad,username,contra,correo);
            if(password.equals(contra)){
                alerta.setText("Todo es correcto");
                Intent i = new Intent(this,Perfil.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Usuario",cocinero);
                i.putExtras(bundle);
                startActivity(i);
            }else{
                alerta.setText("Error en la contraseña");
            }
            }else{

            alerta.setText("El usuario esta mal escrito o no existe");
        }



    }

















    public void registro(View view) {
        Intent i = new Intent(this,Registro.class);
        startActivity(i);

    }
}