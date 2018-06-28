package com.example.misaya.lianxi_pro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Unbinder unbinder;

    //绑定控件
    @BindView(R.id.recycle_list)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Retrofit.Builder builder = new Retrofit.Builder();


        //http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
        builder.baseUrl("http://www.qubaobei.com/ios/cf/");



        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        CookInterFace cookInterFace = retrofit.create(CookInterFace.class);
        Call<CookBean>cookBeanCall  = cookInterFace.getData();
        cookBeanCall.enqueue(new Callback<CookBean>() {
            @Override
            public void onResponse(Call<CookBean> call, Response<CookBean> response) {
                CookBean cookBean = response.body();
                List<CookBean.DataBean>dataBeans = cookBean.getData();

                MyAdapter adapter = new MyAdapter(MainActivity.this,dataBeans);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<CookBean> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
