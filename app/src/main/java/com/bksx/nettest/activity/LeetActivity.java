package com.bksx.nettest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.FanxingB;
import com.bksx.nettest.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

public class LeetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leet);
        int result = Solution.numJewelsInStones("aA","aAAbbbb ");
        Log.d("ccg", "result:" + result);



    }
//  "dvdf"
    public  int l0engthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        Map<Character,Integer> map=new HashMap<>();
        for(;start<n && end<n;end++){
            if(map.containsKey(s.charAt(end))){
                start=Math.max(map.get(s.charAt(end)),start);//从有重复的下一个位置继续找
            }
            map.put(s.charAt(end),end+1);//map每次更新
            res=Math.max(res,end-start+1);//结果每次更新
        }
        return res;



    }
}
