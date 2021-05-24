package com.example.bartochef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<EntidadList> listItems;

    public adaptador(Context context, ArrayList<EntidadList> listItems) {
        this.context = context;
        this.listItems = listItems;
    }


    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EntidadList item = (EntidadList) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.listb, null);
        ImageView imgfondo = convertView.findViewById(R.id.IDimagenB);
        TextView txtTitulo = convertView.findViewById(R.id.IDBuscador);

        imgfondo.setImageResource(item.getImgfoto());
        txtTitulo.setText(item.getTitulo());


        return convertView;
    }
}
