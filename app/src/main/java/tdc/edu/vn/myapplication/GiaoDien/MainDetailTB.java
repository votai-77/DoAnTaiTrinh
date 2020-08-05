package tdc.edu.vn.myapplication.GiaoDien;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import tdc.edu.vn.myapplication.Adapter.CustomApdapterTB;
import tdc.edu.vn.myapplication.DataBase.DBThietBi;
import tdc.edu.vn.myapplication.Model.ThietBi1;
import tdc.edu.vn.myapplication.R;

public class MainDetailTB extends AppCompatActivity {
    ListView lvDanhSach;
    ArrayList<ThietBi1> data = new ArrayList<>();
    CustomApdapterTB adapter;
    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail_tb);
        ActionBar actionBar1 = getSupportActionBar();
        actionBar1.setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));

        DBThietBi dbThietBi = new DBThietBi(this);
        lvDanhSach = findViewById(R.id.lvDanhSach);
        CustomApdapterTB adapter = new CustomApdapterTB(this, R.layout.listview_item_tb, dbThietBi.LayDL());
        lvDanhSach.setAdapter(adapter);
        setEvent();

    }

    private void setEvent() {
        DBThietBi dbThietBi = new DBThietBi(this);
        data = dbThietBi.LayDL();
        adapter = new CustomApdapterTB(this, R.layout.listview_item_tb, data);
        lvDanhSach.setAdapter(adapter);
        registerForContextMenu(lvDanhSach);
    }

    //function quay xe
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionsearch, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    lvDanhSach.clearTextFilter();
                } else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }
}
