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

public class Modificar extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView lv;
    String chef;
    Receta receta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        Bundle bundle = getIntent().getExtras();
        chef = bundle.getString("chef").toString();
        lv = findViewById(R.id.listModi);

        filtro(chef);
        lv.setOnItemClickListener(this);
    }


    public void filtro(String Chef){

        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        String[] columns = {EstructuraBBDD.EstructuraRecta._ID,EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NOMBRE,EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_IMAGEN, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CALORIAS, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CATEGORIA, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NACIONALIDAD, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_INGREDIENTES, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_PREPARACION};
        String selection = EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF +" = (?)";
        String[] SelectionArgs = {Chef};
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


    public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
        Cursor cursor=(Cursor) listView.getItemAtPosition(position);

        int _id = cursor.getInt(0);
        String titulo=cursor.getString(1) ;
        String Categoria=cursor.getString(5 );
        String chef=cursor.getString(2 );
        String nacionalidad=cursor.getString(6 );
        String ingredientes=cursor.getString(7 );
        String prepacacion=cursor.getString(8 );
        int foto= cursor.getInt(3);


        receta = new Receta(_id,titulo,Categoria,chef,nacionalidad,ingredientes,prepacacion,foto);
        Intent i = new Intent(this,Ficha_Modificar.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Receta",receta);
        i.putExtras(bundle);
        startActivity(i);


    }
}