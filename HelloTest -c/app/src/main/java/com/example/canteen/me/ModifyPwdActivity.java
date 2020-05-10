package com.example.canteen.me;

import androidx.appcompat.app.AlertDialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.canteen.R;

public class ModifyPwdActivity extends Activity {
    private Button back;
    private TextView title;
    private EditText oldPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_pwd);
        initView();
        initListener();
    }

    //实例化控件
    private void initView() {
        back = (Button) findViewById(R.id.bar_back);
        title = (TextView) findViewById(R.id.bar_texeview);
        oldPwd = (EditText) findViewById(R.id.me_modify_pwd_old);
        title.setText("修改密码");
    }

    //设置监听
    public void initListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModifyPwdActivity.this.finish();
            }
        });
    }

    public void modifyAlert(View view) {
        String oldPwdStr = oldPwd.getText().toString();
        String pwd = getSharedPreferences("userLogin", MODE_PRIVATE).getString("PWD", null);
        if (oldPwdStr.equals(pwd)) {
//            Toast.makeText(ModifyPwdActivity.this, oldPwdStr, Toast.LENGTH_SHORT).show();
            final View dialogView = LayoutInflater.from(ModifyPwdActivity.this).inflate(R.layout.new_pwd, null);
            Button ok = (Button) dialogView.findViewById(R.id.new_pwd_ok);
            Button cancel = (Button) dialogView.findViewById(R.id.new_pwd_cancel);
            AlertDialog.Builder builder = new AlertDialog.Builder(ModifyPwdActivity.this);
            final AlertDialog dialog = builder.setView(dialogView).setCancelable(false).show();
            //取消按钮
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            //确认按钮
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText pwd1=(EditText)dialogView.findViewById(R.id.me_modify_pwd_new1);
                    EditText pwd2=(EditText)dialogView.findViewById(R.id.me_modify_pwd_new2);
                    final String pwd1Str=pwd1.getText().toString().trim();
                    final String pwd2Str=pwd2.getText().toString().trim();
                    if ((pwd1Str==null|pwd1Str.equals(""))||(pwd2Str==null|pwd2Str.equals(""))){
                        Toast.makeText(ModifyPwdActivity.this, "密码不要空着", Toast.LENGTH_SHORT).show();
                    }else if(pwd1Str.equals(pwd2Str)){
                        Toast.makeText(ModifyPwdActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else {
                        Toast.makeText(ModifyPwdActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {
            Toast.makeText(ModifyPwdActivity.this, "原始密码不正确", Toast.LENGTH_SHORT).show();
        }
    }
}
