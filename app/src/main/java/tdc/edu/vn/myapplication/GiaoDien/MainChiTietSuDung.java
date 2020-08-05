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
import tdc.edu.vn.myapplication.Adapter.CustomApdapterCTSD;
import tdc.edu.vn.myapplication.DataBase.DBChiTietSuDung;
import tdc.edu.vn.myapplication.DataBase.DBPhongHoc;
import tdc.edu.vn.myapplication.DataBase.DBThietBi;
import tdc.edu.vn.myapplication.Model.ChiTietSuDung;
import tdc.edu.vn.myapplication.R;


public class MainChiTietSuDung extends AppCompatActivity {
    Button btnThem, btnXoa, btnSua;
    EditText txtNgaySD, txtSoLuong;
    Spinner spMaPhong, spMaTBi;
    ListView lvDanhSach;
    int index = -1;
    CustomApdapterCTSD apdapter;
    ArrayList<String> data_MaPhong = new ArrayList<>();
    ArrayAdapter adapter_MaPhong;
    ArrayList<String> data_MaTBi = new ArrayList<>();
    ArrayAdapter adapter_MaTBi;
    ArrayList<ChiTietSuDung> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chi_tiet_su_dung);
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
        //HienThiDL();
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
                ChiTietSuDung chiTietSuDung = data.get(position);
                spMaPhong.setSelection(index);
                spMaTBi.setSelection(index);
                txtNgaySD.setText(chiTietSuDung.getNgaySD());
                txtSoLuong.setText(chiTietSuDung.getSoLuong());
                index = position;

            }
        });

    }
    private void LoadSpinner() {
        DBPhongHoc dbPhongHoc = new DBPhongHoc(this);
        data_MaPhong = dbPhongHoc.LayMaPhong();
        adapter_MaPhong = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,data_MaPhong);
        spMaPhong.setAdapter(adapter_MaPhong);
        DBThietBi dbThietBi = new DBThietBi(this);
        data_MaTBi = dbThietBi.LayMaTBi();
        adapter_MaTBi = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,data_MaTBi);
        spMaTBi.setAdapter(adapter_MaTBi);

    }

    private void HienThiDL() {
        DBChiTietSuDung dbChiTietSuDung = new DBChiTietSuDung(this);
        data = dbChiTietSuDung.LayDL();
        apdapter = new CustomApdapterCTSD(MainChiTietSuDung.this, R.layout.listview_item_ctsd, data);
        lvDanhSach.setAdapter(apdapter);
    }

    private void ThemDL() {
        ChiTietSuDung chiTietSuDung = new ChiTietSuDung();
        chiTietSuDung.setMaPhong(spMaPhong.getSelectedItem().toString());
        chiTietSuDung.setMaTB(spMaTBi.getSelectedItem().toString());
        chiTietSuDung.setNgaySD(txtNgaySD.getText().toString());
        chiTietSuDung.setSoLuong(txtSoLuong.getText().toString());
        DBChiTietSuDung dbChiTietSuDung = new DBChiTietSuDung(this);
        dbChiTietSuDung.Them(chiTietSuDung);
    }
    private void SuaDL() {
        ChiTietSuDung chiTietSuDung = new ChiTietSuDung();
        chiTietSuDung.setMaPhong(spMaPhong.getSelectedItem().toString());
        chiTietSuDung.setMaTB(spMaTBi.getSelectedItem().toString());
        chiTietSuDung.setNgaySD(txtNgaySD.getText().toString());
        chiTietSuDung.setSoLuong(txtSoLuong.getText().toString());
        DBChiTietSuDung dbChiTietSuDung = new DBChiTietSuDung(this);
        dbChiTietSuDung.Sua(chiTietSuDung);
    }
    private void XoaDL() {
        ChiTietSuDung chiTietSuDung = new ChiTietSuDung();
        chiTietSuDung.setMaPhong(spMaPhong.getSelectedItem().toString());
        chiTietSuDung.setMaTB(spMaTBi.getSelectedItem().toString());
        chiTietSuDung.setNgaySD(txtNgaySD.getText().toString());
        chiTietSuDung.setSoLuong(txtSoLuong.getText().toString());
        DBChiTietSuDung dbChiTietSuDung = new DBChiTietSuDung(this);
        dbChiTietSuDung.Xoa(chiTietSuDung);
    }
    private void setControl() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        txtNgaySD = findViewById(R.id.txtNgaySD);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        spMaPhong = findViewById(R.id.spMaPhong);
        spMaTBi = findViewById(R.id.spMaTBi);
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

