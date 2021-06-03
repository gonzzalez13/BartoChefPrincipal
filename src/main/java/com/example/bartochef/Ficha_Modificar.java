package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Ficha_Modificar extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteHelper helper;
    EditText editTitulo,editIngrediente,editPreparacion;
    Spinner OpCategoria,OPNacinalidad;
    Receta receta;
    String titulo,chef,categoria,nacionalidad,ingrediente,prepacion;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha__modificar);
        receta = (Receta) getIntent().getSerializableExtra("Receta");

        OpCategoria =  findViewById(R.id.spinnerCategoriaModif);
        OPNacinalidad = findViewById(R.id.spinnerNacionalidadModifi);
        editTitulo = findViewById(R.id.editTituloModif);
        editIngrediente = findViewById(R.id.editIngredeintesModifi);
        editPreparacion = findViewById(R.id.editPreparacionModif);

        ArrayAdapter<CharSequence> adapterCategoria = ArrayAdapter.createFromResource(this,R.array.opciones_Categoria, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterNacionalidad = ArrayAdapter.createFromResource(this,R.array.opciones_Nacionalidad, android.R.layout.simple_spinner_item);
        OpCategoria.setAdapter(adapterCategoria);
        OPNacinalidad.setAdapter(adapterNacionalidad);



        //Asignar valor del objeto
        id = receta.getId();
        titulo = receta.getTitulo();
        chef = receta.getChef();
        categoria = receta.getCategoria();
        nacionalidad = receta.getNacionalidad();
        ingrediente = receta.getIngredientes();
        prepacion = receta.getPreparacion();


        //asignar al layout

        editTitulo.setText(titulo);
        editIngrediente.setText(ingrediente);
        editPreparacion.setText(prepacion);


    }

    public void Actializar(View view) {
    }

    public void Eliminar(View view) {

        helper = new SQLiteHelper(this);

        db = helper.getWritableDatabase();

        db.delete(EstructuraBBDD.EstructuraRecta.TABLE_NAME_RECETAS, EstructuraBBDD.EstructuraRecta._ID+"="+id,null);

        Intent i = new Intent(this,inicio.class);
        startActivity(i);

    }
}