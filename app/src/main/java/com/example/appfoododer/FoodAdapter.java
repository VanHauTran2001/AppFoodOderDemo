package com.example.appfoododer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Fooder> fooderList;

    public FoodAdapter(Context context, int layout, List<Fooder> fooderList) {
        this.context = context;
        this.layout = layout;
        this.fooderList = fooderList;
    }

    @Override
    public int getCount() {
        return fooderList.size();
    }
    @Override
    public Object getItem(int position) {
        return fooderList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    private class Viewholder{
        TextView txtnameFooder;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewholder = new Viewholder();
            viewholder.txtnameFooder = (TextView) convertView.findViewById(R.id.txtnameFooder);
            convertView.setTag(viewholder);
        }else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.txtnameFooder.setText(fooderList.get(position).getNameFood());
        return convertView;
    }
}
