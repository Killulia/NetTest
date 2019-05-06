package com.example.artexploration.part12.adapter;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.example.artexploration.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.RequiresApi;

public class ImageAdapter extends BaseAdapter {

    List<String> urls;

    Context context;

    LayoutInflater inflater;
    private boolean isGridviewable = false;


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
    public String getItem(int position) {
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_grid, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.img_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        ImageView imageView = holder.imageView;
//        final String tag = (String) imageView.getTag();
//        final String uri = getItem(position);
//        if (!uri.equals(tag)){
//            holder.imageView.setImageResource(R.mipmap.ic_launcher);
//        }
//        if (isGridviewable) {
//            Log.d("ccg", "静止，加载图片工作");
//            imageView.setTag(uri);
            Picasso.get().load(urls.get(position)).into(holder.imageView);

//        }
        return convertView;
    }

    public void notiAble(boolean able) {
        isGridviewable = able;
    }


    static class ViewHolder {
        ImageView imageView;

    }
}
