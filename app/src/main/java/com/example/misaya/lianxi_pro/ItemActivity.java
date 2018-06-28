package com.example.misaya.lianxi_pro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;
public class ItemActivity extends AppCompatActivity implements View.OnClickListener {
    String pic, name;
    int pirce;
    int num = 1;
    int total_Money  = 1;
    private TextView tv_id;
    private TextView pirce_id;
    private SimpleDraweeView sdv_id;
    private Button add_car;
    private SimpleDraweeView car_image;
    private TextView car_title;
    private TextView car_pirce;
    private TextView text_mes;
    private Button car_add;
    private TextView car_num;
    private Button car_delete;
    private Button Submit_intent;
    private TextView total_ZD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        initView();
        Intent intent = getIntent();
        pic = intent.getStringExtra("Pic");
        name = intent.getStringExtra("name");
        pirce = intent.getIntExtra("pirce", Integer.parseInt(MyAdapter.Money));
        tv_id.setText(name);
        pirce_id.setText("价格：" + pirce);
        sdv_id.setImageURI(pic);
    }
    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_car:
                Toast.makeText(ItemActivity.this, "加入成功", Toast.LENGTH_LONG).show();
                car_image.setImageURI(pic);
                car_title.setText(name);
                car_pirce.setText("价格：" + num * pirce);
                text_mes.setText("数  量");
                car_num.setText("" + num);
                break;
            case R.id.car_add:
                num++;
                car_pirce.setText("价格：" + num * pirce);
                car_num.setText("" + num);
                total_Money = num * pirce;
                break;
            case R.id.car_delete:
                if (num > 1) {
                    num--;
                    car_pirce.setText("价格：" + num * pirce);
                    car_num.setText("" + num);
                } else if (num <= 0) {
                    num = 1;
                    car_pirce.setText("价格：" + num * pirce);
                    car_num.setText("" + num);
                }
                total_Money = num * pirce;
                break;
            case R.id.Submit_intent:
                total_ZD.setText("总价格："+ total_Money);
                break;
        }
    }
    private void initView() {
        tv_id = (TextView) findViewById(R.id.tv_id);
        pirce_id = (TextView) findViewById(R.id.pirce_id);
        sdv_id = (SimpleDraweeView) findViewById(R.id.sdv_id);
        add_car = (Button) findViewById(R.id.add_car);
        car_image = (SimpleDraweeView) findViewById(R.id.car_image);
        car_title = (TextView) findViewById(R.id.car_title);
        car_pirce = (TextView) findViewById(R.id.car_pirce);
        text_mes = (TextView) findViewById(R.id.text_mes);
        car_add = (Button) findViewById(R.id.car_add);
        car_num = (TextView) findViewById(R.id.car_num);
        car_delete = (Button) findViewById(R.id.car_delete);
        add_car.setOnClickListener(this);
        car_add.setOnClickListener(this);
        car_delete.setOnClickListener(this);
        Submit_intent = (Button) findViewById(R.id.Submit_intent);
        Submit_intent.setOnClickListener(this);
        total_ZD = (TextView) findViewById(R.id.total_ZD);
        total_ZD.setOnClickListener(this);
    }
}
