package com.example.hellotest.car;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellotest.R;
import com.example.hellotest.base.BaseFragment;
import com.example.hellotest.car.adapter.MyCarListAdapter;
import com.example.hellotest.entity.CarOrder;
import com.example.hellotest.entity.MessageArrays;
import com.example.hellotest.home.FoodDetailActivity;
import com.example.hellotest.utils.CarItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CarFrameFragment extends BaseFragment {
    private TextView sum;
    private ListView lv;
    private Button ok;
    private MyCarListAdapter myCarListAdapter;
    private RadioGroup radioGroup;
    private String taste;
    private int index;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.car, null);
        sum = (TextView) view.findViewById(R.id.car_sum);
        lv = (ListView) view.findViewById(R.id.car_food_list);
        myCarListAdapter = new MyCarListAdapter(mContext);
        lv.setAdapter(myCarListAdapter);
        ok = (Button) view.findViewById(R.id.car_ok);
        sum.setText("" + 13 * CarItem.count + ".00");
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        //绑定数据
//        sum.setText(""+13*CarItem.count+".00");
        Linstener();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
        }else {
            sum.setText("" + 13 * CarItem.count + ".00");
        }
    }

    private void Linstener() {
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int imgInt = i;
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("删除商品").setIcon(R.drawable.delete_alert)
                        .setMessage("确定删除该商品？").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CarItem.imgUrls.remove(imgInt);
                        CarItem.count--;
                        sum.setText("" + 13 * CarItem.count + ".00");
                        myCarListAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setCancelable(false).show();
                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {

                final View dialogView = LayoutInflater.from(mContext).inflate(R.layout.car_modify_order, null);
                final androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(mContext);
                Button ok, cancel;
                ok = (Button) dialogView.findViewById(R.id.modify_order_ok);
                cancel = (Button) dialogView.findViewById(R.id.modify_order_cancel);
                radioGroup=(RadioGroup)dialogView.findViewById(R.id.rg_modify_order);
                final androidx.appcompat.app.AlertDialog dialog = builder.setView(dialogView).setCancelable(false).show();

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.modify_test_0:
                                taste = "微辣";
                                break;
                            case R.id.modify_test_1:
                                taste = "一般";
                                break;
                            case R.id.modify_test_2:
                                taste = "麻辣";
                                break;
                        }
                        Log.e("ass",taste);
                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MessageArrays.carOrders.get(index).setTaste(taste);
                        myCarListAdapter.notifyDataSetChanged();
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
        });

        //结算
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date,name,taste;
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                name =MessageArrays.carOrders.get(index).getFoodName();
                taste=MessageArrays.carOrders.get(index).getTaste();
                CarItem.ordercount++;
                Toast.makeText(mContext,""+CarItem.ordercount,Toast.LENGTH_SHORT).show();
                CarItem.count=0;
                CarItem.orderimgUrls=CarItem.imgUrls.get(0);
                CarItem.imgUrls = new ArrayList<>();
                MessageArrays.Orders=MessageArrays.carOrders;
                Log.e("ass",MessageArrays.Orders.get(0).toString());
                MessageArrays.carOrders=new ArrayList<>();
                sum.setText("00.00");
                myCarListAdapter.notifyDataSetChanged();

                Intent intent = new Intent("com.pk.hello");
                intent.putExtra("date",date);
                intent.putExtra("name",name);
                intent.putExtra("taste",taste);
                mContext.sendBroadcast(intent);
            }
        });
    }

}
