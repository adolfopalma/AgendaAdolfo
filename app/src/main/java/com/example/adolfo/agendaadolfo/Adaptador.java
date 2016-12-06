package com.example.adolfo.agendaadolfo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.annotation.DrawableRes;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by adolf on 02/12/2016.
 */

public class Adaptador extends BaseAdapter {
    private ArrayList<Elemento> lista;
    private final Activity actividad;

    public Adaptador(Activity a, ArrayList<Elemento> v) {
        super();
        this.lista = v;
        this.actividad = a;
    }

    // En el constructor de la clase se indica la actividad donde se ejecutará
    // la lista de datos a visualizar.
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int arg0) {
        return lista.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return lista.get(arg0).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ly = actividad.getLayoutInflater();
        View view = ly.inflate(R.layout.item, null, true);

        TextView tv= (TextView) view.findViewById(R.id.tvTitle);
        tv.setText((CharSequence) lista.get(position).getNombre());

        //TextView tv1= (TextView) view.findViewById(R.id.tvId);
        //tv1.setText(""+ lista.get(position).getId());

       // File imgFile = new File(lista.get(position).getFoto());
        File imgFile = Environment.getExternalStorageDirectory();
        Bitmap imagen = BitmapFactory.decodeFile(imgFile.getAbsolutePath()+lista.get(position).getFoto());
        ImageView im = (ImageView) view.findViewById(R.id.imagen);
        im.setImageBitmap(imagen);

        /*if(imgFile.exists()){
            ImageView im = (ImageView) view.findViewById(R.id.imagen);

            im.setImageBitmap(imagen);
            im.setAdjustViewBounds(true);
        }else{
            Toast.makeText(actividad, "No hay imagen para cargar", Toast.LENGTH_SHORT).show();
        }*/
        return view;
    }

}
    /*File ruta = Environment.getExternalStorageDirectory();
    Bitmap imagen = BitmapFactory.decodeFile(ruta.getAbsolutePath()+"/1.jpg");
v.setImageBitmap(imagen);*/
