package com.example.listfavoritefootballclubapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_champions";
    private static final String tb_football = "tb_football";
    private static final String tb_football_id = "id";
    private static final String tb_football_club = "club";
    private static final String tb_football_juara = "juara";
    private static final String tb_football_liga = "liga";


    private static final String CREATE_TABLE_FOOTBALL = "CREATE TABLE " +
            tb_football +"("
            + tb_football_id + " INTEGER PRIMARY KEY ,"
            + tb_football_club + " TEXT ,"
            + tb_football_juara + " TEXT ,"
            + tb_football_liga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FOOTBALL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void CreateFootball(Football data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_football_id, data.get_id());
        values.put(tb_football_club, data.get_club());
        values.put(tb_football_juara, data.get_juara());
        values.put(tb_football_liga, data.get_liga());
        db.insert(tb_football, null, values);
        db.close();
    }

    public List<Football> ReadFootball(){
        List<Football> listFootball = new ArrayList<Football>();
        String selectQuery = "SELECT * FROM " + tb_football;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Football data = new Football();
                data.set_id(cursor.getString(0));
                data.set_club(cursor.getString(1));
                data.set_juara(cursor.getString(2));
                data.set_liga(cursor.getString(3));
                listFootball.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listFootball;
    }

    public int UpdateFootball (Football data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_football_club, data.get_club());
        values.put(tb_football_juara, data.get_juara());
        values.put(tb_football_liga, data.get_liga());

        return db.update(tb_football, values, tb_football_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteFootball(Football data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_football,tb_football_id + " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

