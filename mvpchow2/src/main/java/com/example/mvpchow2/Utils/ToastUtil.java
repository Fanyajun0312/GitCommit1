package com.example.mvpchow2.Utils;

import android.widget.Toast;

import com.example.mvpchow2.base.BaseApp;

public class ToastUtil {
    public static void showShort(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_LONG).show();
    }
}
