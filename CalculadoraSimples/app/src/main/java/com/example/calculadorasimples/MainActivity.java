package com.example.calculadorasimples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonSoma, buttonSub, buttonMult, buttonDiv;
    EditText editTextValor1, editTextValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associa objetos
        buttonSoma = findViewById(R.id.button_soma);
        buttonSub = findViewById(R.id.button_sub);
        buttonMult = findViewById(R.id.button_mult);
        buttonDiv = findViewById(R.id.button_div);
        editTextValor1 = findViewById(R.id.edit_valor1);
        editTextValor2 = findViewById(R.id.edit_valor2);

        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado(1);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado(2);
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado(3);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado(4);
            }
        });

    }

    public void mostraResultado(int op){
        double resul = 0;

        if (editTextValor1.getText().length() > 0 && editTextValor2.getText().length() > 0){
            double v1 = Double.parseDouble(editTextValor1.getText().toString());
            double v2 = Double.parseDouble(editTextValor2.getText().toString());
            switch (op){
                case 1:
                    resul = v1 + v2;
                    break;
                case 2:
                    resul = v1 - v2;
                    break;
                case 3:
                    resul = v1 * v2;
                    break;
                case 4:
                    resul = v1 / v2;
                    break;
                default:
                    break;
            }
            AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
            msg.setTitle("Resultado");
            msg.setNeutralButton("OK", null);
            msg.setMessage("" + resul).show();
            //Toast.makeText(MainActivity.this, "Resultado = " + resul, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Preencha os valores!", Toast.LENGTH_SHORT).show();
        }
    }
}