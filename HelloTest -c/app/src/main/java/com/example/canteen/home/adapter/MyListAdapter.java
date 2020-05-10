package com.example.canteen.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.canteen.R;
import com.example.canteen.entity.MessageArrays;

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
        public ImageView img;
        public TextView id,name,taste;
    }

    @Override
    //每个item的样式
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_canteen_order, null);
            holder = new ViewHolder();
            holder.img = view.findViewById(R.id.canteen_list_img);
            holder.id = view.findViewById(R.id.order_id);
            holder.name = view.findViewById(R.id.order_food_name);
            holder.taste = view.findViewById(R.id.order_taste);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.id.setText(MessageArrays.orders.get(i).getId());
        holder.name.setText(""+MessageArrays.orders.get(i).getFoodName());
        holder.taste.setText(MessageArrays.orders.get(i).getTaste());
//        Glide.with(context).load(MessageArrays.canteens.get(i).getImgUrl()).into(holder.img);

        return view;
    }


}
