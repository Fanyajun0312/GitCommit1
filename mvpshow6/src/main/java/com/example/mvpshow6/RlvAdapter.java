package com.example.mvpshow6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshow6.bean.ListBean;
import com.example.mvpshow6.utils.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @date：2020/7/12
 * @describe：adapter
 * @author：FanYaJun
 */
public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListBean.T1348647909107Bean> list;
    public boolean isshow;
    public RlvAdapter(Context context, ArrayList<ListBean.T1348647909107Bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rlv_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            if(isshow){//默认flase
                holder.ck.setVisibility(View.VISIBLE);
            }else {
                holder.ck.setVisibility(View.INVISIBLE);
            }
            holder.ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){//点击了
                        list.get(position).setIscilck(true);//数据选中
                    }else {
                        list.get(position).setIscilck(false);//否则不选中
                    }
                }
            });
            holder.ck.setChecked(list.get(position).isIscilck());
            holder.tvTe.setText(list.get(position).getSubtitle());
              ImageLoader.setIMage(context,list.get(position).getUrl(),holder.ivImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_te)
        TextView tvTe;
        @BindView(R.id.ck)
        CheckBox ck;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
