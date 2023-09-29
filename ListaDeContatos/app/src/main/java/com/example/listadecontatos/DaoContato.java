package com.example.listadecontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DaoContato extends SQLiteOpenHelper {

    private final String TABELA = "TB_CONTATO";

    public DaoContato(@Nullable Context context) {
        super(context, "DB_CONTATO", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String comando = "CREATE TABLE TB_CONTATO(" +
                "ID INTEGER PRIMARY KEY, " +
                "NOME VARCHAR(100), " +
                "EMAIL VARCHAR(50), " +
                "TELEFONE VARCHAR(15))";

        sqLiteDatabase.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long inserir(DtoContato contato){
        ContentValues values = new ContentValues();
        values.put("NOME", contato.getNome());
        values.put("EMAIL", contato.getEmail());
        values.put("TELEFONE", contato.getTelefone());

        return getWritableDatabase().insert(TABELA, null, values);
    }
}
