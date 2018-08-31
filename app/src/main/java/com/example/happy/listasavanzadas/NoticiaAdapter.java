package com.example.happy.listasavanzadas;

import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoticiaAdapter extends BaseAdapter{

    ArrayList<Noticia> noticias;
    Activity activity;

    public NoticiaAdapter(Activity activity){
        this.activity = activity;
        noticias = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //generar un reglon por objeto
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        //Pasa el XML a View
        View renglon = inflater.inflate(R.layout.renglon, null, false);
        TextView item_titulo = renglon.findViewById(R.id.item_titulo);
        TextView item_fecha = renglon.findViewById(R.id.item_fecha);
        TextView item_descripcion = renglon.findViewById(R.id.item_descripcion);
        Button item_action = renglon.findViewById(R.id.item_action);

        item_titulo.setText(noticias.get(position).getTitulo());
        item_fecha.setText(noticias.get(position).getFecha());
        item_descripcion.setText(noticias.get(position).getDescripcion());


        item_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para eliminar algo
                noticias.remove(position);
                notifyDataSetChanged();

                //muestra la posicion
                //Toast.makeText(activity, "POS " +position, Toast.LENGTH_SHORT).show();

                //
                Intent intent = new Intent(activity, NoticiaView.class);
                activity.startActivity(intent);


                //Si estoy en la clase Main seria asi
                //Intent i = new Intent(MainActivity.this, NoticiaView.class);
            }
        });

        return renglon;
    }

    public void agregarNoticia(Noticia noticia){
        noticias.add(noticia);
        notifyDataSetChanged();
    }
}
