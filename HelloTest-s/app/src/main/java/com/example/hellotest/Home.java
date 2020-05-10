package com.example.hellotest;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.example.hellotest.R;
import com.example.hellotest.base.BaseFragment;
import com.example.hellotest.car.CarFrameFragment;
import com.example.hellotest.home.HomeFrameFragment;
import com.example.hellotest.me.MeFrameFragment;
import com.example.hellotest.order.OrderFrameFragment;
import com.example.hellotest.utils.CarItem;

import java.util.ArrayList;
import java.util.List;

public class Home extends FragmentActivity {
    private RadioGroup radioGroup;
    private List<BaseFragment> mBaseFragment;
    //底部被选中的位置
    private int position;
    //当前的Fragment
    private Fragment mContent;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup监听
        setListener();
        //不被软键盘顶
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_car:
                        position = 1;
                        break;
                    case R.id.rb_order:
                        position = 2;
                        break;
                    case R.id.rb_me:
                        position = 3;
                        break;
                    default:
                        position = 0;
                }
                //根据位置替换帧布局中的view
                BaseFragment to = getFragment();
                switchFrgment(mContent,to);
            }
        });
        radioGroup.check(R.id.rb_home);
    }

//    private void switchFrgment(BaseFragment fragment) {
//        //得到帧布局管理器
//        FragmentManager fm = getSupportFragmentManager();
//        //开启事务
//        FragmentTransaction transaction = fm.beginTransaction();
//        //替换 使用replace时会重新初始化Fragment，不适合频繁的进行来回切换
//        transaction.replace(R.id.fl_content, fragment);
//        //提交事务
//        transaction.commit();
//    }

    private void switchFrgment(Fragment from, Fragment to) {
        if (from != to) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            mContent=to;
            if (!to.isAdded()){
                //隐藏当前
                if(from!=null){
                    ft.hide(from);
                }
                //添加to到帧布局
                if (to!=null){
                    ft.add(R.id.fl_content,to);
                }
                ft.commit();
            }else {//to被添加过
                if(from!=null){
                    ft.hide(from);
                }
               ft.show(to).commit();
            }
        }

    }

    //根据位置得到对应的帧布局
    private BaseFragment getFragment() {
        return mBaseFragment.get(position);
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new HomeFrameFragment());
        mBaseFragment.add(new CarFrameFragment());
        mBaseFragment.add(new OrderFrameFragment());
        mBaseFragment.add(new MeFrameFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_home);
        radioGroup = (RadioGroup) findViewById(R.id.rg_main);

    }
}
