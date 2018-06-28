package com.example.app_2.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class List_ViewFragment extends Fragment {


    private RecyclerView rv_view;

    public List_ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list__view, container, false);

        initView(view);
        rv_view.setItemViewCacheSize(10);
        return view;
    }

    private void initView(View view) {
        rv_view = (RecyclerView) view.findViewById(R.id.rv_view);
    }
}
