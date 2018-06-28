package com.example.app_2.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app_2.MyService;
import com.example.app_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment implements View.OnClickListener {


    private Button start;
    private Button stop;
    private Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_, container, false);
        initView(view);
        intent = new Intent(getActivity(), MyService.class);
        return view;
    }

    private void initView(View view) {
        start = (Button) view.findViewById(R.id.start);
        stop = (Button) view.findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                getActivity().startService(intent);
                break;
            case R.id.stop:
                getActivity().stopService(intent);
                break;
        }
    }
}
