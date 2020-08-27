package com.example.pojecttwo.adapter;

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
import com.example.pojecttwo.R;
import com.example.pojecttwo.shipinbean.DataBean;
import com.example.pojecttwo.shipinbean.ShiPinDemo;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * @date：2020/8/11
 * @describe：
 * @author：FanYaJun
 */
public class RlvSpAdapter extends RecyclerView.Adapter<RlvSpAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DataBean> list;

    public RlvSpAdapter(Context context, ArrayList<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rlvitem_sp, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String avatar = list.get(position).getAuthor().getAvatar();
        String name = list.get(position).getAuthor().getName();
        String feeds_text = list.get(position).getFeeds_text();
        String uri = list.get(position).getUrl();
        String cover = list.get(position).getCover();
        int likeCount = list.get(position).getAuthor().getLikeCount();
        int commentCount = list.get(position).getAuthor().getCommentCount();
        Glide.with(context).load(avatar).apply(new RequestOptions().circleCrop()).into(holder.img);
        int topCommentCount = list.get(position).getAuthor().getTopCommentCount();
        int favoriteCount = list.get(position).getAuthor().getFavoriteCount();
        String description = list.get(position).getAuthor().getDescription();

        holder.tv_title.setText(name);
        holder.tv_title2.setText(feeds_text);
        holder.jz.setUp(uri, holder.jz.SCREEN_WINDOW_NORMAL);
        Glide.with(context).load(cover)
                .into(holder.jz.thumbImageView);
        holder.tv_zan.setText(likeCount+"");
        holder.tv_cai.setText(commentCount+"");
        holder.tv_xin.setText(topCommentCount+"");
        holder.tv_zhuan.setText(favoriteCount+"");
        holder.tv_zhi.setText(description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView tv_title;
        public TextView tv_title2;
        public JZVideoPlayerStandard jz;
        public ImageView img2;
        public TextView tv_title3;
        public ImageView img_zan;
        public TextView tv_zan;
        public ImageView img_cai;
        public TextView tv_cai;
        public ImageView img_xin;
        public TextView tv_xin;
        public ImageView img_zhuan;
        public TextView tv_zhuan;
        public TextView tv_zhi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_title2 = (TextView) itemView.findViewById(R.id.tv_title2);
            this.jz = (JZVideoPlayerStandard) itemView.findViewById(R.id.jz);
            this.img2 = (ImageView) itemView.findViewById(R.id.img2);
            this.tv_title3 = (TextView) itemView.findViewById(R.id.tv_title3);
            this.img_zan = (ImageView) itemView.findViewById(R.id.img_zan);
            this.tv_zan = (TextView) itemView.findViewById(R.id.tv_zan);
            this.img_cai = (ImageView) itemView.findViewById(R.id.img_cai);
            this.tv_cai = (TextView) itemView.findViewById(R.id.tv_cai);
            this.img_xin = (ImageView) itemView.findViewById(R.id.img_xin);
            this.tv_xin = (TextView) itemView.findViewById(R.id.tv_xin);
            this.img_zhuan = (ImageView) itemView.findViewById(R.id.img_zhuan);
            this.tv_zhuan = (TextView) itemView.findViewById(R.id.tv_zhuan);
            this.tv_zhi = (TextView) itemView.findViewById(R.id.tv_zhi);
        }
    }


}
