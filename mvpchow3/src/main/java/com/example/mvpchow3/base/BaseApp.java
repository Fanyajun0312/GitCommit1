package com.example.mvpchow3.base;

import android.app.Application;
import android.content.res.Resources;

/**
 * @date：2020/7/11
 * @describe：app
 * @author：FanYaJun
 */
public class BaseApp extends Application {
    private static BaseApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static Resources getApp() {
        return app.getResources();
    }
}
