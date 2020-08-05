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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;



import tdc.edu.vn.myapplication.Adapter.CustomApdapterTB;
import tdc.edu.vn.myapplication.DataBase.DBLoaiThietBi;
import tdc.edu.vn.myapplication.DataBase.DBThietBi;
import tdc.edu.vn.myapplication.Model.ThietBi1;
import tdc.edu.vn.myapplication.R;


public class MainTB extends AppCompatActivity {
    Button btnThem, btnXoa, btnSua;
    EditText txtMaTBi, txtTenTBi, txtXuatXu;
    Spinner spMaLoai;
    ListView lvDanhSach;

    int index = -1;

    CustomApdapterTB apdapter;
    ArrayList<String> data_MaLoai = new ArrayList<>();
    ArrayAdapter adapter_MaLoai;

    ArrayList<ThietBi1> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_t_b);

        setControl();
        setEvent();
        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
    }
    private void setEvent() {
        LoadSpinner();
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
                ThietBi1 thietBi1 = data.get(position);
                txtMaTBi.setText(thietBi1.getMaTB());
                txtTenTBi.setText(thietBi1.getTenTB());
                txtXuatXu.setText(thietBi1.getXuatXu());
                spMaLoai.setSelection(index);
                index = position;

            }
        });

    }
    private void LoadSpinner() {
        DBLoaiThietBi dbLoaiThietBi = new DBLoaiThietBi(this);
        data_MaLoai = dbLoaiThietBi.LayMaLoai();
        adapter_MaLoai = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,data_MaLoai);
        spMaLoai.setAdapter(adapter_MaLoai);

    }

    private void HienThiDL() {
        DBThietBi dbThietBi = new DBThietBi(this);
        data = dbThietBi.LayDL();
        apdapter = new CustomApdapterTB(MainTB.this, R.layout.listview_item_tb, data);
        lvDanhSach.setAdapter(apdapter);
    }

    private void ThemDL() {
        ThietBi1 thietBi1 = new ThietBi1();
        thietBi1.setMaTB(txtMaTBi.getText().toString());
        thietBi1.setTenTB(txtTenTBi.getText().toString());
        thietBi1.setXuatXu(txtXuatXu.getText().toString());
        thietBi1.setMaLoai(spMaLoai.getSelectedItem().toString());
        DBThietBi dbThietBi = new DBThietBi(this);
        dbThietBi.Them(thietBi1);
    }
    private void SuaDL() {
        ThietBi1 thietBi1 = new ThietBi1();
        thietBi1.setMaTB(txtMaTBi.getText().toString());
        thietBi1.setTenTB(txtTenTBi.getText().toString());
        thietBi1.setXuatXu(txtXuatXu.getText().toString());
        thietBi1.setMaLoai(spMaLoai.getSelectedItem().toString());

        DBThietBi dbThietBi = new DBThietBi(this);
        dbThietBi.Sua(thietBi1);
    }
    private void XoaDL() {
        ThietBi1 thietBi1 = new ThietBi1();
        thietBi1.setMaTB(txtMaTBi.getText().toString());
        thietBi1.setTenTB(txtTenTBi.getText().toString());
        thietBi1.setXuatXu(txtXuatXu.getText().toString());
        thietBi1.setMaLoai(spMaLoai.getSelectedItem().toString());
        DBThietBi dbThietBi = new DBThietBi(this);
        dbThietBi.Xoa(thietBi1);
    }


    private void setControl() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        txtMaTBi = findViewById(R.id.txtMaTB);
        txtTenTBi = findViewById(R.id.txtTenTB);
        txtXuatXu = findViewById(R.id.txtXuatXu);
        spMaLoai = findViewById(R.id.spMaLoai);
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