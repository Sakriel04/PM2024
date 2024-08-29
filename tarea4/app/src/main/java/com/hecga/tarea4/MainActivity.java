package com.hecga.tarea4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText firstName, lastName, address, city, country, postalCode, mobileNumber, email;
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
        // get the reference of EditText's and Button and then perform click event on Button
        firstName = (EditText) findViewById(R.id.etNombre);
        lastName = (EditText) findViewById(R.id.etApellido);
        address = (EditText) findViewById(R.id.etDireccion);
        city = (EditText) findViewById(R.id.etCiudad);
        country = (EditText) findViewById(R.id.etPais);
        postalCode = (EditText) findViewById(R.id.etCodigoPostal);
        mobileNumber = (EditText) findViewById(R.id.etTelefonoMovil);
        email = (EditText) findViewById(R.id.etCorreoElectronico);
        submit = (Button) findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(firstName)&&validate(lastName)&&validate(address)&&validate(city)&&validate(country)
                        &&validate(postalCode)&&validate(mobileNumber)&&validate(email))
                {
                    // display successful message if all the fields are filled
                    Toast.makeText(getApplicationContext(),"Registro exitoso!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validate(EditText editText) {
        // check whether the field is empty or not
        if (editText.getText().toString().trim().length() < 1) {
            // display the error if field is empty
            editText.setError("Favor rellenar este dato!");
            // set focus on field so that cursor will automatically move to that field
            editText.requestFocus();
            return false;
        }
        return true;
    }
}