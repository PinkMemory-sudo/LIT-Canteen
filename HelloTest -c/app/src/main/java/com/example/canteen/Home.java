package com.example.canteen;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.canteen.R;
import com.example.canteen.base.BaseFragment;
import com.example.canteen.car.CarFrameFragment;
import com.example.canteen.home.HomeFrameFragment;
import com.example.canteen.me.MeFrameFragment;
import com.example.canteen.order.OrderFrameFragment;

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
