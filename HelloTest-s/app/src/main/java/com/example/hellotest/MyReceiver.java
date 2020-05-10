package com.example.hellotest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.example.hellotest.entity.MessageArrays;
import com.example.hellotest.order.adapter.MyOrderListAdapter;

import java.util.ArrayList;

public class MyReceiver extends BroadcastReceiver {
    MyOrderListAdapter myOrderListAdapter;
    public MyReceiver(MyOrderListAdapter myOrderListAdapter) {
        this.myOrderListAdapter=myOrderListAdapter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MessageArrays.doneOrders=MessageArrays.Orders;
        MessageArrays.Orders=new ArrayList<>();
        MessageArrays.orders=new ArrayList<>();
//        throw new UnsupportedOperationException("Not yet implemented");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("订单完成").setMessage("您有订单已完成").setPositiveButton("是的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).show();
        myOrderListAdapter.notifyDataSetChanged();
    }
}
