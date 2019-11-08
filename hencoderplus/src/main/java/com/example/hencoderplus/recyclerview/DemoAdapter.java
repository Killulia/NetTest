package com.example.hencoderplus.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hencoderplus.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private List<User> list;
    private Context context;
    private OnItemClickListener listner;
    /**
     * viewType--分别为item以及空view
     */
    private static final int VIEW_TYPE_ITEM = 1;
    private static final int VIEW_TYPE_EMPTY = 0;


    DemoAdapter(Context context, List<User> users) {
        this.context = context;
        this.list = users;
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        this.listner = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.size() == 0) {
            return VIEW_TYPE_EMPTY;
        }

        return VIEW_TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_EMPTY) {
            View emptyView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false);
            return new EmptyHolder(emptyView);
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        itemView.setOnClickListener(this);
        return new ListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListHolder) {
            User user = list.get(position);
            ListHolder listHolder = (ListHolder) holder;
            listHolder.tvName.setText(user.getName());
            listHolder.itemView.setTag(position);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (holder instanceof ListHolder) {
            if (payloads.isEmpty()) {
                onBindViewHolder(holder, position);
            } else {
                Bundle payload = (Bundle) payloads.get(0);
                ListHolder listHolder = (ListHolder) holder;
                listHolder.itemView.setTag(position);
                listHolder.tvName.setText(payload.getString("NAME"));
            }

        }
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 1;
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (listner != null) {
            listner.onItemClick(v, position);
        }
    }


    void setList(List<User> list) {
        this.list = list;
    }

    List<User> getData() {
        return this.list;
    }

    void refreshData(List<User> news) {
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new MyDiffCallback(this.list, news));
        this.list.clear();
        this.list.addAll(news);
        result.dispatchUpdatesTo(this);
    }

    public void insertOne(){
        User user = new User("000","新人");
        list.add(user);
        notifyItemInserted(0);
    }


        static class ListHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        ListHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item);
        }
    }

    static class EmptyHolder extends RecyclerView.ViewHolder {

        ImageView ivEmpty;

        EmptyHolder(@NonNull View itemView) {
            super(itemView);
            ivEmpty = itemView.findViewById(R.id.iv_empty);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
