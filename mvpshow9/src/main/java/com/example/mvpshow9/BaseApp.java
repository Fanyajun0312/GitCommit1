package com.example.mvpshow9;

import android.app.Application;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public class BaseApp extends Application {
    public static BaseApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static BaseApp getApp() {
        return app;
    }
}
