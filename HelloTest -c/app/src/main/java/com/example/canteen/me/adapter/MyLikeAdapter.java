package com.example.canteen.me.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.canteen.R;
import com.example.canteen.utils.CarItem;


public class MyLikeAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyLikeAdapter(Context context) {
        if (context!=null){
            Log.i("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",""+context);
            Log.i("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",""+CarItem.ordercount);
        }
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    //item的长度
    public int getCount() {
        return CarItem.ordercount;
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
            view = layoutInflater.inflate(R.layout.foos_list_item, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.car_food_list_img);
            holder.name = view.findViewById(R.id.car_food_list_title);
            holder.time = view.findViewById(R.id.car_food_list_time);
            holder.taste = view.findViewById(R.id.car_food_list_taste);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
//        holder.name.setText("好好吃面");
//        holder.time.setText("2020-01-2");
//        holder.taste.setText("java中 Class.forName(\"XXXX\")...;与XXXX.class...有什么区别?");
        Glide.with(context).load(CarItem.orderimgUrls).into(holder.imageView);
//        Glide.with(context).load("http://img5.imgtn.bdimg.com/it/u=3422454860,2867719147&fm=26&gp=0.jpg");

        return view;
    }
}
