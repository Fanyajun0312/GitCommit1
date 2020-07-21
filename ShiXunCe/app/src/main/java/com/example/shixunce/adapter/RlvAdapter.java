package com.example.shixunce.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shixunce.R;
import com.example.shixunce.bean.ListBean;

import java.util.ArrayList;
import java.util.logging.Handler;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.shixunce.R.drawable.ic_cloud;
import static com.example.shixunce.R.drawable.ic_cloud_queue_black_24dp;

/**
 * @date：2020/7/17
 * @describe：
 * @author：FanYaJun
 */
public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListBean.DataBean.DatasBean> list;
    private onClickItemListener onClickItemListener;
    public boolean ishow;

    public boolean isIshow() {
        return ishow;
    }

    public void setOnClickItemListener(RlvAdapter.onClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public RlvAdapter(Context context, ArrayList<ListBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rlv, parent, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTit.setText(list.get(position).getTitle());

        if(ishow!=true){
            Glide.with(context).load(ic_cloud).into(holder.ivImg);
        }else {
            Glide.with(context).load(ic_cloud_queue_black_24dp).into(holder.ivImg);
        }
        ListBean.DataBean.DatasBean datasBean = list.get(position);
        holder.ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItemListener(position);
                if(ishow=true){
                   list.get(position).setIsclick(true);
                }else {
                    list.get(position).setIsclick(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tit)
        TextView tvTit;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface onClickItemListener{
        void onClickItemListener(int position);
    }
}
