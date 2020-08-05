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

import tdc.edu.vn.myapplication.GiaoDien.MainDetailCTSD;
import tdc.edu.vn.myapplication.Model.ChiTietSuDung;
import tdc.edu.vn.myapplication.R;

public class CustomApdapterCTSD extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<ChiTietSuDung> data;
    ArrayList<ChiTietSuDung> data_DS;

    public CustomApdapterCTSD(Context context, int resource, ArrayList<ChiTietSuDung> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<ChiTietSuDung>();
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
        TextView txtMaTB;
        TextView txtNgaySD;
        TextView txtSoLuong;
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
            holder.txtMaTB = view.findViewById(R.id.txtMaTBi);
            holder.txtNgaySD = view.findViewById(R.id.txtNgaySD);
            holder.txtSoLuong = view.findViewById(R.id.txtSoLuong);
            view.setTag(holder);

        }
        else
            holder=(Holder)view.getTag();

        final ChiTietSuDung chiTietSuDung = data.get(position);
        if(chiTietSuDung.getMaPhong().equals("NS"))
            holder.imgHinh.setImageResource(R.drawable.ns);
        if((chiTietSuDung.getMaPhong().equals("PH")))
            holder.imgHinh.setImageResource(R.drawable.ph);
        if((chiTietSuDung.getMaPhong().equals("KT")))
            holder.imgHinh.setImageResource(R.drawable.kt);
        holder.txtMaPhong.setText(chiTietSuDung.getMaPhong());
        holder.txtMaTB.setText(chiTietSuDung.getMaTB());
        holder.txtNgaySD.setText(chiTietSuDung.getNgaySD());
        holder.txtSoLuong.setText(chiTietSuDung.getSoLuong());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainDetailCTSD.class);
                Bundle bundle = new Bundle();
                bundle.putString("maphong",chiTietSuDung.getMaPhong());
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
            for (ChiTietSuDung model : data_DS){
                if (model.getMaTB().toLowerCase(Locale.getDefault())
                        .contains(charText) ){
                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}
