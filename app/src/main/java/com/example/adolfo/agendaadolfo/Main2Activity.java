package com.example.adolfo.agendaadolfo;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class Main2Activity extends AppCompatActivity {
    EditText nombre;
    EditText foto;
    EditText telefono;
    EditText direccion;
    EditText email;
    EditText web;
    ImageView v;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        v = (ImageView)findViewById(R.id.ivModificar);

        nombre = (EditText)findViewById(R.id.tfNombre);
        telefono = (EditText)findViewById(R.id.tfTelefono);
        foto = (EditText)findViewById(R.id.tfFoto);
        direccion = (EditText)findViewById(R.id.tfDireccion);
        email = (EditText)findViewById(R.id.tfEmail);
        web = (EditText)findViewById(R.id.tfWeb);

        nombre.setText(extras.getString("nombre"));
        telefono.setText(extras.getString("telefono"));
        foto.setText(extras.getString("foto"));
        direccion.setText(extras.getString("direccion"));
        email.setText(extras.getString("email"));
        web.setText(extras.getString("web"));

        File ruta = Environment.getExternalStorageDirectory();
        Bitmap imagen = BitmapFactory.decodeFile(ruta.getAbsolutePath()+extras.getString("foto"));
        v.setImageBitmap(imagen);





    }

    public void cargarDatos(String nom, long id, String telefono, String foto){
        nombre = (EditText)findViewById(R.id.tfNombre);
        nombre.setText(nom);
    }
}
