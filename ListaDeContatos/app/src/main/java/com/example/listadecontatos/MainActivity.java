package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewContato;
    Button buttonAdicionarNovo;
    ArrayList<DtoContato> arrayListContato = new ArrayList<>();
    EditText editTextPesquisaNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContato = findViewById(R.id.listViewContato);
        buttonAdicionarNovo = findViewById(R.id.buttonAdicionarNovo);

        DaoContato daoContato = new DaoContato(MainActivity.this);
        editTextPesquisaNome = findViewById(R.id.editTextPesquisaNome);

        editTextPesquisaNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Toast.makeText(MainActivity.this, "before: " + charSequence, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Toast.makeText(MainActivity.this, "on: " + charSequence, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Toast.makeText(MainActivity.this, "after: " + editable, Toast.LENGTH_SHORT).show();
                arrayListContato = daoContato.consultarPorNome(editable.toString());
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListContato);
                listViewContato.setAdapter(adapter);
            }
        });

        buttonAdicionarNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inclusao = new Intent(MainActivity.this, InclusaoActivity.class);
                startActivity(inclusao);
            }
        });

        arrayListContato = daoContato.consultarTodos();

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListContato);

        listViewContato.setAdapter(adapter);



    }
}