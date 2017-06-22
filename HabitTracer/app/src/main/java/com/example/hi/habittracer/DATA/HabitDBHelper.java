package com.example.hi.habittracer.DATA;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hi.habittracer.DATA.Habit_Contract.HabitAdd;
/**
 * Created by hi on 24-05-2017.
 */

public class HabitDBHelper extends SQLiteOpenHelper {
    /*public static final String LOG_TAG = HabitDBHelper.class.getSimpleName();*/
    private static final String DATABASE_NAME = "habittracer.db";
    private static final int DATABASE_VERSION = 4 ;

    public HabitDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    private static final String SQL_CREATE_UDACITY_TABLE = "CREATE TABLE " + HabitAdd.TABLE_NAME + "("
            + HabitAdd.COlUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + HabitAdd.COLUMN_NAME + " TEXT NOT NULL, "
            + HabitAdd.COLUMN_NAME1 + " TEXT NOT NULL, "
            + HabitAdd.COLUMN_NAME2 + " TEXT NOT NULL, " +HabitAdd.COLUMN_NAME3 + " INTEGER NOT NULL DEFAULT 0);";
    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS" + HabitAdd.TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_UDACITY_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion)
    {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }
}