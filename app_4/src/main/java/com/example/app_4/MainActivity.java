package com.example.app_4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_write;
    private RecyclerView rv_view;
    private Button btn_delete;
    private Unbinder unbinder;
    private MyAdapter adapter;
    private Button chos_all;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        unbinder = ButterKnife.bind(this);

        rv_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://www.qubaobei.com/ios/cf/");


        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        CookInterFace cookInterFace = retrofit.create(CookInterFace.class);
        Call<CookBean> cookBeanCall = cookInterFace.getData();
        cookBeanCall.enqueue(new Callback<CookBean>() {
            @Override
            public void onResponse(Call<CookBean> call, Response<CookBean> response) {
                CookBean cookBean = response.body();
                List<CookBean.DataBean> dataBeans = cookBean.getData();

                adapter = new MyAdapter(MainActivity.this,dataBeans);
                rv_view.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<CookBean> call, Throwable t) {

            }
        });
    }

    private void initView() {
        btn_write = (Button) findViewById(R.id.btn_write);
        rv_view = (RecyclerView) findViewById(R.id.rv_view);
        btn_delete = (Button) findViewById(R.id.btn_delete);

        btn_write.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        chos_all = (Button) findViewById(R.id.chos_all);
        chos_all.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_write:
                Toast.makeText(this,"123",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_delete:
                Toast.makeText(this,"456",Toast.LENGTH_LONG).show();

                break;
            case R.id.chos_all:
                Toast.makeText(this,"789",Toast.LENGTH_LONG).show();
//                adapter.All();
                break;
        }
    }
}
