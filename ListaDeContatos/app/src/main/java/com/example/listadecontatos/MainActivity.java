package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewContato;
    Button buttonAdicionarNovo;
    ArrayList<DtoContato> arrayListContato = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContato = findViewById(R.id.listViewContato);
        buttonAdicionarNovo = findViewById(R.id.buttonAdicionarNovo);

        DaoContato daoContato = new DaoContato(MainActivity.this);

        arrayListContato = daoContato.consultarTodos();

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListContato);

        listViewContato.setAdapter(adapter);
        
        buttonAdicionarNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}