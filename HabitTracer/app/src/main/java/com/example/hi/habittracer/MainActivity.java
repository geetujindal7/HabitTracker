package com.example.hi.habittracer;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hi.habittracer.DATA.HabitDBHelper;
import com.example.hi.habittracer.DATA.Habit_Contract.HabitAdd;


public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayDatabaseInfo();
        Button button = (Button) findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertHabit();
                TextView textView = (TextView) findViewById(R.id.display);
                textView.setText("");
                displayDatabaseInfo();
            }
        });
    }
    HabitDBHelper mHelper = new HabitDBHelper(this);
    private void insertHabit() {
        ContentValues values = new ContentValues();
        values.put(HabitAdd.COLUMN_NAME, "ANDROID BASIC");
        values.put(HabitAdd.COLUMN_NAME1, "ND");
        values.put(HabitAdd.COLUMN_NAME2, "UDACITY");
        values.put(HabitAdd.COLUMN_NAME3,"2008");
        db.insert(HabitAdd.TABLE_NAME, null, values);
    }
    private void displayDatabaseInfo() {
        db = mHelper.getReadableDatabase();
        Cursor cursor = readMethod();
        TextView displayView = (TextView) findViewById(R.id.display);
        try
        {
            int idColumnIndex = cursor.getColumnIndex(HabitAdd._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitAdd.COLUMN_NAME);
            int name1ColumnIndex = cursor.getColumnIndex(HabitAdd.COLUMN_NAME1);
            int name2ColumnIndex = cursor.getColumnIndex(HabitAdd.COLUMN_NAME2);
            int name3ColumnIndex = cursor.getColumnIndex(HabitAdd.COLUMN_NAME3);
            while (cursor.moveToNext()) {
                int currentId = cursor.getInt(idColumnIndex);
                String frstname = cursor.getString(nameColumnIndex);
                String nxtname = cursor.getString(name1ColumnIndex);
                String lastname = cursor.getString(name2ColumnIndex);
                int num = cursor.getInt(name3ColumnIndex);
                displayView.append(("\n" + currentId + "-" + frstname + "-" +
                        nxtname + "-" + lastname + "-" + num));
            }
        }
        finally
        {
            cursor.close();
        }
    }
    public Cursor readMethod()
    {
        String[] projection = {
                HabitAdd._ID,
                HabitAdd.COLUMN_NAME,
                HabitAdd.COLUMN_NAME1,
                HabitAdd.COLUMN_NAME2,
                HabitAdd.COLUMN_NAME3,
        };
        db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(
                HabitAdd.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }
}