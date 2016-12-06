package com.example.adolfo.agendaadolfo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.adolfo.agendaadolfo.R.layout.item;

public class MainActivity extends ListActivity  {
    static Adaptador a;
    static ArrayList <Elemento> arrayList = new ArrayList();
    ListView listview;
    Intent it;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       


        // Cargar la lista con Objetos ( en nuestro caso Elemento )
        arrayList.clear();

            arrayList.add(new Elemento("Valentin Corral",0,"684579321","/valen.jpg","valentin.com","La Chana","ValentinLoPeta.org"));
            arrayList.add(new Elemento("Adolfo Palma",1,"625957572","/1.jpg","adolfo.palmagr@gmail.com","Calle Juan XXIII Nº23","ninguna"));
            arrayList.add(new Elemento("Natalia Ramirez",2,"685974521","/natalia.jpg","natalia.com","Armilla city","NataliaLaChula.es"));
            arrayList.add(new Elemento("David Jimenez",3,"687549321","/david.jpg","DavidJimenez.com","Lanjaron town","DavidElBlanco.com"));


        a = new Adaptador(this,arrayList);

        a.notifyDataSetChanged();
        setListAdapter(a);

        listview = (ListView) findViewById(android.R.id.list);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapter, View view, int position, long arg)
            {
// getItem devuelve un Object
                Elemento el = (Elemento) listview.getAdapter().getItem(position);
// hacer algo
                it = new Intent(getApplicationContext(), Main2Activity.class);
                it.putExtra("objeto", el);
                it.putExtra("posicion", position);
                it.putExtra("nombre",arrayList.get(position).getNombre());
                it.putExtra("telefono",arrayList.get(position).getTelefono());
                it.putExtra("foto",arrayList.get(position).getFoto());
                it.putExtra("id",arrayList.get(position).getId());
                it.putExtra("email",arrayList.get(position).getEmail());
                it.putExtra("direccion",arrayList.get(position).getDirecicon());
                it.putExtra("web",arrayList.get(position).getWeb());

                startActivity(it);
            }
        });


    }
    @Override
    protected void onRestart () {
        super.onRestart();
        Toast.makeText(this, "Lista recargada", Toast.LENGTH_SHORT).show();
        a = null;
        a = new Adaptador(this,arrayList);
        a.notifyDataSetChanged();
        setListAdapter(a);
    }

}
