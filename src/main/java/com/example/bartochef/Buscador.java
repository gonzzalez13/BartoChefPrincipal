package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Buscador extends AppCompatActivity implements AdapterView.OnItemClickListener{

    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView lv;
    adaptador adaptador;
    EditText editBuscador;
    ArrayList<EntidadList> listaCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);
        lv = findViewById(R.id.listb);
        listaCategoria = GetArrayItems();
        adaptador = new adaptador(this,listaCategoria);
        lv.setAdapter(adaptador);

        lv.setOnItemClickListener(this);
    }



    private ArrayList<EntidadList> GetArrayItems(){
        ArrayList<EntidadList> listItems = new ArrayList<>();


        listItems.add(new EntidadList(R.drawable.carnefnal,"Carnes"));
        listItems.add(new EntidadList(R.drawable.pesacadofinal,"Pescados"));
        listItems.add(new EntidadList(R.drawable.ensalda,"Vegetarianos"));
        listItems.add(new EntidadList(R.drawable.pasta,"Pasta"));
        listItems.add(new EntidadList(R.drawable.arroz,"Arroces"));
        listItems.add(new EntidadList(R.drawable.postre,"Postre"));
        listItems.add(new EntidadList(R.drawable.sopa,"Sopas"));
        listItems.add(new EntidadList(R.drawable.legumbres,"Legumbres"));
        listItems.add(new EntidadList(R.drawable.global,"Global"));

        return listItems;
    }



    @Override
    public void onItemClick(AdapterView<?> lisViewt, View view, int position, long id) {

        Intent i = null;
        if(listaCategoria.get(position).getTitulo().equals("Global")){
            i =  new Intent(this,BusquedaGlobal.class);
            startActivity(i);
        }else{
            i = new Intent(this,BusquedasElementos.class);
            i.putExtra("objetoData",listaCategoria.get(position));
            startActivity(i);
        }

    }





    private void listarrecetas(){
        helper = new SQLiteHelper(this);

        db = helper.getReadableDatabase();
        Cursor cursor = db.query(EstructuraBBDD.EstructuraRecta.TABLE_NAME_RECETAS,null,null,null,null,null,null);

        String [] from = {EstructuraBBDD.EstructuraRecta.COLUMN_NAME_NOMBRE, EstructuraBBDD.EstructuraRecta.COLUMN_NAME_CHEF};
        int [] to = {R.id.txtNombre,R.id.txtChef};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this,R.layout.lista,cursor,from,to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
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