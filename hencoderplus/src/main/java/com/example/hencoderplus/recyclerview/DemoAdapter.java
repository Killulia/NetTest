package com.example.hencoderplus.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hencoderplus.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private ArrayList<User> list = new ArrayList<>() ;
    private Context context;
    private OnItemClickListner listner;
    /**
     * viewType--分别为item以及空view
     */
    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;



    {

//        list.addAll(DataFactory.list);
    }

    public DemoAdapter(Context context) {
        this.context = context;
    }

    public void setOnItemClickListner(OnItemClickListner listner) {
        this.listner = listner;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.size() == 0 ){
            Log.d("ccg", "size = 0");
            return VIEW_TYPE_EMPTY;
        }

        return VIEW_TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_EMPTY){
            View emptyView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false);
            Log.d("ccg", "VIEW_TYPE_EMPTY");
            return new EmptyHolder(emptyView);
        }
        Log.d("ccg", "VIEW_TYPE_ITEM");
        View itmeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        itmeView.setOnClickListener(this);
        return new ListHolder(itmeView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListHolder){
            User user = list.get(position);
            ListHolder listHolder = (ListHolder) holder;
           listHolder.tvName.setText(user.getName());
           listHolder.itemView.setTag(position);
        }
        Log.d("ccg", "onBindViewHolder");

    }

    @Override
    public int getItemCount() {
        Log.d("ccg", "size:");
        return list.size() > 0 ? list.size() : 1;
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (listner!=null){
            listner.onItemClick(v,position);
        }
    }

    public void insertOne(){
        User user = new User("new");
        list.add(user);
        notifyItemInserted(list.size());
    }

    static class ListHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item);
        }
    }

    static class EmptyHolder extends RecyclerView.ViewHolder{

        ImageView ivEmpty;

        public EmptyHolder(@NonNull View itemView) {
            super(itemView);
            ivEmpty = itemView.findViewById(R.id.iv_empty);
        }
    }

    public interface OnItemClickListner{
        void onItemClick(View view,int position);
    }
}
