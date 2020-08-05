package tdc.edu.vn.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Model.PhongHoc;

public class DBPhongHoc {
    DBHelper dbHelper;

    public DBPhongHoc(Context context) {
       dbHelper= new DBHelper(context);
    }

    public void Them(PhongHoc phongHoc)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maphong",phongHoc.getMaPhong());
        values.put("loaiphong",phongHoc.getLoaiPhong());
        values.put("tang",phongHoc.getTang());
        db.insert("PhongHoc",null,values);
    }

    public  void Sua(PhongHoc phongHoc)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maphong",phongHoc.getMaPhong());
        values.put("loaiphong",phongHoc.getLoaiPhong());
        values.put("tang",phongHoc.getTang());
        db.update("PhongHoc",values,"maphong ='"+phongHoc.getMaPhong() +"'",null);
    }


    public  void Xoa(PhongHoc phongHoc)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from PhongHoc where maphong= '"+phongHoc.getMaPhong()+"'";
       db.execSQL(sql);

    }

    public ArrayList<PhongHoc> LayDL()
    {
        ArrayList<PhongHoc> data = new ArrayList<>();
        String sql="select * from PhongHoc";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try{
            cursor.moveToFirst();
            do {
                PhongHoc phongHoc = new PhongHoc();
                phongHoc.setMaPhong(cursor.getString(0));
                phongHoc.setLoaiPhong(cursor.getString(1));
                phongHoc.setTang(cursor.getString(2));
                data.add(phongHoc);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}
        return  data;
    }
    public ArrayList<PhongHoc> LayDL(String maphong)
    {
        ArrayList<PhongHoc> data = new ArrayList<>();
        String sql="select * from PhongHoc where maphong ='"+maphong+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try{
            cursor.moveToFirst();
            do {
                PhongHoc phongHoc = new PhongHoc();
                phongHoc.setMaPhong(cursor.getString(0));
                phongHoc.setLoaiPhong(cursor.getString(1));
                phongHoc.setTang(cursor.getString(2));
                data.add(phongHoc);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}



        return  data;
    }
    public ArrayList<String> LayMaPhong() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "select * from PhongHoc ";
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
