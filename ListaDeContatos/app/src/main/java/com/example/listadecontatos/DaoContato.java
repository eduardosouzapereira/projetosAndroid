package com.example.listadecontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaoContato extends SQLiteOpenHelper {

    private final String TABELA = "TB_CONTATO";

    public DaoContato(@Nullable Context context) {
        super(context, "DB_CONTATO", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String comando = "CREATE TABLE " + TABELA + "(" +
                "ID INTEGER PRIMARY KEY, " +
                "NOME VARCHAR(100), " +
                "EMAIL VARCHAR(50), " +
                "TELEFONE VARCHAR(15))";

        sqLiteDatabase.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long inserir(DtoContato contato) {
        ContentValues values = new ContentValues();
        values.put("NOME", contato.getNome());
        values.put("EMAIL", contato.getEmail());
        values.put("TELEFONE", contato.getTelefone());

        return getWritableDatabase().insert(TABELA, null, values);
    }

    public ArrayList<DtoContato> consultarTodos() {
        String comando = "SELECT * FROM " + TABELA;
        Cursor cursor = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoContato> arrayListContato = new ArrayList<>();
        while (cursor.moveToNext()) {
            DtoContato dtoContato = new DtoContato();
            dtoContato.setId(cursor.getInt(0));
            dtoContato.setNome(cursor.getString(1));
            dtoContato.setEmail(cursor.getString(2));
            dtoContato.setTelefone(cursor.getString(3));
            arrayListContato.add(dtoContato);
        }
        return arrayListContato;
    }
}
