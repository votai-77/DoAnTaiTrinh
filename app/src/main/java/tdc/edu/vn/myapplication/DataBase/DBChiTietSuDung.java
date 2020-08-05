package tdc.edu.vn.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Model.ChiTietSuDung;


public class DBChiTietSuDung {
    DBHelper dbHelper;

    public DBChiTietSuDung(Context context) {
       dbHelper= new DBHelper(context);
    }

    public void Them(ChiTietSuDung chiTietSuDung)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maphong",chiTietSuDung.getMaPhong());
        values.put("mathietbi",chiTietSuDung.getMaTB());
        values.put("ngaysudung",chiTietSuDung.getNgaySD());
        values.put("soluong",chiTietSuDung.getSoLuong());
        db.insert("ChiTietSuDung",null,values);
    }

    public  void Sua(ChiTietSuDung chiTietSuDung)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maphong",chiTietSuDung.getMaPhong());
        values.put("mathietbi",chiTietSuDung.getMaTB());
        values.put("ngaysudung",chiTietSuDung.getNgaySD());
        values.put("soluong",chiTietSuDung.getSoLuong());
        db.update("ChiTietSuDung",values,"maphong ='"+chiTietSuDung.getMaPhong() +"'",null);
    }


    public  void Xoa(ChiTietSuDung chiTietSuDung)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from ChiTietSuDung where soluong= '"+chiTietSuDung.getSoLuong()+"'";
        db.execSQL(sql);
    }

    public ArrayList<ChiTietSuDung> LayDL()
    {
        ArrayList<ChiTietSuDung> data = new ArrayList<>();
        String sql="select * from ChiTietSuDung";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        try{
            cursor.moveToFirst();
            do {
                ChiTietSuDung chiTietSuDung = new ChiTietSuDung();
                chiTietSuDung.setMaPhong(cursor.getString(0));
                chiTietSuDung.setMaTB(cursor.getString(1));
                chiTietSuDung.setNgaySD(cursor.getString(2));
                chiTietSuDung.setSoLuong(cursor.getString(3));
                data.add(chiTietSuDung);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex ) {}
        return  data;
    }

    public ArrayList<ChiTietSuDung> LayDL(String maphong)
    {
        ArrayList<ChiTietSuDung> data = new ArrayList<>();
        String sql="select * from ChiTietSuDung where maphong ='"+maphong+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try{
            cursor.moveToFirst();
            do {
                ChiTietSuDung chiTietSuDung = new ChiTietSuDung();
                chiTietSuDung.setMaPhong(cursor.getString(0));
                chiTietSuDung.setMaTB(cursor.getString(1));
                chiTietSuDung.setNgaySD(cursor.getString(2));
                chiTietSuDung.setSoLuong(cursor.getString(3));
                data.add(chiTietSuDung);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}



        return  data;
    }
    public ArrayList<Integer> LaySoLuong() {

        ArrayList<Integer> data = new ArrayList<>();
        String sql = "select * from ChiTietSuDung ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {

                data.add(cursor.getInt(0));
            }

            while (cursor.moveToNext());
        } catch (Exception ex) {

        }
        return data;
    }
    public ArrayList<ChiTietSuDung> LayDLSL(Integer soLuong)
    {
        ArrayList<ChiTietSuDung> data = new ArrayList<>();
        String sql="select * from ChiTietSuDung where soluong ='"+soLuong+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try{
            cursor.moveToFirst();
            do {
                ChiTietSuDung chiTietSuDung = new ChiTietSuDung();
                chiTietSuDung.setMaPhong(cursor.getString(0));
                chiTietSuDung.setMaTB(cursor.getString(1));
                chiTietSuDung.setNgaySD(cursor.getString(2));
                chiTietSuDung.setSoLuong(cursor.getString(3));
                data.add(chiTietSuDung);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}



        return  data;
    }
}
