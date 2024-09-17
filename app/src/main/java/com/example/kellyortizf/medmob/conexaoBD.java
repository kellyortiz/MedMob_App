package com.example.kellyortizf.medmob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conexaoBD extends SQLiteOpenHelper {
        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_POSTS =
                "CREATE TABLE " + PostEntry.TABLE_NAME + " (" +
                        PostEntry._ID + " INTEGER PRIMARY KEY," +
                        PostEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                        PostEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE + " )";
        private static final String SQL_DELETE_POSTS =
                "DROP TABLE IF EXISTS " + PostEntry.TABLE_NAME;
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "FeedReader.db";
    public conexaoBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
        public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_POSTS);
    }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_POSTS);
        onCreate(db);
    }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    }