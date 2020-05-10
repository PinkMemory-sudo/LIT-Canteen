package com.example.hellotest.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hellotest.R;
import com.example.hellotest.entity.MessageArrays;

import java.util.ArrayList;


public class MyGridViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> imgsUrl;


    public MyGridViewAdapter(Context context,ArrayList<String> imgsUrl) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.imgsUrl=imgsUrl;
    }

    @Override
    //item的长度
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView name,price;

    }

    @Override
    //每个item的样式
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.canteen_detail_item, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.iv);
            holder.name = view.findViewById(R.id.food_name_grid);
            holder.price = view.findViewById(R.id.food_price_grid);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        Glide.with(context).load(imgsUrl.get(i)).into(holder.imageView);
        holder.name.setText(MessageArrays.storesDoods.get(i).getName());
        holder.price.setText(""+MessageArrays.storesDoods.get(i).getPrice());

        return view;
    }
}
