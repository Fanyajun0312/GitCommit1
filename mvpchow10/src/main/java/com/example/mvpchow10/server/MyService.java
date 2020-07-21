package com.example.mvpchow10.server;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import com.example.mvpchow10.api.ApiServicer;
import com.example.mvpchow10.bean.doaw;

import org.greenrobot.eventbus.EventBus;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServicer.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServicer apiService = retrofit.create(ApiServicer.class);
        Observable<ResponseBody> observable = apiService.getAPK();
        observable.subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        //获取长度
                        long contentLength = responseBody.contentLength();
                        InputStream inputStream = responseBody.byteStream();
                        saveFail(inputStream, Environment.getExternalStorageDirectory() + "/aaaaa.apk", contentLength);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "错误:" + e.getMessage());
                    }
                    @Override
                    public void onComplete() {

                    }
                });



    }
    private int count;
    private void saveFail(InputStream inputStream, String path, long contentLength) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            int length;
            byte[] bytes = new byte[1024 * 1024 * 10];

            while ((length = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, length);
                count += length;
                Log.d("TAG", "下载进度" + count + "/" + contentLength);
                doaw doaw = new doaw();
                doaw.setContentLength((int) contentLength);
                doaw.setCount(count);
                doaw.setPath(path);
                EventBus.getDefault().postSticky(doaw);
            }
            inputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
