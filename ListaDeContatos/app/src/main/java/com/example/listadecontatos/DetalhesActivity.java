package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {
    EditText editTextNomeDet, editTextEmailDet, editTextTelDet;
    Button buttonConfirmarAlteracao;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        editTextNomeDet = findViewById(R.id.editTextNomeDet);
        editTextEmailDet = findViewById(R.id.editTextEmailDet);
        editTextTelDet = findViewById(R.id.editTextTelDet);
        buttonConfirmarAlteracao = findViewById(R.id.buttonConfirmarAlteracao);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        editTextNomeDet.setText(bundle.getString("nome"));
        editTextEmailDet.setText(bundle.getString("email"));
                editTextTelDet.setText(bundle.getString("telefone"));

        buttonConfirmarAlteracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DtoContato dtoContato = new DtoContato();
                dtoContato.setId(id);
                dtoContato.setNome(editTextNomeDet.getText().toString());
                dtoContato.setEmail(editTextEmailDet.getText().toString());
                dtoContato.setTelefone(editTextTelDet.getText().toString());

                DaoContato daoContato = new DaoContato(DetalhesActivity.this);

                try {
                    long linhasInseridas = daoContato.alterar(dtoContato);
                    if (linhasInseridas > 0){
                        Toast.makeText(DetalhesActivity.this, "Alterado com sucesso!", Toast.LENGTH_LONG).show();
                        Intent main = new Intent(DetalhesActivity.this, MainActivity.class);
                        startActivity(main);
                    } else {
                        Toast.makeText(DetalhesActivity.this, "Não foi possível alterar. Motivo: MISTÉRIO TOTAL!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e){
                    Toast.makeText(DetalhesActivity.this, "Erro ao alterar: " + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}