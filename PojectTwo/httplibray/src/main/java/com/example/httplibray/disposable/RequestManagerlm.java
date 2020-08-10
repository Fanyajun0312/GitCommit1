package com.example.httplibray.disposable;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.reactivex.disposables.Disposable;

/**
 * @date：2020/8/10
 * @describe：
 * @author：FanYaJun
 */
public class RequestManagerlm implements RequestManager {
    private static volatile RequestManagerlm instance;
    /**
     * 管理所有订阅关系的map的集合
     */
    private static Map<String,Disposable> maps=new HashMap<>();
    public static RequestManagerlm getInstance() {
        if(instance==null){
            synchronized (RequestManagerlm.class){
                if(instance==null){
                    instance=new RequestManagerlm();

                }
            }
        }
        return instance;
    }

    @Override
    public void add(String tag, Disposable disposable) {
        if(!TextUtils.isEmpty(tag)){
            maps.put(tag,disposable);
        }
    }

    @Override
    public void cancle(String tag) {
        if(!TextUtils.isEmpty(tag)){
            if (!maps.isEmpty()){
                if(maps.get(tag)!=null){
                    Disposable disposable =  maps.get(tag);
                    if(!disposable.isDisposed()){
                        disposable.dispose();
                    }
                    maps.remove(tag);
                }
            }
        }
    }

    @Override
    public void revemr(String tag) {
        if(!TextUtils.isEmpty(tag)){
            if(maps.isEmpty()){
                return;
            }
            maps.remove(tag);
        }
    }

    @Override
    public void cancleAll() {
        Disposable disposable=null;
        if(!maps.isEmpty()){
            Set<String> keys = maps.keySet();
            for (String key : keys) {
                if(maps.get(key)!=null){
                    disposable= maps.get(key);
                }
                if(disposable!=null&&!disposable.isDisposed()){
                    disposable.dispose();
                }
            }
        }
        maps.clear();
    }
    public boolean isDispose(String tag){
        if(!maps.isEmpty()&&maps.get(tag)!=null){
            return maps.get(tag).isDisposed();
        }
        return false;
    }
}
