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

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    public BlankFragment2() {
        // Required empty public constructor
    }

    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("ccg", "生命周期-Fragment2-onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d("ccg", "生命周期-Fragment2-onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("ccg", "生命周期-Fragment2-onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("ccg", "生命周期-Fragment2-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("ccg", "生命周期-Fragment2-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("ccg", "生命周期-Fragment2-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("ccg", "生命周期-Fragment2-onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("ccg", "生命周期-Fragment2-onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ccg", "生命周期-Fragment2-onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("ccg", "生命周期-Fragment2-onDetach");
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("ccg", "生命周期-Fragment2-onCreateView");
        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }

}
