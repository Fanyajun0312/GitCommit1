package com.example.pojecttwo.app;

import android.app.Application;

import com.example.httplibray.HttpGlobalConfig;

import java.util.concurrent.TimeUnit;

/**
 * @date：2020/8/10
 * @describe：
 * @author：FanYaJun
 */
public class AppDianshang extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        HttpGlobalConfig.getInstance()
                .setBaseuri("http://123.56.232.18:8080/")
                .setTimeout(2)
                .setTimeUnit(TimeUnit.SECONDS)
                .setShowLog(true)
                .initReady(this);

    }


}
