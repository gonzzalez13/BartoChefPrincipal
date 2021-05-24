package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Ficha_receta extends AppCompatActivity {

    TextView TxtTitulo,TxtCocinero,TxtCategoria,TxtNacionalidad,TxtIngrediente,TxtReceta;
    ImageView imagen;
    private Receta receta;
    String titulo,chef,categoria,nacionalidad,ingrediente,prepacion;
    int foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_receta);

        receta = (Receta) getIntent().getSerializableExtra("Receta");
        TxtTitulo = findViewById(R.id.TxtTitulo);
        TxtCocinero = findViewById(R.id.TxtCocinero);
        TxtCategoria = findViewById(R.id.TxtCategoria);
        TxtNacionalidad = findViewById(R.id.TxtNacionalidad);
        TxtIngrediente = findViewById(R.id.TxtIngredientes);
        TxtReceta = findViewById(R.id.TxtReceta);
        imagen = findViewById(R.id.ImgFoto);

        //Asignar valor del objeto
        titulo = receta.getTitulo();
        chef = receta.getChef();
        categoria = receta.getCategoria();
        nacionalidad = receta.getNacionalidad();
        ingrediente = receta.getIngredientes();
        prepacion = receta.getPreparacion();
        foto = receta.getPlato();


        //asignar al layout

        TxtTitulo.setText(titulo);
        TxtCocinero.setText(chef);
        TxtCategoria.setText(categoria);
        TxtNacionalidad.setText(nacionalidad);
        TxtIngrediente.setText(ingrediente);
        TxtReceta.setText(prepacion);
        imagen.setBackgroundResource(foto);

    }
}