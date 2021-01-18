package com.example.smartcompliance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 2ndgengod on 1/18/2021.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "compliance.db";
    private static final int DATABASE_VERSION = 1 ;
    public static final String TABLE_NAME = "Compliance";
    public static final String COLUMN_VALUE = "value";
    public static final String COLUMN_HAULIER = "haulier";
    public static final String COLUMN_DELIVERY = "delivery";
    public static final String COLUMN_DESTINATION = "destination";
    public static final String COLUMN_VARIANCE = "variance";
    public static final String COLUMN_LOADED = "loaded";
    public static final String COLUMN_REPLACE = "replace";
    public static final String COLUMN_UNDEROVER = "underover";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_VALUE + " TEXT NOT NULL, " +
                COLUMN_HAULIER + " TEXT NOT NULL, " +
                COLUMN_DELIVERY + " TEXT NOT NULL, " +
                COLUMN_DESTINATION + " TEXT NOT NULL, " +
                COLUMN_VARIANCE + " TEXT NOT NULL, " +
                COLUMN_LOADED + " TEXT NOT NULL, " +
                COLUMN_REPLACE + " TEXT NOT NULL, " +
                COLUMN_UNDEROVER + " TEXT NOT NULL);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }
    /**create record**/
    public void saveNewData(Data data) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_VALUE, data.getmValue());
        values.put(COLUMN_HAULIER, data.getmHaulier());
        values.put(COLUMN_DELIVERY, data.getmDelivery());
        values.put(COLUMN_DESTINATION, data.getmDestination());
        values.put(COLUMN_VARIANCE, data.getmVariance());
        values.put(COLUMN_LOADED, data.getmLoaded());
        values.put(COLUMN_REPLACE, data.getmReplace());
        values.put(COLUMN_UNDEROVER,data.getmUnderOver() );

        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    /**Query records, give options to filter results**/
    public List<Data> dataList(String filter) {
        String query;
        if(filter.equals("")){
            //regular query
            query = "SELECT  * FROM " + TABLE_NAME;
        }else{
            //filter results by filter option provided
            query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ filter;
        }

        List<Data> dataLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Data data;

        if (cursor.moveToFirst()) {
            do {
                data = new Data();
                data.setmValue(cursor.getString(cursor.getColumnIndex(COLUMN_VALUE)));
                data.setmHaulier(cursor.getString(cursor.getColumnIndex(COLUMN_HAULIER)));
                data.setmDelivery(cursor.getString(cursor.getColumnIndex(COLUMN_DELIVERY)));
                data.setmDestination(cursor.getString(cursor.getColumnIndex(COLUMN_DESTINATION)));
                data.setmVariance(cursor.getString(cursor.getColumnIndex(COLUMN_VARIANCE)));
                data.setmLoaded(cursor.getString(cursor.getColumnIndex(COLUMN_LOADED)));
                data.setmReplace(cursor.getString(cursor.getColumnIndex(COLUMN_REPLACE)));
                data.setmUnderOver(cursor.getString(cursor.getColumnIndex(COLUMN_UNDEROVER)));
                dataLinkedList.add(data);
            } while (cursor.moveToNext());
        }


        return dataLinkedList;
    }

    /**Query only 1 record**/
    public Data getPerson(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE _id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        Data data = new Data();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            data.setmValue(cursor.getString(cursor.getColumnIndex(COLUMN_VALUE)));
            data.setmHaulier(cursor.getString(cursor.getColumnIndex(COLUMN_HAULIER)));
            data.setmDelivery(cursor.getString(cursor.getColumnIndex(COLUMN_DELIVERY)));
            data.setmDestination(cursor.getString(cursor.getColumnIndex(COLUMN_DESTINATION)));
            data.setmVariance(cursor.getString(cursor.getColumnIndex(COLUMN_VARIANCE)));
            data.setmLoaded(cursor.getString(cursor.getColumnIndex(COLUMN_LOADED)));
            data.setmReplace(cursor.getString(cursor.getColumnIndex(COLUMN_REPLACE)));
            data.setmUnderOver(cursor.getString(cursor.getColumnIndex(COLUMN_UNDEROVER)));
        }



        return data;


    }


    /**delete record**/
    public void deleteDataRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE _id='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    /**update record**/
    public void updateDataRecord(long dataId, Context context, Data updatedData) {
        SQLiteDatabase db = this.getWritableDatabase();
        //you can use the constants above instead of typing the column names
        db.execSQL("UPDATE  "+TABLE_NAME+" SET value ='"+ updatedData.getmValue() + "', " +
                "haulier ='" + updatedData.getmHaulier()+ "', delivery ='"+ updatedData.getmDelivery() + "'," +
                " destination ='"+ updatedData.getmDestination() + "variance ='" + updatedData.getmVariance()+
                "loaded ='" + updatedData.getmLoaded()+"replace ='" + updatedData.getmReplace()+
                "underover ='" + updatedData.getmUnderOver()+"'  WHERE _id='" + dataId + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();


    }




}