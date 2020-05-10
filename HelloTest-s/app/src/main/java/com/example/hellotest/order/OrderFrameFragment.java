package com.example.hellotest.order;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellotest.MyReceiver;
import com.example.hellotest.R;
import com.example.hellotest.base.BaseFragment;
import com.example.hellotest.car.adapter.MyCarListAdapter;
import com.example.hellotest.entity.MessageArrays;
import com.example.hellotest.me.ModifyPwdActivity;
import com.example.hellotest.order.adapter.MyOrderListAdapter;
import com.example.hellotest.utils.CarItem;

import java.util.ArrayList;
import java.util.List;

public class OrderFrameFragment extends BaseFragment {
    private ListView lv;
    private RadioGroup radioGroup;
    private MyOrderListAdapter myOrderListAdapter;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_order, null);
        lv=(ListView)view.findViewById(R.id.order_list);
        MessageArrays.orders=MessageArrays.Orders;
        myOrderListAdapter = new MyOrderListAdapter(mContext);
        lv.setAdapter(myOrderListAdapter);

        MyReceiver myReceiver = new MyReceiver(myOrderListAdapter);
        IntentFilter intentFilter = new IntentFilter("com.pk.finish");
        mContext.registerReceiver(myReceiver,intentFilter);

        radioGroup=view.findViewById(R.id.rg_main);
        return view;
    }
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
        }else {
            myOrderListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void initDate() {
        super.initDate();
        //绑定数据
        initListener();
    }

    private void initListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_ing:
                        MessageArrays.orders = MessageArrays.Orders;
                        initListener();
                        break;
                    case R.id.rb_done:
                        MessageArrays.orders = MessageArrays.doneOrders;
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent = new Intent(mContext, RatingActivity.class);
                                startActivity(intent);
                            }
                        });
                        break;
                }
                    myOrderListAdapter.notifyDataSetChanged();
            }
        });

        initListListener();
    }

    private void initListListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("取消订单").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).setIcon(R.drawable.cancel_order).setMessage("要取消该订单？").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext,"已发送取消订单请求，等待卖家确认",Toast.LENGTH_LONG).show();
                        //模拟完成
                        MessageArrays.doneOrders=MessageArrays.Orders;
                        MessageArrays.Orders=new ArrayList<>();
                        MessageArrays.orders=new ArrayList<>();
                        myOrderListAdapter.notifyDataSetChanged();
                    }
                }).show();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("收藏订单").setIcon(R.drawable.like_alert).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).setMessage("要收藏该订单？").setPositiveButton("是的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext,"已收藏",Toast.LENGTH_LONG).show();
                    }
                }).show();
                return true;
            }
        });
    }
}
