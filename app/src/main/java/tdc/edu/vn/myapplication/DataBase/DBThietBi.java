package tdc.edu.vn.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Model.ThietBi1;

public class DBThietBi {
    DBHelper dbHelper;

    public DBThietBi(Context context) {
       dbHelper= new DBHelper(context);
    }

    public void Them(ThietBi1 thietBi1)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matbi",thietBi1.getMaTB());
        values.put("tentbi",thietBi1.getTenTB());
        values.put("xuatxu",thietBi1.getXuatXu());
        values.put("maloai",thietBi1.getMaLoai());

        db.insert("ThietBi",null,values);
    }

    public  void Sua(ThietBi1 thietBi1)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matbi",thietBi1.getMaTB());
        values.put("tentbi",thietBi1.getTenTB());
        values.put("xuatxu",thietBi1.getXuatXu());
        values.put("maloai",thietBi1.getMaLoai());
        db.update("ThietBi",values,"matbi ='"+thietBi1.getMaTB() +"'",null);
    }
    public  void Xoa(ThietBi1 thietBi1)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from ThietBi where matbi= '"+thietBi1.getMaTB()+"'";
       db.execSQL(sql);
    }
    public ArrayList<ThietBi1> LayDL()
    {
        ArrayList<ThietBi1> data = new ArrayList<>();
        String sql="select * from ThietBi";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try{
            cursor.moveToFirst();
            do {
                ThietBi1 thietBi1 = new ThietBi1();
                thietBi1.setMaTB(cursor.getString(0));
                thietBi1.setTenTB(cursor.getString(1));
                thietBi1.setXuatXu(cursor.getString(2));
                thietBi1.setMaLoai(cursor.getString(3));
                data.add(thietBi1);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}



        return  data;
    }

    public ArrayList<ThietBi1> LayDL(String matbi)
    {
        ArrayList<ThietBi1> data = new ArrayList<>();
        String sql="select * from ThietBi where matbi ='"+matbi+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try{
            cursor.moveToFirst();
            do {
                ThietBi1 thietBi1 = new ThietBi1();
                thietBi1.setMaTB(cursor.getString(0));
                thietBi1.setTenTB(cursor.getString(1));
                thietBi1.setXuatXu(cursor.getString(2));
                thietBi1.setMaLoai(cursor.getString(3));
                data.add(thietBi1);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}
        return  data;
    }
    public ArrayList<String> LayMaTBi() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "select * from ThietBi ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                data.add(cursor.getString(0));
            }
            while (cursor.moveToNext());
        } catch (Exception ex) { }
        return data;
    }
}
