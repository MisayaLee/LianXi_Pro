package com.example.app_3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_write;
    private RecyclerView recycle_view;
    private String path = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    private List list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        recycle_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        MyAdapter adapter = new MyAdapter();
        recycle_view.setAdapter(adapter);
    }

    private void initView() {
        btn_write = (Button) findViewById(R.id.btn_write);
        recycle_view = (RecyclerView) findViewById(R.id.recycle_view);
        btn_write.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_write:

                break;
        }
    }
    class Task extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            return HttPUtils.getString(path);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s!=null&&!s.isEmpty()) {
                Gson gson = new Gson();
                CookBean cookBean = gson.fromJson(s, CookBean.class);
                List<CookBean.DataBean> data = cookBean.getData();

            }
        }
    }
}
