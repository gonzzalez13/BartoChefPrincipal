package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.Serializable;

public class inicio extends AppCompatActivity implements AdapterView.OnItemClickListener {

    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView lv;
    Receta receta;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        lv = findViewById(R.id.idlist);
        listarrecetas();
        lv.setOnItemClickListener(this);
    }

    private void listarrecetas(){
        helper = new SQLiteHelper(this);

        db = helper.getReadableDatabase();
        Cursor cursor = db.query(EstructuraBBDD.EstructuraRecta.TABLE_NAME_RECETAS,null,null,null,null,null,null);

        String [] from = {EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NOMBRE, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_IMAGEN};
        int [] to = {R.id.txtNombre,R.id.txtChef,R.id.idImagen};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this,R.layout.lista,cursor,from,to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador);

        db.close();
    }

    @Override
    public void onItemClick(AdapterView<?> listView, View view, int position, long id) {

        Cursor cursor=(Cursor) listView.getItemAtPosition(position);

        String titulo=cursor.getString(1) ;
        String Categoria=cursor.getString(3 );
        String chef=cursor.getString(4 );
        String nacionalidad=cursor.getString(6 );
        String ingredientes=cursor.getString(7 );
        String prepacacion=cursor.getString(8 );
        int foto= cursor.getInt(5);

        receta = new Receta(titulo,Categoria,chef,nacionalidad,ingredientes,prepacacion,foto);
        Intent i = new Intent(this,Ficha_receta.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Receta",receta);
        i.putExtras(bundle);
        startActivity(i);
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
        Intent i = new Intent(this,InicioSesion.class);
        startActivity(i);
    }


}