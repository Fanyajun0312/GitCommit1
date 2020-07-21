package com.example.mvpchow10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvpchow10.R;
import com.example.mvpchow10.bean.PojectList;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PojectList.DataBean.DatasBean> list;
    private onClickitemListener onClickitemListener;

    public void setOnClickitemListener(RlvAdapter.onClickitemListener onClickitemListener) {
        this.onClickitemListener = onClickitemListener;
    }

    public RlvAdapter(Context context, ArrayList<PojectList.DataBean.DatasBean> list) {
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
        Glide.with(context).load(list.get(position).getEnvelopePic()).into(holder.ivImg);
        holder.tvTit.setText(list.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickitemListener.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface onClickitemListener {
        void onClickItem(int position);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_tit)
        TextView tvTit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
