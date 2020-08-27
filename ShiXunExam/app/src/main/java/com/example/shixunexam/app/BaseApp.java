package com.example.shixunexam.app;

import android.app.Application;
import android.content.res.Resources;

/**
 * @date：2020/8/26
 * @describe：
 * @author：FanYaJun
 */
public class BaseApp extends Application {
    public static BaseApp sBaseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;//引用本App对象
    }

    public static BaseApp getsBaseApp() {
        return sBaseApp;
    }
}
