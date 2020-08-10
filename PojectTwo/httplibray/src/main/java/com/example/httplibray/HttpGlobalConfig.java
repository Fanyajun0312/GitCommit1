package com.example.httplibray;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import okhttp3.Interceptor;

/**
 * @date：2020/8/10
 * @describe：用来设置请求头拦截器参数日至拦截器baseuriapiuri
 * @author：FanYaJun
 */
public class HttpGlobalConfig {

    //base
    private String baseuri;
    private long timeout;
    private TimeUnit timeUnit;
    //公共请求参数
    private Map<String,Object> parmes;
    //公共请求头
    private Map<String,Object> handlers;
    //公共拦截器
    private List<Interceptor> interceptors;
    //日至开关
    private boolean isShowLog;
    //handler
    private Handler handler = new Handler(Looper.getMainLooper());
    //上下文
    private Context context;

    public HttpGlobalConfig() {
    }
    public static final class HttpGlobalConfigHandler{
        private static HttpGlobalConfig INSTATAR=new HttpGlobalConfig();
    }
    public static HttpGlobalConfig getInstance(){
        return HttpGlobalConfigHandler.INSTATAR;
    }

    public String getBaseuri() {
        return baseuri;
    }

    public HttpGlobalConfig setBaseuri(String baseuri) {
        this.baseuri = baseuri;
        return HttpGlobalConfig.getInstance();
    }

    public long getTimeout() {
        return timeout;
    }

    public HttpGlobalConfig setTimeout(long timeout) {
        this.timeout = timeout;
        return HttpGlobalConfig.getInstance();
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public HttpGlobalConfig setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        return HttpGlobalConfig.getInstance();

    }

    public Map<String, Object> getParmes() {
        return parmes;
    }

    public HttpGlobalConfig setParmes(Map<String, Object> parmes) {
        this.parmes = parmes;
        return HttpGlobalConfig.getInstance();

    }

    public Map<String, Object> getHandlers() {
        return handlers;
    }

    public HttpGlobalConfig setHandlers(Map<String, Object> handlers) {
        this.handlers = handlers;
        return HttpGlobalConfig.getInstance();

    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public HttpGlobalConfig setInterceptors(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
        return HttpGlobalConfig.getInstance();

    }

    public boolean isShowLog() {
        return isShowLog;
    }

    public HttpGlobalConfig setShowLog(boolean showLog) {
        isShowLog = showLog;
        return HttpGlobalConfig.getInstance();

    }

    public Handler getHandler() {
        return handler;
    }

    public HttpGlobalConfig setHandler(Handler handler) {
        this.handler = handler;
        return HttpGlobalConfig.getInstance();

    }
    public HttpGlobalConfig initReady(Context context){
        this.context=context.getApplicationContext();
        handler= new Handler(Looper.getMainLooper());
        return HttpGlobalConfig.getInstance();
    }
    public Context getContext() {
        return context;
    }

    public HttpGlobalConfig setContext(Context context) {
        this.context = context;
        return HttpGlobalConfig.getInstance();
    }


}
