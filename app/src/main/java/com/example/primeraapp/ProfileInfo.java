package com.example.primeraapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;


public class ProfileInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_info);

        // para obtenerlos desde la vista
        TextView lblSaludo = findViewById(R.id.lblSaludo);
        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtMatricula = findViewById(R.id.txtMatricula);
        TextView txtCarrera = findViewById(R.id.txtCarrera);

        // para tener los valores
        String nombre = getIntent().getStringExtra("nombre");
        String matricula = getIntent().getStringExtra("matricula");
        String carrera = getIntent().getStringExtra("carrera");

        lblSaludo.setText("¡Hola, " + nombre + "!");
        txtNombre.setText(nombre);
        txtMatricula.setText(matricula);
        txtCarrera.setText(carrera);


    }
}