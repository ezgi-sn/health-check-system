package com.example.hospitalinfosystem

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context:Context):SQLiteOpenHelper(context,"list",null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE list (username TEXT PRIMARY KEY," +
                "password TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS list")
        onCreate(db)
    }
}