package com.example.canteen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.example.canteen.entity.IngOrder;
import com.example.canteen.entity.MessageArrays;
import com.example.canteen.home.adapter.MyListAdapter;

public class MyReceiver extends BroadcastReceiver {
    private MyListAdapter myListAdapter;

    public MyReceiver(MyListAdapter myListAdapter) {
        this.myListAdapter=myListAdapter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name,date,taste;
        name=intent.getStringExtra("name");
        date=intent.getStringExtra("date");
        taste=intent.getStringExtra("taste");
        Log.e("bord","hello"+name+date+taste);
        MessageArrays.ingOrders.add(new IngOrder(date,name,taste));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("新订单").setMessage("您有一个新订单:\n"+"\n\t\t"+name+"-"+taste).setIcon(R.drawable.like).setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
        myListAdapter.notifyDataSetChanged();
    }
}
