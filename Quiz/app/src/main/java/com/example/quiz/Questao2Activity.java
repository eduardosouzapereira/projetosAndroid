package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Questao2Activity extends AppCompatActivity {

    Button buttonResponderQ2;
    CheckBox checkBoxTomHanks, checkBoxLeonardoDiCaprio, checkBoxJimCarrey, checkBoxChadwickBoseman;
    TextView textViewNome;
    String nome = "";
    int qtsErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);

        buttonResponderQ2 = findViewById(R.id.buttonResponderQ2);
        checkBoxTomHanks = findViewById(R.id.checkBoxTomHanks);
        checkBoxLeonardoDiCaprio = findViewById(R.id.checkBoxLeonardoDiCaprio);
        checkBoxJimCarrey = findViewById(R.id.checkBoxJimCarrey);
        checkBoxChadwickBoseman = findViewById(R.id.checkBoxChadwickBoseman);
        textViewNome = findViewById(R.id.textViewNome);

        //pegar informações vindas de outra activity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtdErros");
        if (!nome.equals("")) {
            textViewNome.setText(nome);
        }

        buttonResponderQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxTomHanks.isChecked() && checkBoxLeonardoDiCaprio.isChecked() && checkBoxJimCarrey.isChecked() == false && !checkBoxChadwickBoseman.isChecked()) {
                    Toast.makeText(Questao2Activity.this, "Certa resposta!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Questao2Activity.this, Questao3Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtdErros", qtsErros);
                    startActivity(intent);
                } else {
                    Toast.makeText(Questao2Activity.this, "Erroooooooouuu!", Toast.LENGTH_SHORT).show();
                    qtsErros++;
                }
            }
        });
    }
}