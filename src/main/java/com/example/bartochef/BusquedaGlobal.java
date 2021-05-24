package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class BusquedaGlobal extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView lv;
    adaptador adaptador;
    ArrayList<EntidadList> listaPaises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_global);
        lv = findViewById(R.id.listGlobal);
        listaPaises = GetArrayItems();
        adaptador = new adaptador(this,listaPaises);
        lv.setAdapter(adaptador);
        lv.setOnItemClickListener(this);
    }




    private ArrayList<EntidadList> GetArrayItems(){
        ArrayList<EntidadList> listItems = new ArrayList<>();


        listItems.add(new EntidadList(R.drawable.espana,"España"));
        listItems.add(new EntidadList(R.drawable.eeuu,"EEUU"));
        listItems.add(new EntidadList(R.drawable.japon,"Japon"));
        listItems.add(new EntidadList(R.drawable.italia,"Italia"));
        listItems.add(new EntidadList(R.drawable.china,"China"));
        listItems.add(new EntidadList(R.drawable.francia,"Francia"));
        listItems.add(new EntidadList(R.drawable.reinounido,"Reino Unido"));
        listItems.add(new EntidadList(R.drawable.turquia,"Turquia"));

        return listItems;
    }
    @Override
    public void onItemClick(AdapterView<?> lisViewt, View view, int position, long id) {

        Intent i = new Intent(this,BusquedaElemtoGlobal.class);
        i.putExtra("objetoData",listaPaises.get(position));
        startActivity(i);
    }

}