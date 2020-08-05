package tdc.edu.vn.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import tdc.edu.vn.myapplication.GiaoDien.MainDetailPH;

import tdc.edu.vn.myapplication.Model.PhongHoc;
import tdc.edu.vn.myapplication.R;

public class CustomApdapterPH extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<PhongHoc> data;
    ArrayList<PhongHoc> data_DS;

    public CustomApdapterPH(Context context, int resource, ArrayList<PhongHoc> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<PhongHoc>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgHinh;
        ImageView imgDetail;
        TextView txtMaPhong;
        TextView txtLoaiPhong;
        TextView txtTang;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        Holder holder = null;
        if(view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinh);
            holder.imgDetail = view.findViewById(R.id.imgDetail);
            holder.txtMaPhong = view.findViewById(R.id.txtMaPhong);
            holder.txtLoaiPhong = view.findViewById(R.id.txtLoaiPhong);
            holder.txtTang = view.findViewById(R.id.txtTang);
            view.setTag(holder);
        }
        else
            holder=(Holder)view.getTag();

        final PhongHoc phongHoc = data.get(position);
        holder.txtMaPhong.setText(phongHoc.getMaPhong());
        holder.txtLoaiPhong.setText(phongHoc.getLoaiPhong());
        holder.txtTang.setText(phongHoc.getTang());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainDetailPH.class);
                Bundle bundle = new Bundle();
                bundle.putString("maph",phongHoc.getMaPhong());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });


        return view;
        /*View view= LayoutInflater.from(context).inflate(resource,null);
        ImageView imgPhong= view.findViewById(R.id.imgHinh);
        TextView txtMaLoai = view.findViewById(R.id.txtMa);
        TextView txtTenLoai = view.findViewById(R.id.txtTen);
        ThietBi thietBi = data.get(position);
        if(thietBi.getPhong().equals("Phòng kế toán"))
            imgPhong.setImageResource(R.drawable.ic_create_black_24dp);
        if(thietBi.getPhong().equals("Phòng máy tính"))
            imgPhong.setImageResource(R.drawable.ic_important_devices_black_24dp);
        else
        {
            imgPhong.setImageResource(R.drawable.ic_person_black_24dp);
        }
        txtMaLoai.setText(thietBi.getMaLoai());
        txtTenLoai.setText(thietBi.getTenLoai());
        return  view;*/
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length()==0){
            data.addAll(data_DS);
        }
        else {
            for (PhongHoc model : data_DS){
                if (model.getLoaiPhong().toLowerCase(Locale.getDefault())
                        .contains(charText) ){
                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}
