package com.bksx.nettest.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bksx.nettest.R;
import com.bksx.nettest.algorithm.Effection;
import com.bksx.nettest.bean.FanxingB;
import com.bksx.nettest.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class LeetActivity extends AppCompatActivity {

    int[] nums = {2,4,3,5,1,8,6};
    private String[] permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leet);
//        int result = Solution.numJewelsInStones("aA","aAAbbbb ");
//        int result = Solution.myAtoi("20000000000000000000");
//        Log.d("ccg", "result:" + result);
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        Effection.binarySerach(nums,6);
        checkPermissions();


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

    private void checkPermissions() {
        permissions = new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_SMS,
                Manifest.permission.INSTALL_SHORTCUT,
                Manifest.permission.MODIFY_AUDIO_SETTINGS

        };

        for (String permission : permissions) {
            int isGranted = ContextCompat.checkSelfPermission(this,permission);
            if (isGranted == PackageManager.PERMISSION_GRANTED){
                Log.d("ccg", permission+ "已授权");
            }else if (isGranted== PackageManager.PERMISSION_DENIED){
                Log.d("ccg", permission+ "未授权");
            }
        }
    }
}
