package com.example.hospitalinfosystem

import android.content.ContentValues
import android.util.Log

class listDao {
    fun addToList(db:DatabaseHelper, username:String,password:String){
        val dbx=db.writableDatabase
        val values=ContentValues()
        values.put("username",username)
        values.put("password",password)
        dbx.insertOrThrow("list",null,values)
        dbx.close()
    }
    fun searchUsername(db: DatabaseHelper, username: String):Boolean{
        val dbx=db.writableDatabase
        val cursor=dbx.rawQuery("SELECT * FROM list WHERE username like '%$username%'",null  )
        var flag=false
        while(cursor.moveToNext()){
            val person=list(cursor.getString(cursor.getColumnIndex("username"))
            ,cursor.getString(cursor.getColumnIndex("password")))
            val personName=person.username
            if(personName==username){
                flag=true
            }
        }
        return flag
    }
    fun searchPassword(db: DatabaseHelper, password: String):Boolean{
        val dbx=db.writableDatabase
        val cursor=dbx.rawQuery("SELECT * FROM list WHERE password like '%$password%'",null  )
        var flag=false
        while(cursor.moveToNext()){
            val person=list(cursor.getString(cursor.getColumnIndex("username"))
                    ,cursor.getString(cursor.getColumnIndex("password")))
            val personPassword=person.password
            if(personPassword==password){
                flag=true
            }
        }
        return flag
    }

    
}