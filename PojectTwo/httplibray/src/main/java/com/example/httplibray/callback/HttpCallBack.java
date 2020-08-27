package com.example.httplibray.callback;

import android.util.Log;

import com.example.httplibray.demo.Response;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * 项目名：Shopping
 * 包名：  com.example.httplibrary.callback
 * 文件名：HttpCallBack
 * 创建者：liangxq
 * 创建时间：2020/8/3  14:29
 * 描述：TODO
 * <p>
 * 示例
 */
public abstract class HttpCallBack<T> extends BaseCallBack<T> {
    Response response;//代表最外围
    @Override
    protected T onConvert(String result) {
        T t=null;//代表数据
        response = new Gson().fromJson(result, Response.class);//得到数据外围
        JsonElement data = response.getData();
        int errorCode = response.getErrorCode();
        String errorMsg = response.getErrorMsg();
        switch (errorCode) {//sw遍历 code吗如果是-1那么没有请求到数据
            case -1:
                onError(errorMsg,errorCode);//爆出他的错误信息
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);//回调成功方法数据等于他
                }
                break;
        }
        Log.e("TAG", "onConvert: "+t.toString() );
        return t;//返回给本类
    }


    @Override
    public boolean isCodeSuccess() {//判断等于0的话就传输局
        if (response != null) {
            return response.getErrorCode() == 0;
        }
        return false;
    }

}
