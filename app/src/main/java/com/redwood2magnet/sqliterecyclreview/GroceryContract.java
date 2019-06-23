package com.redwood2magnet.sqliterecyclreview;

import android.provider.BaseColumns;

public class GroceryContract {
    private GroceryContract(){

    }
    public static final class GroceryEntry implements BaseColumns{
        public static final String TABLE_NAME="groceryListtable";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_AMOUNT="amount";
        public static final String COLUMN_TIMESTAMP="timestamp";
        //public static int KEY_ID;
    }
}
