package com.example.cadempregadosv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "empregado_db";
    private static String TABLE_NAME = "empregados";

    //Campos
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOME + " TEXT NOT NULL, " +
            EMAIL + " TEXT NOT NULL);";

    private SQLiteDatabase sqLiteDatabase;


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void adicionarEmpregado(EmpregadoModel empregadoModel){
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.NOME, empregadoModel.getNome());
        cv.put(DataBaseHelper.EMAIL, empregadoModel.getEmail());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DataBaseHelper.TABLE_NAME, null, cv);
    }
}
