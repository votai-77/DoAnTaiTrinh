package tdc.edu.vn.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Model.ThietBi;

public class DBLoaiThietBi {
    DBHelper dbHelper;

    public DBLoaiThietBi(Context context) {
       dbHelper= new DBHelper(context);
    }

    public void Them(ThietBi thietBi)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matb",thietBi.getMaLoai());
        values.put("tentb",thietBi.getTenLoai());

        db.insert("LoaiThietBi",null,values);
    }

    public  void Sua(ThietBi thietBi)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matb",thietBi.getMaLoai());
        values.put("tentb",thietBi.getTenLoai());
        db.update("LoaiThietBi",values,"matb ='"+thietBi.getMaLoai() +"'",null);
    }


    public  void Xoa(ThietBi thietBi)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from LoaiThietBi where matb= '"+thietBi.getMaLoai()+"'";
       db.execSQL(sql);

    }

    public ArrayList<ThietBi> LayDL()
    {
        ArrayList<ThietBi> data = new ArrayList<>();
        String sql="select * from LoaiThietBi";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try{
            cursor.moveToFirst();
            do {
                ThietBi thietBi = new ThietBi();
                thietBi.setMaLoai(cursor.getString(0));
                thietBi.setTenLoai(cursor.getString(1));
                data.add(thietBi);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}
        return  data;
    }
    public ArrayList<ThietBi> LayDL(String matb)
    {
        ArrayList<ThietBi> data = new ArrayList<>();
        String sql="select * from LoaiThietBi where matb ='"+matb+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try{
            cursor.moveToFirst();
            do {
                ThietBi thietBi = new ThietBi();
                thietBi.setMaLoai(cursor.getString(0));
                thietBi.setTenLoai(cursor.getString(1));
                data.add(thietBi);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}
        return  data;
    }
    public ArrayList<String> LayMaLoai() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "select * from LoaiThietBi ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                data.add(cursor.getString(0));
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
        }
        return data;
    }
}
