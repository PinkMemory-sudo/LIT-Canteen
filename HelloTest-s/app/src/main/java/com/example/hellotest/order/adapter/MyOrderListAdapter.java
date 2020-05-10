package com.example.hellotest.order.adapter;

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


public class MyOrderListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyOrderListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    //item的长度
    public int getCount() {
        return MessageArrays.orders.size();
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
        public TextView name, time, taste;
    }

    @Override
    //每个item的样式
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.order_item, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.order_img);
            holder.name = view.findViewById(R.id.order_title);
            holder.time = view.findViewById(R.id.order_time);
            holder.taste = view.findViewById(R.id.order_taste);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.name.setText(MessageArrays.orders.get(i).getFoodName());
        holder.time.setText(MessageArrays.orders.get(i).getDate());
        holder.taste.setText(MessageArrays.orders.get(i).getTaste());
        Glide.with(context).load(MessageArrays.orders.get(i).getImgUrl()).into(holder.imageView);

        return view;
    }
}
