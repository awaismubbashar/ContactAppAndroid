package com.example.contactapp.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private const val DATABASE_VERSION = 1
const val DATABASE_NAME = "contactDB.db"
const val TABLE_SQLite = "Contact"

class AppDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)  {
    override fun onCreate(db: SQLiteDatabase?) {
//        val SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_SQLite.toString() + " (" +
//                COLUMN_ID.toString() + " INTEGER PRIMARY KEY autoincrement, " +
//                COLUMN_NAME.toString() + " TEXT NOT NULL, " +
//                COLUMN_ADDRESS.toString() + " TEXT NOT NULL" +
//                " )"
        val SQL_CREATE_MOVIE_TABLE = "CREATE TABLE $TABLE_SQLite (id INTEGER PRIMARY KEY autoincrement, name TEXT NOT NULL, age TEXT NOT NULL, phoneNumber TEXT NOT NULL )"
        db?.execSQL(SQL_CREATE_MOVIE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SQLite")
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addValuesToContactTable(name : String, age : String, phoneNumber: String){

        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("age", age)
            put("phoneNumber", phoneNumber)
        }
        db?.insert(TABLE_SQLite, null, values)
    }

    fun getContactFromDB(): Cursor? {

        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_SQLite, null)
    }

}