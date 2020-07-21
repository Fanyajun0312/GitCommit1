package com.example.mvpshow9.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import com.example.mvpshow9.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhunFragment extends Fragment {


    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_stop)
    Button btnStop;
    @BindView(R.id.vedio)
    VideoView vedio;
    private View inflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_zhun, container, false);
//        initData();
        return inflate;
    }

    private void initData() {
        vedio.start();
    }

    @OnClick({R.id.btn_start, R.id.btn_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                if(!vedio.isPlaying()){
                    vedio.start();
                }
                break;
            case R.id.btn_stop:
                if(vedio.isPlaying()){
                    vedio.stopPlayback();
                }
                break;
        }
    }
}
