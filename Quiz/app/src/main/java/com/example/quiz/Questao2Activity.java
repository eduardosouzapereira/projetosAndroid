package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Questao2Activity extends AppCompatActivity {

    Button buttonResponderQ2;
    CheckBox checkBoxTomHanks, checkBoxLeonardoDiCaprio, checkBoxJimCarrey, checkBoxChadwickBoseman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);

        buttonResponderQ2 = findViewById(R.id.buttonResponderQ2);
        checkBoxTomHanks = findViewById(R.id.checkBoxTomHanks);
        checkBoxLeonardoDiCaprio = findViewById(R.id.checkBoxLeonardoDiCaprio);
        checkBoxJimCarrey = findViewById(R.id.checkBoxJimCarrey);
        checkBoxChadwickBoseman = findViewById(R.id.checkBoxChadwickBoseman);

        buttonResponderQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxTomHanks.isChecked() && checkBoxLeonardoDiCaprio.isChecked() && checkBoxJimCarrey.isChecked() == false && !checkBoxChadwickBoseman.isChecked()) {
                    Toast.makeText(Questao2Activity.this, "Certa resposta!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Questao2Activity.this, "Erroooooooouuu!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}