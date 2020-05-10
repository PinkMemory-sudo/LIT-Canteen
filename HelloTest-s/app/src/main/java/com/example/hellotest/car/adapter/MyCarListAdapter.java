package com.example.hellotest.car.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hellotest.R;
import com.example.hellotest.entity.MessageArrays;
import com.example.hellotest.utils.CarItem;


public class MyCarListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyCarListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    //item的长度
    public int getCount() {
        return MessageArrays.carOrders.size();
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
        public TextView name, time, taste,price;
    }

    @Override
    //每个item的样式
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.car_list_item, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.car_food_list_img);
            holder.name = view.findViewById(R.id.car_food_list_title);
            holder.time = view.findViewById(R.id.car_food_list_time);
            holder.taste = view.findViewById(R.id.car_food_list_taste);
            holder.price = view.findViewById(R.id.car_food_list_price);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.name.setText(MessageArrays.carOrders.get(i).getFoodName());
        holder.time.setText(MessageArrays.carOrders.get(i).getDate());
        holder.taste.setText(MessageArrays.carOrders.get(i).getTaste());
        holder.price.setText(""+MessageArrays.carOrders.get(i).getPrice());
        Glide.with(context).load(MessageArrays.carOrders.get(i).getImgUrl()).into(holder.imageView);

        return view;
    }
}
