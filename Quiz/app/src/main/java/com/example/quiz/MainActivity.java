package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button buttonAvancar;
    EditText editTextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAvancar = findViewById(R.id.buttonAvancar);
        editTextNome = findViewById(R.id.editTextNome);

        buttonAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Questao1Activity.class);
                intent.putExtra("nome", editTextNome.getText().toString());//passar informações entre atividades
                startActivity(intent);
            }
        });
    }
}