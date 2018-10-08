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
import android.widget.Button;
import android.widget.TextView;

import com.example.myungger.myapplication.R;
import com.example.myungger.myapplication.activity.MainActivity;
import com.example.myungger.myapplication.activity.TotalTraining;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar_home);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        TextView textView = getActivity().findViewById(R.id.home_textView_totalTraining);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TotalTraining.class);
                startActivity(intent);
            }
        });
    }
}
