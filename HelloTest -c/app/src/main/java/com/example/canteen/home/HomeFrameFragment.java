package com.example.canteen.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canteen.MyReceiver;
import com.example.canteen.R;
import com.example.canteen.base.BaseFragment;
import com.example.canteen.entity.IngOrder;
import com.example.canteen.entity.MessageArrays;
import com.example.canteen.home.adapter.MyListAdapter;

import java.util.List;

public class HomeFrameFragment extends BaseFragment {
    private RecyclerView rvHome;
    private ImageView ib_top;
    private TextView tv_search_home;
    private TextView tv_message_home;
    final static String TAG = "HomeFrameFragment";
    private ListView canteenLs;
    private MyListAdapter myListAdapter;
    private int index, oderArray;
    private RadioGroup radioGroup;

    @Override
    //实例化控件
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        canteenLs = (ListView) view.findViewById(R.id.canteen_list);
        radioGroup = (RadioGroup) view.findViewById(R.id.rg_order);
        MessageArrays.orders = MessageArrays.ingOrders;
        myListAdapter = new MyListAdapter(getActivity());
        canteenLs.setAdapter(myListAdapter);
        MyReceiver myReceiver = new MyReceiver(myListAdapter);
        IntentFilter intentFilter = new IntentFilter("com.pk.hello");
        mContext.registerReceiver(myReceiver,intentFilter);
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        initListener();
    }

    //设置监听
    private void initListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_ing:
                        MessageArrays.orders = MessageArrays.ingOrders;
                        listviewLinstener();
                        break;
                    case R.id.rb_done:
                        MessageArrays.orders = MessageArrays.doneOrders;canteenLs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            index = i;
                            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                            builder.setTitle("订单操作").setNegativeButton("已出餐", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent("com.pk.finish");
                                    mContext.sendBroadcast(intent);
                                }
                            }).show();
                        }
                    });
                        break;
                }
                myListAdapter.notifyDataSetChanged();
            }
        });


        //listview的监听
        listviewLinstener();

    }

    private void listviewLinstener() {
        canteenLs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("订单操作").setNegativeButton("已完成", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        IngOrder order = MessageArrays.ingOrders.remove(index);
                        MessageArrays.doneOrders.add(order);
                        myListAdapter.notifyDataSetChanged();
                    }
                }).show();
            }
        });
    }
}
