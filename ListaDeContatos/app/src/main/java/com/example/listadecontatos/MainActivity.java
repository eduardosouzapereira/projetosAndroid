package com.example.listadecontatos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    DaoContato daoContato = new DaoContato(MainActivity.this);
    DtoContato contato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContato = findViewById(R.id.listViewContato);
        buttonAdicionarNovo = findViewById(R.id.buttonAdicionarNovo);


        editTextPesquisaNome = findViewById(R.id.editTextPesquisaNome);

        listViewContato.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                contato = arrayListContato.get(posicao);
                registerForContextMenu(listViewContato);
                return false;
            }
        });

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
                atualizarListView();
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
        atualizarListView();

    }

    private void atualizarListView() {
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListContato);
        listViewContato.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //(hierarquia, ordem em que aparece, id do objeto)
        menu.add(0,0,0, "Ligar");
        menu.add(0,1,1, "Detalhes");
        menu.add(0,2,2, "Excluir");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == 0){
            //Toast.makeText(this, "Ligando", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + contato.getTelefone()));
            startActivity(intent);
        } else if(item.getItemId() == 1){
            //Toast.makeText(this, "Detalhando", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
            intent.putExtra("id",contato.getId());
            intent.putExtra("nome", contato.getNome());
            intent.putExtra("email", contato.getEmail());
            intent.putExtra("telefone", contato.getTelefone());
            startActivity(intent);
        } else {
            //Toast.makeText(this, "Excluindo", Toast.LENGTH_SHORT).show();
            excluir();
        }
        return super.onContextItemSelected(item);
    }

    public void excluir(){
        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        msg.setMessage("Confirma exclusão?");
        msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int deletados = daoContato.excluir(contato);
                if (deletados > 0){
                    Toast.makeText(MainActivity.this, "Excluído com sucesso!", Toast.LENGTH_SHORT).show();
                    arrayListContato = daoContato.consultarTodos();
                    atualizarListView();
                }else {
                    Toast.makeText(MainActivity.this, "Erro ao excluir!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        msg.setNegativeButton("Não", null);
        msg.show();
    }
}