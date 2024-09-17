package com.example.kellyortizf.medmob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class CriaBanco extends SQLiteOpenHelper {
    private static final String paciente = "paciente.db";
    private static final String pessoal = "pessoal";
    private static final String ID = "id";
    public static final String NOME = "nomeUsuario";
    public static final String ENDERECO = "enderecoUsuario";
    private static final String dataNascimento="dataNascimento";
    public static final String TELEFONE = "telefone";
    public static final String CEP = "cep";
    private static final String CPF = "cpf";
    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, paciente,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE"+pessoal+"("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + ENDERECO + " text,"
                + dataNascimento + " text,"
                + TELEFONE + " text,"
                + CEP+ " text,"
                + CPF + " text"
                +")";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTES" + pessoal);
        onCreate(db);
    }
}