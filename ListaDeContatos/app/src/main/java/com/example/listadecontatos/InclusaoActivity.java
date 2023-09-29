package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InclusaoActivity extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextTel;
    Button buttonConfirmarInclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclusao);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTel = findViewById(R.id.editTextTel);
        buttonConfirmarInclusao = findViewById(R.id.buttonConfirmarInclusao);

        buttonConfirmarInclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DtoContato dtoContato = new DtoContato();
                dtoContato.setNome(editTextNome.getText().toString());
                dtoContato.setEmail(editTextEmail.getText().toString());
                dtoContato.setTelefone(editTextTel.getText().toString());
                DaoContato daoContato = new DaoContato(InclusaoActivity.this);
                try {
                    long linhasInseridas = daoContato.inserir(dtoContato);
                    if (linhasInseridas > 0){
                        Toast.makeText(InclusaoActivity.this, "Inserido com sucesso!", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e){
                    Toast.makeText(InclusaoActivity.this, "Erro ao inserir: " + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}