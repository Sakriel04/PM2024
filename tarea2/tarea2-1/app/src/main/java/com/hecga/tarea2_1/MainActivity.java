package com.hecga.tarea2_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        num=(int)(Math.random()*100001);
        String cadena=String.valueOf(num);
        Toast notificacion= Toast.makeText(this,cadena,Toast.LENGTH_LONG);
        notificacion.show();
    }
    public void controlar(View v) {
        String valorIngresado=et1.getText().toString();
        int valor=Integer.parseInt(valorIngresado);
        if (valor==num) {
            Toast notificacion=Toast.makeText(this,"Muy bien recordaste el número mostrado.",Toast.LENGTH_LONG);
                    notificacion.show();
        }
        else {
            Toast notificacion=Toast.makeText(this,"Lo siento pero no es el número que mostré.", Toast.LENGTH_LONG);
                    notificacion.show();
        }
    }
}