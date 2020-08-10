package com.example.httplibray;

import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date：2020/8/10
 * @describe：
 * @author：FanYaJun
 */
public class HttpManager {
    private static volatile HttpManager instance;

    public HttpManager() {
    }

    public static HttpManager getInstance() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager();

                }
            }

        }
        return instance;
    }

    public Retrofit getRetorfit(String baseuri, long timeout, TimeUnit timeUnit) {
        return new Retrofit.Builder()
                .client(getBaseOkHttpClient(timeout, timeUnit))
                .baseUrl(baseuri)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient getBaseOkHttpClient(long timeout, TimeUnit timeUnit) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("TAG", "log: " + message);
            }
        });
        Interceptor interceptor = new Interceptor() {
            @Override

            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                return response;
            }
        };
        Interceptor[] interceptors = {httpLoggingInterceptor, interceptor};
        return getClient(timeout, timeUnit, interceptors);
    }


    private OkHttpClient getClient(long timeout, TimeUnit timeUnit, Interceptor... interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(timeout, timeUnit);
        builder.readTimeout(timeout, timeUnit);
        builder.writeTimeout(timeout, timeUnit);
        for (Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }
        List<Interceptor> interceptors1 = HttpGlobalConfig.getInstance().getInterceptors();
        if (interceptors1 != null) {
            for (Interceptor interceptor : interceptors1) {
                builder.addInterceptor(interceptor);
            }

        }


        return builder.build();
    }
}
