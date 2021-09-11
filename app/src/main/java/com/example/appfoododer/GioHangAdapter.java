package com.example.appfoododer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GioHangAdapter extends BaseAdapter {
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
    private class ViewHolder{
        TextView txtMonAn ;
        TextView txtSLoder;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.txtMonAn = (TextView) convertView.findViewById(R.id.txtMonAn);
            viewHolder.txtSLoder = (TextView) convertView.findViewById(R.id.txtSLoder);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtMonAn.setText(gioHangList.get(position).getNameFood());
        viewHolder.txtSLoder.setText("(" +gioHangList.get(position).getSoluong()+")");
        return convertView;
    }
}
