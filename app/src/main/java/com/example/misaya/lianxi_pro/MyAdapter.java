package com.example.misaya.lianxi_pro;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Misaya on 2018/6/25.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<CookBean.DataBean>data;
    public static String Money;
    public MyAdapter(Context mContext, List<CookBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycle,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText("菜名："+data.get(position).getTitle());
        holder.pirce_id.setText("价格："+data.get(position).getId());
        holder.simpleDraweeView.setImageURI(Uri.parse(data.get(position).getPic()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ItemActivity.class);
                intent.putExtra("Pic",data.get(position).getPic());
                intent.putExtra("name",data.get(position).getTitle());
                intent.putExtra("pirce",data.get(position).getId());
                Money = data.get(position).getId();
                mContext.startActivity(intent);
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
        @BindView(R.id.tv_id)
        TextView textView;
        @BindView(R.id.pirce_id)
        TextView pirce_id;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}