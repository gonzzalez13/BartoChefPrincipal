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
import android.widget.TextView;

public class BusquedasElementos extends AppCompatActivity {

    private EntidadList item;
    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView lv;
    String categoria;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busquedas_elementos);

        item = (EntidadList) getIntent().getSerializableExtra("objetoData");
        lv = findViewById(R.id.ListElement);

        categoria = item.getTitulo();
        filtro(categoria);


    }


    public void filtro(String Categoria){

        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        String[] columns = {EstructuraBBDD.EstructuraRecta._ID,EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NOMBRE, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_IMAGEN};
        String selection = EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CATEGORIA +" = (?)";
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

}