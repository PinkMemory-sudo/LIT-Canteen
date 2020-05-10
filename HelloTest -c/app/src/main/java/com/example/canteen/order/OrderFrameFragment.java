package com.example.canteen.order;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.canteen.R;
import com.example.canteen.base.BaseFragment;

public class OrderFrameFragment extends BaseFragment {
    private ListView lv;
    private Button pause;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_order, null);
        pause=(Button)view.findViewById(R.id.store_pause);
        return view;
    }
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
        }else {
        }
    }

    @Override
    public void initDate() {
        super.initDate();
        //绑定数据
        initListener();
    }

    private void initListener() {
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button pause=(Button)view.findViewById(R.id.store_pause);
                String state=pause.getText().toString();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pause.setText(("已关店".equals(state))?"营业中":"已关店");
            }
        });
    }
}
