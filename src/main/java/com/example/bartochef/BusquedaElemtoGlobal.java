package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.Serializable;

public class BusquedaElemtoGlobal extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private EntidadList item;
    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView lv;
    String categoria;
    Receta receta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_elemto_global);


        item = (EntidadList) getIntent().getSerializableExtra("objetoData");
        lv = findViewById(R.id.ListEleGlo);
        categoria = item.getTitulo();
        filtro(categoria);
        lv.setOnItemClickListener(this);
    }


    public void filtro(String Categoria){

        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        String[] columns = {EstructuraBBDD.EstructuraRecta._ID,EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NOMBRE, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_IMAGEN};
        String selection = EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NACIONALIDAD +" = (?)";
        String[] SelectionArgs = {Categoria};
        String groupBy= null;
        String having = null;
        String orderBy = null;


        Cursor curso = db.query(EstructuraBBDD.EstructuraRecta.TABLE_NAME_RECETAS,columns,selection,SelectionArgs,groupBy,having,orderBy);

        String [] from = {EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NOMBRE, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_IMAGEN};
        int [] to = {R.id.txtNombre,R.id.txtChef,R.id.idImagen};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this,R.layout.lista,curso,from,to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador);

        db.close();
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

    @Override
    public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
        Cursor cursor=(Cursor) listView.getItemAtPosition(position);
        int _id=cursor.getInt(0);
        String titulo=cursor.getString(1) ;
        String Categoria=cursor.getString(3 );
        String chef=cursor.getString(4 );
        String nacionalidad=cursor.getString(6 );
        String ingredientes=cursor.getString(7 );
        String prepacacion=cursor.getString(8 );
        int puntos = cursor.getInt(2);
        int foto= cursor.getInt(5);

        receta = new Receta(_id,titulo,Categoria,chef,nacionalidad,ingredientes,prepacacion,puntos,foto);
        Intent i = new Intent(this,Ficha_receta.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Receta",receta);
        i.putExtras(bundle);
        startActivity(i);
    }
}