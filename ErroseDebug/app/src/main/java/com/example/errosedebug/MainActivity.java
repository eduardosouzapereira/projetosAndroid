package com.example.errosedebug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd1, buttonIncluirSenha, getButtonAdd1;
    EditText editTextSenha, editTextConfirmaSenha, editTextContador;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd1 = findViewById(R.id.buttonAdd1);
        buttonIncluirSenha = findViewById(R.id.buttonIncluirSenha);
        editTextSenha = findViewById(R.id.editTextSenha1);
        editTextConfirmaSenha = findViewById(R.id.editTextSenha2);
        editTextContador = findViewById(R.id.editTextContador);

        buttonIncluirSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String senha = editTextSenha.getText().toString();
                String confirmaSenha = editTextConfirmaSenha.getText().toString();

                if(senha.equals(confirmaSenha)){
                    Log.d("senhas", "senhas iguais");
                    Toast.makeText(MainActivity.this, "Iguais",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "Diferentes",Toast.LENGTH_SHORT).show();
                }

                /*int valor = 1;
                valor = 2;
                valor = 3;
                chamaMetodoTeste();
                valor = 4;*/
            }
        });

        buttonAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                editTextContador.setText(""+i);
            }
        });

    }

    private void chamaMetodoTeste() {
        int valor = 1;
        valor = 2;
        valor = 3;
    }
}