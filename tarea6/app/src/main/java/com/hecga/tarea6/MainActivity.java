package com.hecga.tarea6;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {
    private ArrayList<String> agenda;
    private ArrayAdapter<String> adaptador;
    private ListView lv1;
    private EditText et1,et2;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        agenda =new ArrayList<String>();
        recuperar();
        adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, agenda);
        lv1=(ListView)findViewById(R.id.list1);
        lv1.setAdapter(adaptador);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this,R.style.MyDialogTheme);
                dialogo1.setTitle("AVISO");
                dialogo1.setMessage("¿Eliminar este registro?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        String s= agenda.get(posicion);
                        StringTokenizer tok1=new StringTokenizer(s,":");
                        String nom=tok1.nextToken().trim();
                        SharedPreferences.Editor elemento= sharedPreferences.edit();
                        elemento.remove(nom);
                        elemento.apply();
                        agenda.remove(posicion);
                        adaptador.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {}
                });
                dialogo1.show();

                return false;
            }
        });

    }

    private void recuperar() {
        sharedPreferences = getSharedPreferences("AgendaTelefonica", Context.MODE_PRIVATE);
        Map<String,?> claves = sharedPreferences.getAll();
        for(Map.Entry<String,?> ele : claves.entrySet()){
            agenda.add(ele.getKey()+" : " +ele.getValue().toString());
        }
    }

    public void agregar(View v) {
        if(et1.getText().toString().isBlank() || et2.getText().toString().isBlank()) {
            Toast.makeText(getApplicationContext(),"No hay nada que guardar!",Toast.LENGTH_LONG).show();
        } else {
            agenda.add(et1.getText().toString() + " : " + et2.getText().toString());
            adaptador.notifyDataSetChanged();
            SharedPreferences.Editor elemento = sharedPreferences.edit();
            elemento.putString(et1.getText().toString(), et2.getText().toString());
            elemento.apply();
            limpiar();
        }
    }

    public void limpiar(){
        et1.setText(null);
        et2.setText(null);
        et1.requestFocus();
    }
}