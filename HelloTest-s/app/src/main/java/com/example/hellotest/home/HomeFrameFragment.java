package com.example.hellotest.home;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hellotest.R;
import com.example.hellotest.base.BaseFragment;
import com.example.hellotest.home.adapter.MyListAdapter;

public class HomeFrameFragment extends BaseFragment {
    private RecyclerView rvHome;
    private ImageView ib_top;
    private TextView tv_search_home;
    private TextView tv_message_home;
    final static String TAG = "HomeFrameFragment";
    private ListView canteenLs;
    private MyListAdapter myListAdapter;


    @Override
    //实例化控件
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
        tv_search_home = (TextView) view.findViewById(R.id.tv_search_home);
        tv_message_home = (TextView) view.findViewById(R.id.tv_message_home);
        canteenLs=(ListView)view.findViewById(R.id.canteen_list);
        myListAdapter = new MyListAdapter(getActivity());
        canteenLs.setAdapter(myListAdapter);
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        initListener();
    }

    //设置监听
    private void initListener() {

        //置顶的监听
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvHome.scrollToPosition(0);
            }
        });

        //搜素的监听
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        //消息的监听
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, MessageCenterActivity.class);
//                mContext.startActivity(intent);
                Toast.makeText(mContext, "消息", Toast.LENGTH_SHORT).show();
            }
        });

        //listview的监听
        canteenLs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                imgsUrl.remove(i);
//                myListAdapter.notifyDataSetChanged();
                Intent intent = new Intent(getActivity(), CanteenDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
