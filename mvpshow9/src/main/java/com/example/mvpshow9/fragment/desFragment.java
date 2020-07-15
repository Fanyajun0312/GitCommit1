package com.example.mvpshow9.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mvpshow9.R;
import com.example.mvpshow9.bean.JiangShiBean;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class desFragment extends Fragment {


    private View inflate;
    private Unbinder bind;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_des, container, false);
        TextView id = inflate.findViewById(R.id.tv_ddd);
        id.setText("adasdapowaiufgizkc;lafkquicgbsvldjujmubtsdyvkg vbsfkucfveanvkykvhmgbfyucdjaeouv9+5+9465644568698af7sd46sd");

        return inflate;
    }

}
