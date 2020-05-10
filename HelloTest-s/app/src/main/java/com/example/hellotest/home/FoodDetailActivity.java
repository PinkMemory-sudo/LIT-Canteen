package com.example.hellotest.home;

import androidx.appcompat.app.AlertDialog;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.hellotest.R;
import com.example.hellotest.entity.MessageArrays;
import com.example.hellotest.entity.CarOrder;
import com.example.hellotest.home.adapter.CommentListAdapter;
import com.example.hellotest.utils.CarItem;
import com.example.hellotest.utils.MyReceiver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FoodDetailActivity extends Activity {
    private ImageView img0, img1, img2;
    private ArrayList<String> imgsUrl = new ArrayList<>();
    private RadioGroup radioGroup;
    private String taste;
    private ListView commentLv;
    private CommentListAdapter commentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        commentListAdapter=new CommentListAdapter(FoodDetailActivity.this);
        MyReceiver myReceiver = new MyReceiver(commentListAdapter);
        IntentFilter intentFilter = new IntentFilter("RATING");
        this.registerReceiver(myReceiver,intentFilter);
        initVieew();
    }

    private void initVieew() {
        img0 = (ImageView) findViewById(R.id.food0_img);
        img1 = (ImageView) findViewById(R.id.food1_img);
        img2 = (ImageView) findViewById(R.id.food2_img);
        commentLv=(ListView)findViewById(R.id.food_comment);
        commentLv.setAdapter(commentListAdapter);
        initData();
        Glide.with(FoodDetailActivity.this).load(imgsUrl.get(0)).into(img0);
        Glide.with(FoodDetailActivity.this).load(imgsUrl.get(1)).into(img1);
        Glide.with(FoodDetailActivity.this).load(imgsUrl.get(2)).into(img2);
    }

    private void initData() {
        imgsUrl.add("http://img5.imgtn.bdimg.com/it/u=3422454860,2867719147&fm=26&gp=0.jpg");
        imgsUrl.add("http://img1.imgtn.bdimg.com/it/u=3368914569,3766766570&fm=26&gp=0.jpg");
        imgsUrl.add("http://img2.imgtn.bdimg.com/it/u=714219170,1166816232&fm=26&gp=0.jpg");
    }

    public void addfood(View view) {
        final View dialogView = LayoutInflater.from(FoodDetailActivity.this).inflate(R.layout.add_food, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(FoodDetailActivity.this);
        Button ok, cancel;
        ok = (Button) dialogView.findViewById(R.id.new_addfood_ok);
        cancel = (Button) dialogView.findViewById(R.id.new_addfood_cancel);
        radioGroup=(RadioGroup)dialogView.findViewById(R.id.food_taste);
        final AlertDialog dialog = builder.setView(dialogView).setCancelable(false).show();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.food_test_0:
                        taste = "微辣";
                        break;
                    case R.id.food_test_1:
                        taste = "一般";
                        break;
                    case R.id.food_test_2:
                        taste = "麻辣";
                        break;
                }
                Log.e("aaa",""+i);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String imgUrl = intent.getStringExtra("imgUrl");
                CarOrder order = new CarOrder("兰州拉面", 13, imgUrl, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), taste);
                Log.e("asd",order.toString());
                MessageArrays.carOrders.add(order);
                CarItem.imgUrls.add(imgUrl);
                CarItem.count++;
                Toast.makeText(FoodDetailActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public void prefood(View view) {
        addfood(view);
    }


}
