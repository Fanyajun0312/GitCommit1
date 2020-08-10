package com.example.httplibray.disposable;

import io.reactivex.disposables.Disposable;

/**
 * @date：2020/8/10
 * @describe：处理订阅关系接口
 * * @author：FanYaJun
 */
public interface RequestManager {
    /**
     *
     * @param tag 标识
     * @param disposable
     */
    //添加
    void add(String tag, Disposable disposable);
    //取消
    void cancle(String tag);
    //移除
    void revemr(String tag);
    //取消所有
    void cancleAll();
}
