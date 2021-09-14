package com.example.appfoododer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.example.appfoododer.databinding.LayoutFoodBinding;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    LayoutFoodBinding binding;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            binding = DataBindingUtil.inflate(inflater,layout,parent,false);
            binding.txtnameFooder.setText(fooderList.get(position).getNameFood());
        return binding.getRoot();
    }
}
