package com.example.primeraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.primeraapp.databinding.ActivityProfileBinding;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileView extends AppCompatActivity {

    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        EdgeToEdge.enable(this);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        String[] arrays = {"Computacion","Telematica","Derecho"};

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrays);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.cmbCarrera.setAdapter(spinnerAdapter);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validationAndSave();
            }
        });

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    private void validationAndSave() {

        AtomicBoolean validated = new AtomicBoolean(true);

        if(binding.hintName.getText() == null || binding.hintName.getText().toString().isBlank()) {
            binding.hintName.setError("El nombre no puede estar vacio");
            validated.set(false);
        }

        if(binding.txtID.getText() == null || binding.txtID.getText().toString().isBlank()){
            binding.txtID.setError("La matricula es obligatoria");
            validated.set(false);
        }

        if(binding.cmbCarrera.getSelectedItem() == null) {
           // binding.cmbCarrera.setError("La carrera es obligatoria");
            validated.set(false);
        }

        if(validated.get()){

            String nombre = binding.hintName.getText().toString();
            String matricula = binding.txtID.getText().toString();
            String carrera = binding.cmbCarrera.getSelectedItem().toString();

            Intent intent = new Intent(ProfileView.this, ProfileInfo.class);

            intent.putExtra("nombre", nombre);
            intent.putExtra("matricula", matricula);
            intent.putExtra("carrera", carrera);

            startActivity(intent);

        }


    }

}