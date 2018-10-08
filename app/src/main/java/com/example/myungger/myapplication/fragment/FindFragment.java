package com.example.myungger.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myungger.myapplication.R;
import com.example.myungger.myapplication.activity.AllClass;
import com.example.myungger.myapplication.activity.Coach;
import com.example.myungger.myapplication.activity.Eric;
import com.example.myungger.myapplication.activity.MainActivity;

public class FindFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.find, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar_find);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        ImageView imageView = getActivity().findViewById(R.id.imageView_all_class);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllClass.class));
            }
        });

        ImageView imageView1 = getActivity().findViewById(R.id.imageView_coach);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Coach.class));
            }
        });

        TextView textView1 = getActivity().findViewById(R.id.textView2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllClass.class));
            }
        });

        TextView textView2 = getActivity().findViewById(R.id.textView4);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Coach.class));
            }
        });
    }
}
