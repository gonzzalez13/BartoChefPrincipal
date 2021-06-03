package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Anadir_Ficha extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteHelper helper;
    Spinner OpCategoria,OPNacinalidad;
    EditText editTitulo,editingredientes,editpreparacion;
    TextView alerta;
    Usuario user;
    String chef;
    Boolean blanco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir__ficha);

        user = (Usuario) getIntent().getSerializableExtra("Usuario");

        OpCategoria =  findViewById(R.id.spinnerCategoria);
        OPNacinalidad = findViewById(R.id.spinnerNacionalidad);
        editTitulo = findViewById(R.id.editTitulo);
        editingredientes = findViewById(R.id.editIngredientes);
        editpreparacion = findViewById(R.id.editPreparacion);
        alerta = findViewById(R.id.TxtAlerta);

        ArrayAdapter<CharSequence> adapterCategoria = ArrayAdapter.createFromResource(this,R.array.opciones_Categoria, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterNacionalidad = ArrayAdapter.createFromResource(this,R.array.opciones_Nacionalidad, android.R.layout.simple_spinner_item);
        OpCategoria.setAdapter(adapterCategoria);
        OPNacinalidad.setAdapter(adapterNacionalidad);
        blanco=false;
        chef = user.getUsername();



    }

    public void Insertar(View view) {

        helper = new SQLiteHelper(this);

        db = helper.getWritableDatabase();
        blanco=false;
        alerta.setText("");

        String Titulo = editTitulo.getText().toString();
        String Categoria = OpCategoria.getSelectedItem().toString();
        String Nacionalidad = OPNacinalidad.getSelectedItem().toString();
        String Ingredientes = editingredientes.getText().toString();
        String Preparacion = editpreparacion.getText().toString();


        if (editTitulo.getText().toString().trim().equalsIgnoreCase("")){
            alerta.setText("Falta el titulo");
            blanco = true;
        }

        if (editingredientes.getText().toString().trim().equalsIgnoreCase("")){
            alerta.setText("Falta los ingredientes");
            blanco = true;
        }

        if (editpreparacion.getText().toString().trim().equalsIgnoreCase("")){
            alerta.setText("Falta los preparativos");
            blanco = true;
        }

        if(blanco == true){

        }else{
            alerta.setText("");
            ContentValues values = new ContentValues();

            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NOMBRE,Titulo);
            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CALORIAS,0);
            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CATEGORIA,Categoria);
            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF,chef);
            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NACIONALIDAD,Nacionalidad);
            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_INGREDIENTES,Ingredientes);
            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_PREPARACION,Preparacion);
            values.put(EstructuraBBDD.EstructuraRecta.COLUMN_NAME_IMAGEN,R.drawable.comida);

            db.insert(EstructuraBBDD.EstructuraRecta.TABLE_NAME_RECETAS,null,values);
            db.close();

            editTitulo.setText("");
            editingredientes.setText("");
            editpreparacion.setText("");


        }



    }
}