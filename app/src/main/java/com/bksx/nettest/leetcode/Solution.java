package com.bksx.nettest.leetcode;

import com.bksx.nettest.testpackage.HashMapUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    //    "pwwkew"
//    "abcabcbb"
    public int l0engthOfLongestSubstring(String s) {
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


    //    771. Jewels and Stones
//    Input: J = "aA", S = "aAAbbbb"
//    Output: 3
//    ascii:65-90,97-122
    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int output = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if ((c >=65 && c<=90) || (c>=97 && c<=122)){
                set.add(c);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (set.contains(c)){
                output++;
            }


        }

        return output;
    }
}