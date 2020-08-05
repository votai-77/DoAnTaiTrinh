package tdc.edu.vn.myapplication.GiaoDien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


import tdc.edu.vn.myapplication.Adapter.CustomApdapterPH;
import tdc.edu.vn.myapplication.DataBase.DBPhongHoc;
import tdc.edu.vn.myapplication.Model.PhongHoc;
import tdc.edu.vn.myapplication.R;


public class MainPhongHoc extends AppCompatActivity {

    Button btnThem, btnXoa, btnSua;
    EditText txtMaPhong, txtLoaiPhong, txtTang;
    ListView lvDanhSach;

    int index = -1;

    CustomApdapterPH apdapter;

    ArrayList<PhongHoc> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_phong_hoc);

        setControl();
        setEvent();
        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
    }

    private void setEvent() {
        HienThiDL();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDL();
                HienThiDL();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuaDL();
                HienThiDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDL();
                HienThiDL();
            }
        });
       lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               PhongHoc phongHoc = data.get(position);
               txtMaPhong.setText(phongHoc.getMaPhong());
              txtLoaiPhong.setText(phongHoc.getLoaiPhong());
              txtTang.setText(phongHoc.getTang());
             index = position;

           }
        });

    }




    private void HienThiDL() {
        DBPhongHoc dbPhongHoc = new DBPhongHoc(this);
        data = dbPhongHoc.LayDL();
        apdapter = new CustomApdapterPH(MainPhongHoc.this, R.layout.listview_item_ph, data);
        lvDanhSach.setAdapter(apdapter);
    }

    private void ThemDL() {
        PhongHoc phongHoc = new PhongHoc();
        phongHoc.setMaPhong(txtMaPhong.getText().toString());
        phongHoc.setLoaiPhong(txtLoaiPhong.getText().toString());
        phongHoc.setTang(txtTang.getText().toString());

        DBPhongHoc dbPhongHoc = new DBPhongHoc(this);
        dbPhongHoc.Them(phongHoc);
    }
    private void SuaDL() {
        PhongHoc phongHoc = new PhongHoc();
        phongHoc.setMaPhong(txtMaPhong.getText().toString());
        phongHoc.setLoaiPhong(txtLoaiPhong.getText().toString());
        phongHoc.setTang(txtTang.getText().toString());
        DBPhongHoc dbPhongHoc = new DBPhongHoc(this);
        dbPhongHoc.Sua(phongHoc);
    }
    private void XoaDL() {
        PhongHoc phongHoc = new PhongHoc();
        phongHoc.setMaPhong(txtMaPhong.getText().toString());
        phongHoc.setLoaiPhong(txtLoaiPhong.getText().toString());
        phongHoc.setTang(txtTang.getText().toString());
        DBPhongHoc dbPhongHoc = new DBPhongHoc(this);
        dbPhongHoc.Xoa(phongHoc);
    }


    private void setControl() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        txtTang = findViewById(R.id.txtTang);
        txtLoaiPhong = findViewById(R.id.txtLoaiPhong);
        txtMaPhong = findViewById(R.id.txtMaPhong);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}