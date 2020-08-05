package tdc.edu.vn.myapplication.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //CSDL
    public DBHelper( Context context) {
        super(context, "QLThietBi", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table LoaiThietBi(matb text, tentb text)";
        db.execSQL(sql);
        sql="create table PhongHoc(maphong text, loaiphong text, tang text)";
        db.execSQL(sql);
        sql="create table ThietBi(matbi text, tentbi text, xuatxu text, maloai text)";
        db.execSQL(sql);
        sql="create table ChiTietSuDung(maphong text, mathietbi text, ngaysudung text, soluong text)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
