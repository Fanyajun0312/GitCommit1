package com.example.mvplibrary.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date：2020/8/9
 * @describe：
 * @author：FanYaJun
 */
public class MvpViewProxy<V extends BaseView> implements InvocationHandler {
    private V mView;
    //创建代理（接受委托）
    public Object newinvocationHandler(V view){
        this.mView=view;
        return Proxy.newProxyInstance(view.getClass().getClassLoader(),view.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // V 为空直接返回 null 不再继续调用函数
        if(mView==null){
            return null;
            
        }
        //调用目标方法
        Object invoke = method.invoke(mView, args);
        return invoke;
    }


    //解绑view
    public void detachView(){
        mView=null;
    }
}
