package com.example.happy.listasavanzadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    NoticiaAdapter customeAdapter;

    EditText et_titulo;
    Button btn_generar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_titulo = findViewById(R.id.et_titulo);
        btn_generar = findViewById(R.id.btn_generar);

        lv_noticias = findViewById(R.id.lv_noticias);
        customeAdapter = new NoticiaAdapter(this);
        lv_noticias.setAdapter(customeAdapter);

        //Agregar noticia
        Noticia noticia1 = new Noticia("Cambio en HED","Va a haber un cambio en el logo de hoy es diseño" ,"30/08/2018");
        Noticia noticia2 = new Noticia("Happyness change the world","La felicidad es cuando estas tranquilo y no quieres nada más, excepto lo que tienes en este momento","31/08/2018");
        customeAdapter.agregarNoticia(noticia1);
        customeAdapter.agregarNoticia(noticia2);

        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Noticia noticia_click = (Noticia) customeAdapter.getItem(position);
                Toast.makeText(MainActivity.this, noticia_click.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Traemos la fecha actual
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                String fecha = day+"/"+month+"/"+year;


                //Que quiero agregar
                String titulo = et_titulo.getText().toString();


                //La agrega :v
                Noticia newNoticia = new Noticia(titulo, "No description", fecha);
                customeAdapter.agregarNoticia(newNoticia);

            }
        });

    }
}
