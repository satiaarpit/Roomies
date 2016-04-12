package com.example.asatia.roomies;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asatia on 11/11/2015.
 */
public class BillDataBase extends SQLiteOpenHelper {

    MainActivity activity;
    private static final String DATABASE_NAME="bill";
    private static final String TABLE_NAME="billdata";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_DATE="date";
    private static final String COLUMN_AMOUNT="amount";
    private static final String COLUMN_SHOP="shop";
    private static final String COLUMN_PAYER="payer";
    private static final String COLUMN_SHARER="sharer";
    private static final int DATABASE_VERSION = 1;

    public BillDataBase(Activity activity)   {
        super(activity.getApplicationContext(),DATABASE_NAME,null,DATABASE_VERSION);
        this.activity=(MainActivity)activity;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_AMOUNT + " TEXT, "
                + COLUMN_SHOP + " TEXT, "
                + COLUMN_PAYER + " TEXT, "
                + COLUMN_SHARER + " TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertBill(BillListItem item)   {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_DATE,item.getDate());
        values.put(COLUMN_AMOUNT,item.getAmount()+"");
        values.put(COLUMN_SHOP,item.getShop());
        values.put(COLUMN_PAYER,item.getPaidBy());
        values.put(COLUMN_SHARER, item.getSharedBy());
        db.insert(TABLE_NAME, null, values);
        db.close();
        return true;
    }

    public boolean deleteBills()   {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
        db.close();
        return true;
    }

    public BillListItem[] getBills()  {
        BillListItem item[];
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if(cursor!=null) {
            cursor.moveToFirst();
            item = new BillListItem[cursor.getCount()];
            for (int i = 0; i < item.length; i++) {
                item[i]=new BillListItem();
                item[i].setID(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                item[i].setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                item[i].setAmount(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                item[i].setShop(cursor.getString(cursor.getColumnIndex(COLUMN_SHOP)));
                item[i].setPaidBy(cursor.getString(cursor.getColumnIndex(COLUMN_PAYER)));
                item[i].setSharedBy(cursor.getString(cursor.getColumnIndex(COLUMN_SHARER)));
                cursor.moveToNext();
            }
            db.close();
            return item;
        }
        return null;
    }
    public boolean updateBill (BillListItem item)  {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(COLUMN_DATE,item.getDate());
        value.put(COLUMN_AMOUNT,item.getAmount());
        value.put(COLUMN_SHOP,item.getShop());
        value.put(COLUMN_PAYER,item.getPaidBy());
        value.put(COLUMN_SHARER,item.getSharedBy());
        db.update(TABLE_NAME,value,COLUMN_ID + "= ?",new String[]{item.getID()+""});
        db.close();
        return true;
    }

    public boolean deleteBill(int id)   {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + id);
        db.close();
        return true;
    }
    public Map<String,Double> getBillContribution() {
        SQLiteDatabase db=this.getReadableDatabase();
        double amount;
        Map<String,Double> map=new HashMap<>();
        Cursor cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT+ " FROM " + TABLE_NAME + " WHERE " + COLUMN_PAYER + " LIKE \"Arpit\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                amount+=Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                cursor.moveToNext();
            }
            map.put("Arpit",amount);
        }
        else {
            map.put("Arpit",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT + " FROM " + TABLE_NAME + " WHERE " + COLUMN_PAYER + " LIKE \"Nirav\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                amount+=Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                cursor.moveToNext();
            }
            map.put("Nirav",amount);
        }
        else {
            map.put("Nirav",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT + " FROM " + TABLE_NAME + " WHERE " + COLUMN_PAYER + " LIKE \"Rutvij\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                amount+=Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                cursor.moveToNext();
            }
            map.put("Rutvij",amount);
        }
        else {
            map.put("Rutvij",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT + " FROM " + TABLE_NAME + " WHERE " + COLUMN_PAYER + " LIKE \"Utsav\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                amount+=Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                cursor.moveToNext();
            }
            map.put("Utsav",amount);
        }
        else {
            map.put("Utsav",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT + " FROM " + TABLE_NAME + " WHERE " + COLUMN_PAYER + " LIKE \"Valmik\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                amount+=Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                cursor.moveToNext();
            }
            map.put("Valmik",amount);
        }
        else {
            map.put("Valmik",0.0);
        }
        return map;
    }

    public Map<String,Double> getBillExpense() {
        SQLiteDatabase db=this.getReadableDatabase();
        double amount;
        String sharer[];
        Map<String,Double> map=new HashMap<>();
        Cursor cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT +","+ COLUMN_SHARER + " FROM " + TABLE_NAME + " WHERE " + COLUMN_SHARER + " LIKE \"%Arpit%\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                sharer=cursor.getString(cursor.getColumnIndex(COLUMN_SHARER)).split(" ");
                amount+=(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))/sharer.length);
                cursor.moveToNext();
            }
            amount=(Math.round(Math.abs(amount)*100))/100.0;
            map.put("Arpit",amount);
        }
        else {
            map.put("Arpit",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT +","+ COLUMN_SHARER + " FROM " + TABLE_NAME + " WHERE " + COLUMN_SHARER + " LIKE \"%Nirav%\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                sharer=cursor.getString(cursor.getColumnIndex(COLUMN_SHARER)).split(" ");
                amount+=(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))/sharer.length);
                cursor.moveToNext();
            }
            amount=(Math.round(Math.abs(amount)*100))/100.0;
            map.put("Nirav",amount);
        }
        else {
            map.put("Nirav",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT +","+ COLUMN_SHARER + " FROM " + TABLE_NAME + " WHERE " + COLUMN_SHARER + " LIKE \"%Rutvij%\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                sharer=cursor.getString(cursor.getColumnIndex(COLUMN_SHARER)).split(" ");
                amount+=(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))/sharer.length);
                cursor.moveToNext();
            }
            amount=(Math.round(Math.abs(amount)*100))/100.0;
            map.put("Rutvij",amount);
        }
        else {
            map.put("Rutvij",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT +","+ COLUMN_SHARER + " FROM " + TABLE_NAME + " WHERE " + COLUMN_SHARER + " LIKE \"%Utsav%\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                sharer=cursor.getString(cursor.getColumnIndex(COLUMN_SHARER)).split(" ");
                amount+=(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))/sharer.length);
                cursor.moveToNext();
            }
            amount=(Math.round(Math.abs(amount)*100))/100.0;
            map.put("Utsav",amount);
        }
        else {
            map.put("Utsav",0.0);
        }
        cursor=db.rawQuery("SELECT " + COLUMN_AMOUNT +","+ COLUMN_SHARER + " FROM " + TABLE_NAME + " WHERE " + COLUMN_SHARER + " LIKE \"%Valmik%\";", null);
        if(cursor!=null) {
            cursor.moveToFirst();
            amount=0.0;
            for (int i = 1; i <= cursor.getCount(); i++) {
                sharer=cursor.getString(cursor.getColumnIndex(COLUMN_SHARER)).split(" ");
                amount+=(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))/sharer.length);
                cursor.moveToNext();
            }
            amount=(Math.round(Math.abs(amount)*100))/100.0;
            map.put("Valmik",amount);
        }
        else {
            map.put("Valmik",0.0);
        }
        return map;
    }
}
