package com.example.canteen.boot;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.canteen.Home;
import com.example.canteen.MainActivity;
import com.example.canteen.R;
import com.example.canteen.entity.Foods;
import com.example.canteen.entity.IngOrder;
import com.example.canteen.entity.MessageArrays;

public class BootActivity extends Activity {
    private SharedPreferences userLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot);
        testDate();
        userLogin = getSharedPreferences("userLogin", MODE_PRIVATE);
        final boolean savedRemember = userLogin.getBoolean("REMEMBER", false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (savedRemember){
                    Intent intent = new Intent(BootActivity.this, Home.class);
                    startActivity(intent);
                    BootActivity.this.finish();
                }else {
                Intent intent = new Intent(BootActivity.this, MainActivity.class);
                startActivity(intent);
                    BootActivity.this.finish();}
            }
        },1000);
    }

    private void testDate() {
//        MessageArrays.ingOrders.add(new IngOrder("20200101001","兰州拉面","一般"));
        MessageArrays.foods.add(new Foods("http://img1.imgtn.bdimg.com/it/u=3368914569,3766766570&fm=26&gp=0.jpg","清汤拉面","13","10","5.0"));
        MessageArrays.foods.add(new Foods("http://img5.imgtn.bdimg.com/it/u=3422454860,2867719147&fm=26&gp=0.jpg","牛肉拉面","13","10","4.9"));
        MessageArrays.foods.add(new Foods("http://img2.imgtn.bdimg.com/it/u=714219170,1166816232&fm=26&gp=0.jpg","羊肉拉面","13","10","4.9"));
        MessageArrays.foods.add(new Foods("http://img0.imgtn.bdimg.com/it/u=1638767742,1465158396&fm=26&gp=0.jpg","鸡肉拉面","13","10","4.9"));
        MessageArrays.foods.add(new Foods("http://img5.imgtn.bdimg.com/it/u=544830405,967622084&fm=26&gp=0.jpg","鱼肉拉面","13","10","4.9"));
        MessageArrays.foods.add(new Foods("http://img1.imgtn.bdimg.com/it/u=2579043291,862632916&fm=26&gp=0.jpg","蔬菜拉面","13","10","4.9"));
        MessageArrays.foods.add(new Foods("http://img5.imgtn.bdimg.com/it/u=4246532656,3869045201&fm=26&gp=0.jpg","黑椒拉面","13","10","4.9"));
        MessageArrays.foods.add(new Foods("http://img0.imgtn.bdimg.com/it/u=1097459784,3212339104&fm=26&gp=0.jpg","藤椒拉面","13","10","4.9"));
        MessageArrays.foods.add(new Foods("http://img5.imgtn.bdimg.com/it/u=2651263262,2661175045&fm=26&gp=0.jpg","红烧牛肉拉面","13","10","3.9"));
        MessageArrays.foods.add(new Foods("http://img1.imgtn.bdimg.com/it/u=3553405372,1146513193&fm=26&gp=0.jpg","红烧牛肉泡面","13","10","2.9"));
    }
}
