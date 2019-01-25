package com.bksx.nettest.leetcode;

import android.util.Log;
import android.widget.Toast;

import com.bksx.nettest.testpackage.HashMapUtil;

import java.math.BigInteger;
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

    //字符串转换整数 (atoi)
    public static int myAtoi(String str) {
//        boolean flag = false;
//        BigInteger result = BigInteger.valueOf(0);
//        int count = 0;
//        if (str.trim().length()==0){
//            return 0;
//        }
//
//        if (str.trim().length()==1){
//
//            if ((str.trim().charAt(0)==45) || (str.trim().charAt(0)==43)){
//                return 0;
//            }
//
//        }
//
//        //1
//        if ((str.trim().charAt(0)!=45) && (str.trim().charAt(0)!=43) && (!(str.trim().charAt(0)>=48 && str.trim().charAt(0)<=57))){
//            Log.d("ccg", "1 ");
//            Log.d("ccg", "[0]:"+str.trim().charAt(0));
//            return 0;
//        }
//        //2
//        String test = str.trim();
//        for (int i = 0; i < test.length(); i++) {
//            Log.d("ccg", "2");
//            if (count>1){
//                return 0;
//            }
//            char c = test.charAt(i);
//            if (!(c>=48 && c<=57) && (c!=45) && (c!=43)){
//                flag = true;
//                String sub = test.substring(0,i);
//                Log.d("ccg", "sub:"+sub);
//                BigInteger bigInteger = new BigInteger(sub);
//                result = bigInteger;
//                break;
//            }else if (c==45 || c==43){
//                count++;
//            }
//
//        }
//
//
//
//        //3
//        if (!flag){
//            result =  new BigInteger(test);
//        }
//        if (result.intValue() > Integer.MAX_VALUE){
//            return Integer.MAX_VALUE;
//        }
//        if (result .intValue()< Integer.MIN_VALUE){
//            return Integer.MIN_VALUE;
//        }
//
//        return  Integer.valueOf(result.toString());
        if(str.isEmpty())
            return 0;
        int flag =1,i=0;
        long result = 0;
        //判断空字符的个数，并且确定空字符结束的位置
        while(i < str.length() && str.charAt(i) == ' ')
            i++;
        //如果统计的空字符个数与字符串长度相同，则判断为这个空字符，不能转换
        if(i == str.length())
            return 0;
        //由于上面是i++，所以此时i为空字符之后的第一个非空字符的索引值，此位置判断为
        //flag为正还是负的位置，并分别赋值
        if (str.charAt(i) == '+' || str.charAt(i) == '-'){
            flag = str.charAt(i)=='+'? 1 : -1;
            i++;
        }
        //过去这符号位之后，应该是判断是否是数字字符，如果不是则不会执行下面的for循环，
        //并且下一位不是数字则其不会再进行while循环
        while(i < str.length() && str.charAt(i) >= '0'&& str.charAt(i)<='9'){
            result = 10 * result + (str.charAt(i++) -'0');
            //判断是否发生了溢出，超出了所给的位置
            if(result > Integer.MAX_VALUE){
                return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return Integer.parseInt(String.valueOf(result * flag));


    }


}