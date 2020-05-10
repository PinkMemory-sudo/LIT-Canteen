package com.example.canteen.car.adapter;

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
        return MessageArrays.foods.size();
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
        public TextView name, discount,price,like;
    }

    @Override
    //每个item的样式
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.foos_list_item, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.food_list_img);
            holder.name = view.findViewById(R.id.food_list_name);
            holder.discount = view.findViewById(R.id.food_list_discout);
            holder.price = view.findViewById(R.id.food_list_price);
            holder.like=view.findViewById(R.id.food_list_like);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.name.setText(MessageArrays.foods.get(i).getFoodName());
        holder.discount.setText(MessageArrays.foods.get(i).getDiscount());
        holder.like.setText(MessageArrays.foods.get(i).getLike());
        String priceStr=MessageArrays.foods.get(i).getFoodPrice();
        String discountStr=MessageArrays.foods.get(i).getDiscount();
        int price=Integer.parseInt(priceStr)*Integer.parseInt(discountStr);
        priceStr=price/10+"."+price%10;
        holder.price.setText(priceStr);
        Glide.with(context).load(MessageArrays.foods.get(i).getImgUrl()).into(holder.imageView);

        return view;
    }
}
