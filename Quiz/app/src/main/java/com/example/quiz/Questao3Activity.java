package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao3Activity extends AppCompatActivity {
    Button buttonResponderQ3;
    RadioButton radioButton1969;
    TextView textViewNome;
    String nome = "";
    int qtsErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3);

        buttonResponderQ3 = findViewById(R.id.buttonResponderQ3);
        radioButton1969 = findViewById(R.id.radioButton1969);

        textViewNome = findViewById(R.id.textViewNome);

        //pegar informações vindas de outra activity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtdErros");
        if (!nome.equals("")) {
            textViewNome.setText(nome);
        }
        buttonResponderQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton1969.isChecked()){
                    Toast.makeText(Questao3Activity.this, "Certa resposta!", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao3Activity.this);
                    msg.setMessage(nome + " vc errou " + qtsErros + " vezes. Parabéns! (ou não...)");
                    msg.show();
                } else {
                    Toast.makeText(Questao3Activity.this, "Erroooooooouuu!", Toast.LENGTH_SHORT).show();
                    qtsErros++;
                }
            }
        });
    }
}