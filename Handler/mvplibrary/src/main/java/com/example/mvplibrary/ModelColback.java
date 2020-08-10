package com.example.mvplibrary;

/**
 * @date：2020/8/9
 * @describe：model接口实现于model作为底层m
 * @author：FanYaJun
 */
public interface ModelColback {

    //专门做网络请求接口
    interface Http<T>{
        //网络请求数据成功的回调
        public void onScssess(T object);
        //网络请求失败的信息打印
        public void onError(int code,String manager);

        public void onCanal();
    }

    //用来请求其他数据的接口
    interface Data<T>{
        public void onScssess(T object);
    }

}
