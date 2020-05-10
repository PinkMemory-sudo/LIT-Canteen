package com.example.hellotest.boot;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.hellotest.Home;
import com.example.hellotest.MainActivity;
import com.example.hellotest.R;
import com.example.hellotest.entity.Canteen;
import com.example.hellotest.entity.MessageArrays;
import com.example.hellotest.home.FoodDetailActivity;
import com.example.hellotest.order.RatingActivity;
import com.example.hellotest.utils.StoresDood;

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
//                    Intent intent = new Intent(BootActivity.this, RatingActivity.class);
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
        MessageArrays.canteens.add(new Canteen("兰州拉面",4.8,"风味独特，驰名中外","http://img1.imgtn.bdimg.com/it/u=3368914569,3766766570&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("重庆小面",4.8,"好吃又正宗","http://img5.imgtn.bdimg.com/it/u=3422454860,2867719147&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("河南烩面",4.7,"驱寒御寒，营养丰富 ","http://img2.imgtn.bdimg.com/it/u=714219170,1166816232&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("陕西刀削面",4.6,"卤汁酥香，香辣扑鼻","http://img0.imgtn.bdimg.com/it/u=1638767742,1465158396&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("老北京炸酱面",4.6,"炸酱拌面条","http://img5.imgtn.bdimg.com/it/u=544830405,967622084&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("兰州拉面",4.4,"好吃又正宗","http://img1.imgtn.bdimg.com/it/u=2579043291,862632916&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("兰州拉面",4.8,"好吃又正宗","http://img5.imgtn.bdimg.com/it/u=4246532656,3869045201&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("兰州拉面",4.4,"好吃又正宗","http://img0.imgtn.bdimg.com/it/u=1097459784,3212339104&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("兰州拉面",4.7,"好吃又正宗","http://img0.imgtn.bdimg.com/it/u=1977820651,3250600821&fm=26&gp=0.jpg"));
        MessageArrays.canteens.add(new Canteen("兰州拉面",4.4,"好吃又正宗","http://img5.imgtn.bdimg.com/it/u=3109909766,2805187159&fm=26&gp=0.jpg"));
        MessageArrays.storesDoods.add(new StoresDood("土豆盖浇面",8));
        MessageArrays.storesDoods.add(new StoresDood("兰州拉面",13));
        MessageArrays.storesDoods.add(new StoresDood("炒拉条",10));
        MessageArrays.storesDoods.add(new StoresDood("蛋炒饭",9));
        MessageArrays.storesDoods.add(new StoresDood("番茄鸡蛋面",9));
        MessageArrays.storesDoods.add(new StoresDood("红烧牛肉面",9));
        MessageArrays.storesDoods.add(new StoresDood("红烧牛肉面",9));
        MessageArrays.storesDoods.add(new StoresDood("红烧牛肉面",9));
        MessageArrays.storesDoods.add(new StoresDood("红烧牛肉面",9));
        MessageArrays.storesDoods.add(new StoresDood("红烧牛肉面",9));
    }
}
