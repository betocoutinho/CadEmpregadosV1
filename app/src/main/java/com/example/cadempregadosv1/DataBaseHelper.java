package com.example.cadempregadosv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    public List<EmpregadoModel> obterEmpregados(){
        String sql = "SELECT * FROM " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();

        List<EmpregadoModel> lista = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String nome = cursor.getString(1);
                String email = cursor.getString(2);

                lista.add(new EmpregadoModel(id, nome, email));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return lista;

    }

    public void atualizarEmpregrado(EmpregadoModel empregadoModel){
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.NOME, empregadoModel.getNome());
        cv.put(DataBaseHelper.EMAIL, empregadoModel.getEmail());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME, cv, ID + "=?", new String[]{String.valueOf(empregadoModel.getId())});
    }

    public void removerEmpregado(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(id)});
    }
}
