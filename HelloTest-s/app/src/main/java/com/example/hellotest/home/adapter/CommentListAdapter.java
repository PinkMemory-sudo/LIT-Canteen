package com.example.hellotest.home.adapter;

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
import com.example.hellotest.utils.Rating;

public class CommentListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public CommentListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    //item的长度
    public int getCount() {
        return Rating.length;
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
        public ImageView img1,img2,img3;
        public TextView commentText;
    }

    @Override
    //每个item的样式
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.food_comment, null);
            holder = new ViewHolder();
            holder.commentText= view.findViewById(R.id.food_coment_text);
            holder.img1 = view.findViewById(R.id.food_comment_img1);
            holder.img2 = view.findViewById(R.id.food_comment_img2);
            holder.img3 = view.findViewById(R.id.food_comment_img3);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.commentText.setText("还行");

         Glide.with(context).load(context.getString(R.string.ip)+"8080/resources/img/rgo.jpg").into(holder.img2);
         Glide.with(context).load(context.getString(R.string.ip)+"8080/resources/img/r1.jpg").into(holder.img1);
         Glide.with(context).load(context.getString(R.string.ip)+"8080/resources/img/r2.jpg").into(holder.img3);

        return view;
    }


}
