package com.example.listadefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonAdicionar;
    EditText editTextNomeFilme;
    ListView listViewFilme;
    ArrayList<String> arrayListFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        editTextNomeFilme = findViewById(R.id.editTextNomeFilme);
        listViewFilme = findViewById(R.id.listViewFilme);

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListFilmes.add(editTextNomeFilme.getText().toString());
                //Definir o adapter do listView
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListFilmes);

                //Associa adapter ao ListView
                listViewFilme.setAdapter(adapter);

                editTextNomeFilme.setText("");
            }
        });

        /*//Definir um vetor (Array)
        arrayListFilmes.add("Matrix");
        arrayListFilmes.add("Gladiador");
        arrayListFilmes.add("O Poderoso Chefão");*/



    }
}