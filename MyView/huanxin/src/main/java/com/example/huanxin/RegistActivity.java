package com.example.huanxin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_reg_name;
    private EditText ed_reg_paw;
    private Button btn_reg_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    private void initView() {
        ed_reg_name = (EditText) findViewById(R.id.ed_reg_name);
        ed_reg_paw = (EditText) findViewById(R.id.ed_reg_paw);
        btn_reg_reg = (Button) findViewById(R.id.btn_reg_reg);

        btn_reg_reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reg_reg:
                regis();
                break;
        }
    }

    private void regis() {
        String name = ed_reg_name.getText().toString().trim();
        String paw = ed_reg_paw.getText().toString().trim();
        if (TextUtils.isEmpty(name)&&TextUtils.isEmpty(paw)) {
            Toast.makeText(this, "账号密码不可为空", Toast.LENGTH_SHORT).show();
        }else {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        EMClient.getInstance().createAccount(name,paw);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                        finish();
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
    }

}
