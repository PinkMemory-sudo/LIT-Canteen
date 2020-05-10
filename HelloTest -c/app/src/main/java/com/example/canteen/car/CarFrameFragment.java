package com.example.canteen.car;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.canteen.R;
import com.example.canteen.base.BaseFragment;
import com.example.canteen.car.adapter.MyCarListAdapter;
import com.example.canteen.entity.Foods;
import com.example.canteen.entity.MessageArrays;
import com.example.canteen.me.ModifyPwdActivity;
import com.example.canteen.utils.CarItem;

import java.util.ArrayList;

public class CarFrameFragment extends BaseFragment {
    private ListView lv;
    private MyCarListAdapter myCarListAdapter;
    private Button addFood, ok, cancel, addPhoto;
    ;
    private int index;
    private NumberPicker discount;
    private EditText name, price;
    private AlertDialog.Builder builder;
    private View dialogView;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.car, null);
        lv = (ListView) view.findViewById(R.id.car_food_list);
        addFood = (Button) view.findViewById(R.id.add_food);
        myCarListAdapter = new MyCarListAdapter(mContext);
        lv.setAdapter(myCarListAdapter);

        //修改商品组件初始化

        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        //绑定数据
//        sum.setText(""+13*CarItem.count+".00");
        Linstener();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
        } else {
//            sum.setText("" + 13 * CarItem.count + ".00");
        }
    }

    private void Linstener() {
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                builder.setTitle("删除该商品？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MessageArrays.foods.remove(index);
                        myCarListAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                dialogView = LayoutInflater.from(mContext).inflate(R.layout.modify_food, null);

                discount = (NumberPicker) dialogView.findViewById(R.id.modify_food_discount);
                discount.setMaxValue(10);
                discount.setMinValue(1);


                name = (EditText) dialogView.findViewById(R.id.modify_food_name);
                price = (EditText) dialogView.findViewById(R.id.modify_food_price);
                discount = (NumberPicker) dialogView.findViewById(R.id.modify_food_discount);
                name.setText(MessageArrays.foods.get(index).getFoodName());
                price.setText(MessageArrays.foods.get(index).getFoodPrice());
                discount.setValue(Integer.parseInt(MessageArrays.foods.get(index).getDiscount()));

                ok = (Button) dialogView.findViewById(R.id.modify_food_ok);
                cancel = (Button) dialogView.findViewById(R.id.modify_food_cancel);
                addPhoto = (Button) dialogView.findViewById(R.id.modify_food_photo);
                builder = new AlertDialog.Builder(mContext);
                final AlertDialog dialog = builder.setView(dialogView).setCancelable(false).show();
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        name = (EditText) dialogView.findViewById(R.id.modify_food_name);
                        price = (EditText) dialogView.findViewById(R.id.modify_food_price);
                        discount = (NumberPicker) dialogView.findViewById(R.id.modify_food_discount);
                        String foodName = name.getText().toString().trim();
                        String foodPrice = price.getText().toString().trim();
                        String like=MessageArrays.foods.get(index).getLike();
                        int foodDiscount = discount.getValue();
                        String imgUrl = MessageArrays.foods.get(index).getImgUrl();
                        Foods food = new Foods(imgUrl, foodName, foodPrice, "" + foodDiscount,like);
                        MessageArrays.foods.set(index,food);
                        myCarListAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

            }
        });

        //添加商品
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View addFoodView = LayoutInflater.from(mContext).inflate(R.layout.add_myfood, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                discount = (NumberPicker) addFoodView.findViewById(R.id.add_food_discount);
                discount.setMaxValue(10);
                discount.setMinValue(1);
                builder.setView(addFoodView).show();

            }
        });
    }

}
