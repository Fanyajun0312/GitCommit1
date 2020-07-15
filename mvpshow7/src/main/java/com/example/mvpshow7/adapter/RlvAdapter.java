package com.example.mvpshow7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshow7.R;
import com.example.mvpshow7.bean.ListBean;
import com.example.mvpshow7.utils.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @date：2020/7/13
 * @describe：
 * @author：FanYaJun
 */
public class RlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ListBean.DataBean.DatasBean> list;
    public int VIEW_TYPE_ONE = 1;
    public int VIEW_TYPE_TWO = 2;
    public onClickitemListener onClickitemListener;

    public void setOnClickitemListener(RlvAdapter.onClickitemListener onClickitemListener) {
        this.onClickitemListener = onClickitemListener;
    }

    public RlvAdapter(Context context, ArrayList<ListBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ONE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.rlv_item_one, parent, false);
            return new ViewHolderone(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.rlv_item_two, parent, false);
            return new ViewHoldertwo(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==VIEW_TYPE_ONE){
            ViewHolderone viewHolderone= (ViewHolderone) holder;
            viewHolderone.tvTit.setText(list.get(position).getTitle());
            viewHolderone.tvTime.setText("25:00");
            viewHolderone.tvZuo.setText(list.get(position).getChapterName());
        }else{
            ViewHoldertwo viewHoldertwo= (ViewHoldertwo) holder;
            viewHoldertwo.tvName.setText(list.get(position).getChapterName());
            viewHoldertwo.tvTime.setText("15:00");
            viewHoldertwo.tvTitle.setText(list.get(position).getTitle());
            ImageLoader.setIMage(context,list.get(position).getEnvelopePic(),viewHoldertwo.ivImg);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickitemListener.onclickItemListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2 == 0) {
            return VIEW_TYPE_ONE;

        } else {
            return VIEW_TYPE_TWO;
        }
    }


    class ViewHolderone extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_zuo)
        TextView tvZuo;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_tit)
        TextView tvTit;

        ViewHolderone(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    class ViewHoldertwo extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHoldertwo(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface onClickitemListener{
        void onclickItemListener(int position);
    }
}
