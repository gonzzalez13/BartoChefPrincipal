package com.example.bartochef;

import android.provider.BaseColumns;

public class EstructuraBBDD {

    public static final String  SQL_CREATE_ENTRIES =

            "CREATE TABLE IF NOT EXISTS "+ EstructuraRecta.TABLE_NAME_RECETAS +
                    "("+ EstructuraRecta._ID + " INTEGER PRIMARY KEY, "
                    + EstructuraRecta.COLUMN_NAME_NOMBRE + " text, "
                    + EstructuraRecta.COLUMN_NAME_CALORIAS + " integer, "
                    + EstructuraRecta.COLUMN_NAME_CATEGORIA + " text, "
                    + EstructuraRecta.COLUMN_NAME_CHEF + " text,"
                    + EstructuraRecta.COLUMN_NAME_IMAGEN + " integer,"
                    + EstructuraRecta.COLUMN_NAME_NACIONALIDAD + " text, "
                    + EstructuraRecta.COLUMN_NAME_INGREDIENTES + " text, "
                    + EstructuraRecta.COLUMN_NAME_PREPARACION + " text);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " +EstructuraRecta.TABLE_NAME_RECETAS;


    private EstructuraBBDD(){}

    public static class EstructuraRecta implements BaseColumns {
        public static final String TABLE_NAME_RECETAS ="recetas";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_CALORIAS = "calorias";
        public static final String COLUMN_NAME_CATEGORIA = "categoria";
        public static final String COLUMN_NAME_CHEF ="chef";
        public static final String COLUMN_NAME_IMAGEN = "imagen";
        public static final String COLUMN_NAME_NACIONALIDAD = "nacionalidad";
        public static final String COLUMN_NAME_INGREDIENTES = "ingredientes";
        public static final String COLUMN_NAME_PREPARACION = "preparacion";
    }
}
