package com.example.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonSoma;
    EditText editTextValor1, editTextValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associa objetos
        buttonSoma = findViewById(R.id.button_soma);
        editTextValor1 = findViewById(R.id.edit_valor1);
        editTextValor2 = findViewById(R.id.edit_valor2);

        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v1 = Double.parseDouble(editTextValor1.getText().toString());
                double v2 = Double.parseDouble(editTextValor2.getText().toString());
                double soma = v1 + v2;
                Toast.makeText(MainActivity.this, "Resultado = " + soma, Toast.LENGTH_LONG).show();
            }
        });
    }
}