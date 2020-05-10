package com.example.hellotest.me;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hellotest.R;
import com.example.hellotest.me.adapter.MyLikeAdapter;
import com.example.hellotest.order.adapter.MyOrderListAdapter;

public class OrderLikeActivity extends Activity {
private Button back;
private TextView title;
private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_like);
        initView();
        initDate();
        initListener();
        lv.setAdapter(new MyLikeAdapter(OrderLikeActivity.this));
    }

    private void initListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderLikeActivity.this.finish();
            }
        });
    }

    private void initDate() {
        title.setText("订单收藏");
    }

    private void initView() {
        back=(Button)findViewById(R.id.bar_back);
        title=(TextView)findViewById(R.id.bar_texeview);
        lv=(ListView)findViewById(R.id.like_oder);
    }
}
