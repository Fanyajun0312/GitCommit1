package com.example.shixunexam.mvp;

import com.example.httplibray.callback.HttpCallBack;
import com.example.httplibray.client.HttpClient;
import com.example.httplibray.utils.JsonUtils;
import com.example.mvplibary.model.BaseModel;
import com.example.shixunexam.bean.GlicdeBesn;
import com.google.gson.JsonElement;

import javax.security.auth.callback.Callback;

/**
 * @date：2020/8/26
 * @describe：
 * @author：FanYaJun
 */
public class GModel implements BaseModel {
    public void getData(CallBack callback) {
        new HttpClient.Builder()
                .setBaseUrl("http://169.254.189.205:8080/")
                .setApiUrl("kotlin/goods/getGoodsDetail")
                .setJsonBody("{\"goodsId\":1}", true)
                .post()
                .build()
                .request(new HttpCallBack<GlicdeBesn>() {

                    @Override
                    public void onError(String message, int code) {
                        callback.onError(message, code);
                    }

                    @Override
                    public void cancle() {
                        callback.onCancle();
                    }

                    @Override
                    public void onSuccess(GlicdeBesn glicdeBesn) {
                        callback.showOK(glicdeBesn);
                    }

                    @Override
                    public GlicdeBesn convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, GlicdeBesn.class);
                    }
                });
    }
}
