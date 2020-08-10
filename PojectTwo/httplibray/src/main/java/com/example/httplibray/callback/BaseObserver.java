package com.example.httplibray.callback;

import android.text.TextUtils;


import com.example.httplibray.HttpGlobalConfig;
import com.example.httplibray.disposable.RequestManagerlm;
import com.example.httplibray.example.ApiException;
import com.example.httplibray.example.ExceptionEngine;
import com.example.httplibray.utils.ThreadUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 项目名：Shopping
 * 包名：  com.example.httplibrary.callback
 * 文件名：BaseObserver
 * 创建者：liangxq
 * 创建时间：2020/8/1  14:15
 * 描述：TODO
 */
public abstract class BaseObserver implements Observer{
    String tag;
    @Override
    public void onSubscribe(Disposable d) {
        if(!TextUtils.isEmpty(tag)){
            RequestManagerlm.getInstance().add(tag,d);
        }
    }

    @Override
    public void onNext(Object t) {
        if(!TextUtils.isEmpty(tag)){
            RequestManagerlm.getInstance().revemr(tag);
        }
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            ApiException apiException= (ApiException) e;
            onError(apiException.getMsg(),apiException.getCode());
        }else{
            onError("未知异常", ExceptionEngine.UN_KNOWN_ERROR);
        }
        if(!TextUtils.isEmpty(tag)){
            RequestManagerlm.getInstance().revemr(tag);
        }
    }

    @Override
    public void onComplete() {
        if(!RequestManagerlm.getInstance().isDispose(tag)){
            RequestManagerlm.getInstance().cancle(tag);
        }
    }

    //回调错错误信息
     public abstract void onError(String message, int code);


     public abstract void cancle();


    //网络请求取消
    public void canclend(){
        if(!ThreadUtils.isMainThread()){
            HttpGlobalConfig.getInstance().getHandler().post(new Runnable() {
                @Override
                public void run() {
                    cancle();
                }
            });
        }
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}
