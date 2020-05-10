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

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    //item的长度
    public int getCount() {
        return MessageArrays.canteens.size();
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
        public ImageView img;
        public TextView name, level, desc;
    }

    @Override
    //每个item的样式
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_canteen, null);
            holder = new ViewHolder();
            holder.img = view.findViewById(R.id.canteen_list_img);
            holder.name = view.findViewById(R.id.item_canteen_name);
            holder.level = view.findViewById(R.id.item_canteen_level);
            holder.desc = view.findViewById(R.id.item_canteen_desc);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.name.setText(MessageArrays.canteens.get(i).getTitleName());
        holder.level.setText(""+MessageArrays.canteens.get(i).getLevel());
        holder.desc.setText(MessageArrays.canteens.get(i).getDesc());
        Glide.with(context).load(MessageArrays.canteens.get(i).getImgUrl()).into(holder.img);

        return view;
    }


}
