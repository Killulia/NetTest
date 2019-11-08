package com.example.hencoderplus.recyclerview;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class MyDiffCallback extends DiffUtil.Callback {

    private List<User> oldUsers;
    private List<User> newUsers;

    public MyDiffCallback(List<User> oldUsers, List<User> newUsers) {
        this.oldUsers = oldUsers;
        this.newUsers = newUsers;
    }

    @Override
    public int getOldListSize() {
        return oldUsers!=null?oldUsers.size():0;
    }

    @Override
    public int getNewListSize() {
        return newUsers!=null?newUsers.size():0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        User oldUser = oldUsers.get(oldItemPosition);
        User newUser = newUsers.get(newItemPosition);
        return oldUser.getId().equals(newUser.getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        User oldUser = oldUsers.get(oldItemPosition);
        User newUser = newUsers.get(newItemPosition);
        Log.d("ccg", "areContentsTheSame");
        Log.d("ccg", "old name:"+oldUser.getName());
        Log.d("ccg", "new name:"+newUser.getName());
        return oldUser.getName().equals(newUser.getName());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Log.d("ccg", "getChangePayload");
        User oldUser = oldUsers.get(oldItemPosition);
        User newUser = newUsers.get(newItemPosition);
        Bundle payload = new Bundle();
        if (!oldUser.getName().equals(newUser.getName())){
            payload.putString("NAME",newUser.getName());
        }
        if (payload.size() == 0)//如果没有变化 就传空
            return null;
        return payload;
    }
}
