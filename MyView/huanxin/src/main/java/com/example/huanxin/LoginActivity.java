package com.example.huanxin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.huanxin.utils.SpUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_name;
    private EditText ed_paw;
    private Button btn_login;
    private Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EMClient.getInstance().groupManager().loadAllGroups();
        EMClient.getInstance().chatManager().loadAllConversations();
        boolean loggedInBefore = EMClient.getInstance().isLoggedInBefore();
        if(loggedInBefore){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_paw = (EditText) findViewById(R.id.ed_paw);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_reg = (Button) findViewById(R.id.btn_reg);

        btn_login.setOnClickListener(this);
        btn_reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_reg:
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                break;
        }
    }

    private void login() {
        String name = ed_name.getText().toString();
        String paw = ed_paw.getText().toString();
        if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(paw)){
            EMClient.getInstance().login(name, paw, new EMCallBack() {
                @Override
                public void onSuccess() {
                    //以上两个方法是为了保证进入主页面后本地会话和群组都 load 完毕
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         SpUtils.setParam(LoginActivity.this,"name",name);
                         startActivity(new Intent(LoginActivity.this,MainActivity.class));
                         Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                     }
                 });
                }

                @Override
                public void onError(int i, String s) {
                    Log.e("TAG", "onError: "+s );
                }

                @Override
                public void onProgress(int i, String s) {

                }
            });
        }else {


        }
    }


}
