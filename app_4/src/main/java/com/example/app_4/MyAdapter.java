package com.example.app_4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;

/**
 * Created by Misaya on 2018/6/25.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private HashMap<Integer, Boolean> map;
    private List<CookBean.DataBean>data;

    public MyAdapter(Context mContext, List<CookBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

//    public MyAdapter() {
//
//    }

//    public void All() {
//        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
//        boolean shouldall = false;
//        for (Map.Entry<Integer, Boolean> entry : entries) {
//            Boolean value = entry.getValue();
//            if (!value) {
//                shouldall = true;
//                break;
//            }
//        }
//        for (Map.Entry<Integer, Boolean> entry : entries) {
//            entry.setValue(shouldall);
//        }
//        notifyDataSetChanged();
//    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycle,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.textView.setText(data.get(position).getTitle());
        holder.simpleDraweeView.setImageURI(Uri.parse(data.get(position).getPic()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                holder.checkBox.setChecked(true);
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv_id)
        SimpleDraweeView simpleDraweeView;
        @BindView(R.id.btn_chos)
        CheckBox checkBox;
        @BindView(R.id.msg_id)
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}