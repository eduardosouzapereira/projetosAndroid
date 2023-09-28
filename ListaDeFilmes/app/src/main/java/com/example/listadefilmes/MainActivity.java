package com.example.listadefilmes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonAdicionar;
    EditText editTextNomeFilme;
    ListView listViewFilme;
    ArrayList<String> arrayListFilmes = new ArrayList<>();
    TextView textViewMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        editTextNomeFilme = findViewById(R.id.editTextNomeFilme);
        listViewFilme = findViewById(R.id.listViewFilme);
        textViewMensagem = findViewById(R.id.textViewMensagem);

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextNomeFilme.getText().toString().equals("")){
                    arrayListFilmes.add(editTextNomeFilme.getText().toString());
                    atualizarListView();
                    editTextNomeFilme.setText("");
                    textViewMensagem.setVisibility(View.INVISIBLE);
                }

            }
        });

        listViewFilme.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int posicao, long l) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setMessage("Deseja realmente excluir?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Remover um item do ArrayList
                        arrayListFilmes.remove(posicao);
                        atualizarListView();

                        if(arrayListFilmes.isEmpty()){
                            textViewMensagem.setVisibility(View.VISIBLE);
                        }
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();
                return false;
            }
        });

        /*//Definir um vetor (Array)
        arrayListFilmes.add("Matrix");
        arrayListFilmes.add("Gladiador");
        arrayListFilmes.add("O Poderoso Chefão");*/



    }

    private void atualizarListView() {

        //Definir o adapter do listView
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListFilmes);

        //Associa adapter ao ListView
        listViewFilme.setAdapter(adapter);
    }
}