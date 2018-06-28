package com.example.app_3;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Misaya on 2018/6/27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<CookBean.DataBean>dataBeans;

    public MyAdapter() {
        this.mContext = mContext;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.choose_btn.setChecked(true);
        holder.iv_id.setImageURI(Uri.parse(dataBeans.get(position).getPic()));
        holder.tv_id.setText(dataBeans.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  CheckBox choose_btn;
        private ImageView iv_id;
        private TextView tv_id;
        public ViewHolder(View itemView) {
            super(itemView);
            choose_btn = (CheckBox) itemView.findViewById(R.id.item_choose_id);
            iv_id = (ImageView)itemView.findViewById(R.id.item_iv_id);
            tv_id = (TextView)itemView.findViewById(R.id.item_tv_id);
        }
    }
}
