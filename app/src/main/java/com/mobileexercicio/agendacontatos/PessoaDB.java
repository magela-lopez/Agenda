package com.mobileexercicio.agendacontatos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PessoaDB extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    private static final String NOME_BANCO = "cadastroContatos.sqLite";
    private static final int VERSAO= 1;

    public PessoaDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"Criando tabela");
        db.execSQL("create table if not exists pessoa(id integer primary key autoincrement, nome text, celular text,endereco text, email text)");
        Log.d(TAG,"Tabela criada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long save(Pessoa pessoa){
        long id = pessoa.getId();
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome", pessoa.getNome());
            values.put("celular", pessoa.getCelular());
            values.put("endereco", pessoa.getEndereco());
            values.put("email",pessoa.getEmail());

            if(id!=0){
                //atualizar
                String id2 = String.valueOf(pessoa.getId());
                String[] whereArgs = new String []{id2};
                int count = db.update("pessoa", values,"id=?", whereArgs);
                return count;

            }else{
                //salvar novo
                id = db.insert("pessoa","",values);
                return id;
            }
        }finally {
            db.close();
        }
    }

    public List<Pessoa> findAll(){
        SQLiteDatabase db = getReadableDatabase();
        try {

            Cursor c= db.query("pessoa", null,null,null,null,null,null);
            return toList(c);

        }finally {
            db.close();
        }
    }

    @SuppressLint("Range")
    public List<Pessoa> toList(Cursor c){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        if(c.moveToNext()){
            do{
                Pessoa pessoa = new Pessoa();
                pessoa.setId(c.getInt(c.getColumnIndex("id")));
                pessoa.setNome(c.getString(c.getColumnIndex("nome")));
                pessoa.setCelular(c.getString(c.getColumnIndex("celular")));
                pessoa.setEndereco(c.getString(c.getColumnIndex("endereco")));
                pessoa.setEmail(c.getString(c.getColumnIndex("email")));
                pessoas.add(pessoa);
            }while(c.moveToNext());
        }
        return pessoas;
    }

    public int delete(Pessoa pessoa){
        SQLiteDatabase db = getWritableDatabase();
        try {

            int count = db.delete("pessoa", "id=?",new String[]{String.valueOf(pessoa.getId())});
            Log.i(TAG,"Pessoa " + count + " deletada");
            return count;
        }finally {
            db.close();
        }
    }
}
