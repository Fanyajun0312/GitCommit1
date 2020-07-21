package com.example.mvpchow10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpchow10.bean.doaw;
import com.example.mvpchow10.server.MyService;
import com.example.mvpchow10.utils.Installutil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DowLoadActivity extends AppCompatActivity {

    @BindView(R.id.sk)
    SeekBar sk;
    @BindView(R.id.btn_ser)
    Button btnSer;
    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dow_load);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initP();
    }

    private void initP() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void load(doaw doaw) {
        int contentLength = doaw.getContentLength();
        int count = doaw.getCount();
        sk.setMax(contentLength);
        int i = (int) ((float) count / contentLength * 100);
        tvName.setText( i+ "%");
        sk.setProgress(count);

        Installutil.installApk(DowLoadActivity.this, doaw.getPath());
    }

    @OnClick(R.id.btn_ser)
    public void onViewClicked() {
        Intent intent = new Intent(DowLoadActivity.this, MyService.class);
        startService(intent);
    }
}
