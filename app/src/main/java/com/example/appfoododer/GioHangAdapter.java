package com.example.appfoododer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.example.appfoododer.databinding.ActivityGioHangBinding;

import java.util.List;

public class GioHangAdapter extends BaseAdapter {
    ActivityGioHangBinding binding;
    Context context;
    int layout;
    List<Fooder> gioHangList;

    public GioHangAdapter(Context context, int layout, List<Fooder> gioHangList) {
        this.context = context;
        this.layout = layout;
        this.gioHangList = gioHangList;
    }

    @Override
    public int getCount() {
        return gioHangList.size();
    }
    @Override
    public Object getItem(int position) {
        return gioHangList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


             LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             binding = DataBindingUtil.inflate(inflater,layout,parent,false);
             binding.txtMonAn.setText(gioHangList.get(position).getNameFood());
             binding.txtSLoder.setText("(" +gioHangList.get(position).getSoluong()+")");
             return binding.getRoot();
    }
}
