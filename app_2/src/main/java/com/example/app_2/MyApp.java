package com.example.app_2;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Misaya on 2018/6/26.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        //设置输出日志
        x.Ext.setDebug(true);
    }
}
