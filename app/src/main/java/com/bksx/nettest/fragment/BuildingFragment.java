package com.bksx.nettest.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bksx.nettest.R;
import com.bksx.nettest.adapter.UnitAdapter;
import com.bksx.nettest.bean.Unit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BuildingFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Unbinder unbinder;
    @BindView(R.id.rv_unit)
    RecyclerView rvUnit;
    @BindView(R.id.iv_rc1)
    ImageView ivRc1;
    @BindView(R.id.iv_rc2)
    ImageView ivRc2;
    @BindView(R.id.iv_rc3)
    ImageView ivRc3;
    @BindView(R.id.iv_rc4)
    ImageView ivRc4;
    @BindView(R.id.iv_cr1)
    ImageView ivCr1;
    @BindView(R.id.iv_cr2)
    ImageView ivCr2;
    @BindView(R.id.iv_cr3)
    ImageView ivCr3;
    @BindView(R.id.flow)
    Flow flow;

    private String mParam1;
    private String mParam2;

    private UnitAdapter unitAdapter;
    private List<Unit> unitList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    private Drawable dwCircle;
    private Drawable dwRectangle;

    public BuildingFragment() {
    }


    public static BuildingFragment newInstance(String param1, String param2) {
        BuildingFragment fragment = new BuildingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_building, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            unitList.add(new Unit(i + 1 + "单元"));
        }
        unitAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        //单元列表
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        unitAdapter = new UnitAdapter(R.layout.item_unit, unitList);
        unitAdapter.setOnItemClickListener((adapter, view1, position) -> {
            //改变状态
            for (int i = 0; i < unitList.size(); i++) {
                if (i == position) {
                    unitList.get(i).setClick(true);
                } else {
                    unitList.get(i).setClick(false);
                }
            }
            unitAdapter.notifyDataSetChanged();


        });

        rvUnit.setLayoutManager(layoutManager);
        rvUnit.setAdapter(unitAdapter);

        //指示器颜色
        setIndicatorColor();

    }

    /*
    指示器颜色
     */
    private void setIndicatorColor() {
        ivRc1.setImageLevel(1);
        ivRc2.setImageLevel(2);
        ivRc3.setImageLevel(3);
        ivRc4.setImageLevel(4);
        ivCr1.setImageLevel(5);
        ivCr2.setImageLevel(6);
        ivCr3.setImageLevel(7);
    }
}
