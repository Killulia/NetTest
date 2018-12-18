package com.bksx.nettest.leetcode;

class Solution {

//    "pwwkew"
//    "abcabcbb"
public int l0engthOfLongestSubstring(String s) {
    int result = 1;
    int resultTemp = 1;
    int start = 0;
    int end = 1;
    if (s.length() > 1) {
        for (int i = start; i < s.length()-1; i++) {
            String temp = s.substring(start, end);
            if (!temp.contains(String.valueOf(s.charAt(i + 1)))) {
                resultTemp++;
                end++;
            } else {
                start = end;
                end = start + 1;
                resultTemp = 1;

            }
            if (resultTemp > result) {
                result = resultTemp;
            }
        }
    }

    return result;

}
}