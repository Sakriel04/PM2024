package com.hecga.tarea2_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
    }
    public void verificar(View v) {
        String clave=et1.getText().toString();
        if (clave.equals("abc123")) {
            Intent i = new Intent(this, Actividad2.class);
            startActivity(i);
        }
        else {
            Toast notificacion= Toast.makeText(this,"Clave incorrecta", Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}