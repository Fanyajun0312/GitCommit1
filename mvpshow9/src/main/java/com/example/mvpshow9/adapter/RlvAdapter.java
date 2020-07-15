package com.example.mvpshow9.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvpshow9.MainActivity;
import com.example.mvpshow9.R;
import com.example.mvpshow9.bean.JiangShiBean;

import java.util.ArrayList;
import java.util.Properties;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.PUT;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<JiangShiBean.BodyBean.ResultBean> list;
    private onclicitemListener onclicitemListener;
    public boolean isbutton;
    public void setOnclicitemListener(RlvAdapter.onclicitemListener onclicitemListener) {
        this.onclicitemListener = onclicitemListener;
    }

    public RlvAdapter(Context context, ArrayList<JiangShiBean.BodyBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tlv_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getTeacherName());
        holder.tvTitile.setText(list.get(position).getTitle());
        holder.tvDesc.setText(list.get(position).getDescription());
        Glide.with(context).load(list.get(position).getTeacherPic()).apply(new RequestOptions().circleCrop()).into(holder.ivImg);
        if(isbutton){
            holder.btnGuan.setVisibility(View.INVISIBLE);
        }else {
            holder.btnGuan.setVisibility(View.VISIBLE);
        }

        holder.btnGuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.btnGuan.isClickable()){
                    holder.btnGuan.setText("已关注");
                }else{
                    holder.btnGuan.setText("关注");
                }
                    onclicitemListener.oncilck(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface onclicitemListener{
        void oncilck(int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_titile)
        TextView tvTitile;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.btn_guan)
        Button btnGuan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
