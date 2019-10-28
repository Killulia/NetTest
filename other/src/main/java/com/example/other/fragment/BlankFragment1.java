package com.example.other.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.other.R;


public class BlankFragment1 extends Fragment {
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("ccg", "生命周期-Fragment-onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d("ccg", "生命周期-Fragment-onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("ccg", "生命周期-Fragment-onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("ccg", "生命周期-Fragment-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("ccg", "生命周期-Fragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("ccg", "生命周期-Fragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("ccg", "生命周期-Fragment-onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("ccg", "生命周期-Fragment-onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ccg", "生命周期-Fragment-onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("ccg", "生命周期-Fragment-onDetach");
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public BlankFragment1() {
        // Required empty public constructor
    }

    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("ccg", "生命周期-Fragment-onCreateView");
        return inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
    }

}
