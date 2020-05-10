package com.example.hellotest.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.example.hellotest.entity.MessageArrays;
import com.example.hellotest.home.adapter.CommentListAdapter;
import com.example.hellotest.order.adapter.MyOrderListAdapter;

import java.util.ArrayList;

public class MyReceiver extends BroadcastReceiver {

    CommentListAdapter commentListAdapter;
    public MyReceiver(CommentListAdapter commentListAdapter) {
        this.commentListAdapter=commentListAdapter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commentListAdapter.notifyDataSetChanged();
    }
}
