package com.example.hellotest.home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellotest.R;
import com.example.hellotest.home.adapter.MyGridViewAdapter;

import java.util.ArrayList;

public class CanteenDetailActivity extends Activity {
private GridView foodList;
private TextView title;
private Button back;
    private ArrayList<String> imgsUrl=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_detail);
        initView();
        initData();
        foodList.setAdapter(new MyGridViewAdapter(CanteenDetailActivity.this,imgsUrl));
    }
    private void initView() {
        foodList=(GridView)findViewById(R.id.canteen_detail);
        title=(TextView)findViewById(R.id.bar_texeview);
        back=(Button)findViewById(R.id.bar_back);
    }

    private void initData() {
        testDate();
        title.setText("兰州拉面");
        initLinstener();
    }

    private void initLinstener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CanteenDetailActivity.this.finish();
            }
        });
        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CanteenDetailActivity.this,""+i,Toast.LENGTH_SHORT).show();
                //将选中的商品的信息传入进去
                Intent intent = new Intent(CanteenDetailActivity.this, FoodDetailActivity.class);
                intent.putExtra("imgUrl",imgsUrl.get(i));
                startActivity(intent);
            }
        });
    }


    public void testDate(){
        imgsUrl.add("http://img1.imgtn.bdimg.com/it/u=3368914569,3766766570&fm=26&gp=0.jpg");
        imgsUrl.add("http://img5.imgtn.bdimg.com/it/u=3422454860,2867719147&fm=26&gp=0.jpg");
        imgsUrl.add("http://img2.imgtn.bdimg.com/it/u=714219170,1166816232&fm=26&gp=0.jpg");
        imgsUrl.add("http://img0.imgtn.bdimg.com/it/u=1638767742,1465158396&fm=26&gp=0.jpg");
        imgsUrl.add("http://img5.imgtn.bdimg.com/it/u=544830405,967622084&fm=26&gp=0.jpg");
        imgsUrl.add("http://img1.imgtn.bdimg.com/it/u=2579043291,862632916&fm=26&gp=0.jpg");
        imgsUrl.add("http://img5.imgtn.bdimg.com/it/u=4246532656,3869045201&fm=26&gp=0.jpg");
        imgsUrl.add("http://img0.imgtn.bdimg.com/it/u=1097459784,3212339104&fm=26&gp=0.jpg");
        imgsUrl.add("http://img0.imgtn.bdimg.com/it/u=1977820651,3250600821&fm=26&gp=0.jpg");
        imgsUrl.add("http://img5.imgtn.bdimg.com/it/u=3109909766,2805187159&fm=26&gp=0.jpg");
    }
}
