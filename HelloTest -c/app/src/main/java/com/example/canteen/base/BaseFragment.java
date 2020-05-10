package com.example.canteen.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * home car order me的父类
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getActivity() != null) {
//            mContext = getActivity();
//        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context!=null){
            mContext =context;
            Log.e("XXXXXXXXXXXXXXXXXXXXXXXXXXXX",""+context);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    //抽象方法强制子类实现自己的UI
    public abstract View initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    //当子类需要初始化数据或联网请求绑定数据，展示数据等时，可以重写该方法
    public void initDate() {

    }
}
