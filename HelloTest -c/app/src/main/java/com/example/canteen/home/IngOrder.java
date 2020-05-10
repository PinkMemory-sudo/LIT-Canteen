package com.example.canteen.home;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import com.example.canteen.R;
import com.example.canteen.base.BaseFragment;
import com.example.canteen.entity.MessageArrays;
import com.example.canteen.home.adapter.MyListAdapter;

public class IngOrder extends BaseFragment {
    private ListView canteenLs;
    private MyListAdapter myListAdapter;
    private int index;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
//        canteenLs = (ListView) view.findViewById(R.id.canteen_list);
//        myListAdapter = new MyListAdapter(getActivity());
//        canteenLs.setAdapter(myListAdapter);
        return view;
    }

    private void initListener() {


        //listview的监听
        canteenLs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("订单操作").setPositiveButton("已出餐", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setNegativeButton("已完成", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.example.canteen.entity.IngOrder order = MessageArrays.ingOrders.remove(index);
                        MessageArrays.doneOrders.add(order);
                        myListAdapter.notifyDataSetChanged();
                    }
                }).show();
            }
        });
    }
}
