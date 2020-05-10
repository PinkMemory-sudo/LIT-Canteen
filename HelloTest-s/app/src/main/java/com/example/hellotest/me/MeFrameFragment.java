package com.example.hellotest.me;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hellotest.R;
import com.example.hellotest.base.BaseFragment;
import com.example.hellotest.utils.CarItem;

import static android.content.Context.MODE_PRIVATE;

public class MeFrameFragment extends BaseFragment {
    private TextView textView;
    private Button logout,modifyPwd,ordercollect;
    private SharedPreferences userMsg;
    private SharedPreferences.Editor userWrite;
    @Override
    //初始化组件
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_me, null);
        logout=(Button) view.findViewById(R.id.me_logout);
        modifyPwd=(Button) view.findViewById(R.id.me_modify_pwd);
        ordercollect=(Button) view.findViewById(R.id.me_order_collect);
//        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
//        ib_top = (ImageView) view.findViewById(R.id.ib_top);
//        tv_search_home = (TextView) view.findViewById(R.id.tv_search_home);
//        tv_message_home = (TextView) view.findViewById(R.id.tv_message_home);
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        //绑定数据
        initLinstener();
    }

    public void initLinstener(){
        userMsg = getActivity().getSharedPreferences("userLogin", MODE_PRIVATE);
        userWrite=userMsg.edit();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userWrite.putString("NAME", null);
                userWrite.putString("PWD", null);
                userWrite.putBoolean("REMEMBER", false);
                userWrite.commit();
                System.exit(0);
            }
        });
        modifyPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ModifyPwdActivity.class);
                startActivity(intent);
            }
        });
        //订单收藏
        ordercollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, OrderLikeActivity.class);
                startActivity(intent);
            }
        });
    }
}
