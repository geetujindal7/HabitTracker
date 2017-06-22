package com.example.hi.habittracer.DATA;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by hi on 24-05-2017.
 */

public final class Habit_Contract {
    public static final String CONTENT_AUTHORITY = "com.example.android.habittracer";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_Udac = "Android Basic";

    public static final class HabitAdd implements BaseColumns {
        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath(PATH_Udac).build();
        public static final String TABLE_NAME ="Udac";
        public static final String COlUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "firstName";
        public static final String COLUMN_NAME1 = "NextName";
        public static final String COLUMN_NAME2 = "LastName";
        public static final String COLUMN_NAME3 ="Number";
    }
}
