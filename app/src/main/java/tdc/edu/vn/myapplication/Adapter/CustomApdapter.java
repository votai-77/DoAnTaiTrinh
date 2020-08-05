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

import tdc.edu.vn.myapplication.GiaoDien.MainDetail;
import tdc.edu.vn.myapplication.Model.ThietBi;
import tdc.edu.vn.myapplication.R;

public class CustomApdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<ThietBi> data;
    ArrayList<ThietBi> data_DS;

    public CustomApdapter(Context context, int resource, ArrayList<ThietBi> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<ThietBi>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgHinh;
        ImageView imgDetail;
        TextView tvHoTen;
        TextView tvMa;
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
            holder.tvHoTen = view.findViewById(R.id.tvTen);
            holder.tvMa = view.findViewById(R.id.tvMa);
            view.setTag(holder);
        }
        else
            holder=(Holder)view.getTag();
        final ThietBi thietBi = data.get(position);
        holder.tvHoTen.setText(thietBi.getTenLoai());
        holder.tvMa.setText(thietBi.getMaLoai());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainDetail.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma",thietBi.getMaLoai());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length()==0){
            data.addAll(data_DS);
        }
        else {
            for (ThietBi model : data_DS){
                if (model.getTenLoai().toLowerCase(Locale.getDefault())
                        .contains(charText) ){
                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
