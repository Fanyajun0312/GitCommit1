package com.example.shixunexam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shixunexam.R;
import com.example.shixunexam.bean.DescBean;

import java.util.ArrayList;

/**
 * @date：2020/8/26
 * @describe：
 * @author：FanYaJun
 */
public class DescAdapter extends RecyclerView.Adapter<DescAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DescBean> list;

    public DescAdapter(Context context, ArrayList<DescBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rlv_desc, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DescBean descBean = list.get(position);
        Glide.with(context).load(descBean.getGoodsDefaultIcon()).apply(new RequestOptions().centerInside()).into(holder.iv_data_img);
        holder.tv_kucun.setText("库存"+descBean.getGoodsSalesCount());
        holder.tv_manary.setText("¥"+descBean.getGoodsDefaultPrice());
        holder.tv_xiaoliang.setText("销量"+descBean.getGoodsStockCount()+"件");
        holder.tv_xinghao.setText(descBean.getGoodsDesc());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickLitener.OnItemListener(position);
            }
        });
    }
    private onItemClickLitener onItemClickLitener;

    public void setOnItemClickLitener(DescAdapter.onItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    public interface onItemClickLitener{
        void OnItemListener(int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_data_img;//图片
        public TextView tv_xinghao;//
        public TextView tv_manary;//价格
        public TextView tv_xiaoliang;//销量
        public TextView tv_kucun;//库存
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_data_img = (ImageView) itemView.findViewById(R.id.iv_data_img);
            this.tv_xinghao = (TextView) itemView.findViewById(R.id.tv_xinghao);
            this.tv_manary = (TextView) itemView.findViewById(R.id.tv_manary);
            this.tv_xiaoliang = (TextView) itemView.findViewById(R.id.tv_xiaoliang);
            this.tv_kucun = (TextView) itemView.findViewById(R.id.tv_kucun);
        }
    }
}
