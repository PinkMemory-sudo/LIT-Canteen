package com.example.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEdit;
    private EditText userPwdEdit;
    private CheckBox remberCheckBox;
    private SharedPreferences userLogin;
    private SharedPreferences.Editor userWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //注册加下滑线
        TextView regist = (TextView) findViewById(R.id.l_regist);
        regist.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        //获得SharedPreferences
        userLogin = getSharedPreferences("userLogin", MODE_PRIVATE);

        //获得组件
        userNameEdit = (EditText) findViewById(R.id.l_name);
        userPwdEdit = (EditText) findViewById(R.id.l_pwd);
        remberCheckBox = (CheckBox) findViewById(R.id.l_rember);

        //是否记住密码
        userWrite = userLogin.edit();
        boolean savedRemember = userLogin.getBoolean("REMEMBER", false);
        if (savedRemember) {
            remberCheckBox.setChecked(savedRemember);
            userNameEdit.setText(userLogin.getString("NAME", null));
            userPwdEdit.setText(userLogin.getString("PWD", null));
        }
    }

    public void login(View view) {
        String name = userNameEdit.getText().toString();
        String pwd = userPwdEdit.getText().toString();

        if (remberCheckBox.isChecked()) {
            userWrite.putString("NAME", name);
            userWrite.putString("PWD", pwd);
            userWrite.putBoolean("REMEMBER", true);
            userWrite.commit();
        } else {
            userWrite.putString("NAME", null);
            userWrite.putString("PWD", null);
            userWrite.putBoolean("REMEMBER", false);
            userWrite.commit();
        }

        String userName = userLogin.getString("NAME", null);
        String userPwd = userLogin.getString("PWD", null);
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
        finish();
        //登录成功后将密码保存
    }

    public void regist(View view) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);

    }
}
