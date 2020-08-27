package com.example.pojecttwo.model;

import com.example.httplibray.callback.HttpCallBack;
import com.example.httplibray.client.HttpClient;
import com.example.httplibray.utils.JsonUtils;
import com.example.mvplibary.model.BaseModel;
import com.example.pojecttwo.callback.FrspCallBack;
import com.example.pojecttwo.ceshibean.ShiPinBean;
import com.example.pojecttwo.presenter.FraSpPresenter;
import com.example.pojecttwo.shipinbean.DataBean;
import com.example.pojecttwo.shipinbean.ShiPinDemo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

/**
 * @date：2020/8/11
 * @describe：
 * @author：FanYaJun
 */
public class FraSpModel implements BaseModel {

    public void getdata(FrspCallBack callBack, LifecycleProvider lifecycleProvider) {
        new HttpClient.Builder()
                .setApiUrl("serverdemo/feeds/queryHotFeedsList")
                .get()
                .setLifecycleProvider(lifecycleProvider)
                .build()
                .request(new HttpCallBack<ShiPinDemo>() {

                    @Override
                    public void onError(String message, int code) {
                        callBack.onErrorr(message, code);
                    }

                    @Override
                    public void cancle() {
                        callBack.cancle();
                    }

                    @Override
                    public void onSuccess(ShiPinDemo shiPinBean) {
                        callBack.onSerssrss(shiPinBean);
                    }

                    @Override
                    public ShiPinDemo convert(JsonElement result) {
                        ShiPinDemo shiPinBean = JsonUtils.jsonToClass(result, ShiPinDemo.class);
                        return shiPinBean;
                    }
                });
    }
}
