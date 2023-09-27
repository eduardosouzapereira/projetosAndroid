package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao1Activity extends AppCompatActivity {

    Button buttonResponder;
    RadioButton radioButtonParasita;
    TextView textViewNome;
    String nome = "";
    int qtsErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1);

        buttonResponder = findViewById(R.id.buttonResponder);
        radioButtonParasita = findViewById(R.id.radioButtonParasita);
        textViewNome = findViewById(R.id.textViewNome);

        //pegar informações vindas de outra activity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        if (!nome.equals("")) {
            textViewNome.setText(nome);
        }

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
    public void verificarResposta(View view) {
        if (radioButtonParasita.isChecked()) {
            Toast.makeText(Questao1Activity.this, "Certa resposta!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Questao1Activity.this, Questao2Activity.class);
            intent.putExtra("nome", nome);
            intent.putExtra("qtdErros", qtsErros);
            startActivity(intent);
        } else {
            Toast.makeText(Questao1Activity.this, "Erroooooooouuu!", Toast.LENGTH_SHORT).show();
            qtsErros++;
        }
    }
}