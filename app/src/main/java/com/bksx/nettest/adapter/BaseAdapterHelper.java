package com.bksx.nettest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/**
 * Created by try on 2018/5/8.
 */

public abstract class BaseAdapterHelper<T> extends BaseAdapter {
    List<T> list;
    LayoutInflater inflater;
    Context context;

    public BaseAdapterHelper(Context context,List<T> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract View getView(int position, View convertView, ViewGroup parent);

    public void addData(List<T> datas,boolean isClear){
        if (isClear) {
            this.list.clear();
        }
        this.list.addAll(datas);
        notifyDataSetChanged();
    }

}
