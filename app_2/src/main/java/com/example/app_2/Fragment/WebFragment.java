package com.example.app_2.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.app_2.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment implements View.OnClickListener {
    private Button but_id;
    private Button but_id_02;
    private ProgressBar pb_id;
    private String apkUrl = "http://softfile.3g.qq.com:8080/msoft/179/24659/43549/qq_hd_mini_1.4.apk";
    //sd卡中存储的名称
    private String apkName = "hello.apk";

    //是否可以取消的任务 -- 网络请求数据的返回类型
    private Callback.Cancelable cancelable;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        initView(view);
        x.view().inject(getActivity());
        return view;
    }

    private void initView(View view) {
        but_id = (Button) view.findViewById(R.id.but_id);
        but_id_02 = (Button) view.findViewById(R.id.but_id_02);
        pb_id = (ProgressBar) view.findViewById(R.id.pb_id);

        but_id.setOnClickListener(this);
        but_id_02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_id:
                RequestParams params = new RequestParams(apkUrl);
                params.setAutoRename(true);
                String filePath = getActivity().getExternalCacheDir()+ File.separator + apkName;//..../hello.apk
                params.setSaveFilePath(filePath);
                cancelable = x.http().get(params, new Callback.ProgressCallback<File>() {
                    @Override
                    public void onSuccess(File result) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.fromFile(result),"application/vnd.android.package-archive");
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(intent);
                    }
                    @Override
                    public void onWaiting() {

                    }

                    @Override
                    public void onStarted() {

                    }

                    @Override
                    public void onLoading(long total, long current, boolean isDownloading) {

                    }



                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
                break;
            case R.id.but_id_02:
                cancelable.cancel();
                break;
        }
    }
}
