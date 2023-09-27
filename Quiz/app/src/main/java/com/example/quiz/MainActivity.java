package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonResponder;
    RadioButton radioButtonParasita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonResponder = findViewById(R.id.buttonResponder);
        radioButtonParasita = findViewById(R.id.radioButtonParasita);

        /*buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonParasita.isChecked()){
                    Toast.makeText(MainActivity.this, "Certa resposta!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Erroooooooouuu!", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    // Método alternativo
    public void verificarResposta(View view){
        if (radioButtonParasita.isChecked()){
            Toast.makeText(MainActivity.this, "Certa resposta!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Questao2Activity.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Erroooooooouuu!", Toast.LENGTH_SHORT).show();
        }
    }
}