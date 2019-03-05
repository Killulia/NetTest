package com.example.artexploration.part12.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import java.util.List;

public class ImageAdapter extends BaseAdapter {

    List<String> urls;

    Context context;

    LayoutInflater inflater;

    public ImageAdapter(List<String> urls, Context context) {
        this.urls = urls;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int position) {
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
        }
        return null;
    }

   static class ViewHolder{
        ImageView imageView;

    }
}
