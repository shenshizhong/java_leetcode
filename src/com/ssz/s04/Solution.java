package com.ssz.s04;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //方法1
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int preP = 0, max = 0;
        int[] hash = new int[256];      //初始化 256，因为所有的字符ASCII码加起来也就最多255个
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);       //获取单个字符
            if (hash[c] > preP) {       //将 ascii 码作为下标，对应的值默认是0
                preP = hash[c];
            }
            int l = i - preP + 1;      //为什么要加1 比如 aba，相当于 2-0+1
            hash[c] = i + 1;           //为什么要加1 因为默认 hash 数组中初始化值都是0，加1，作为区分
            if (l > max) max = l;
        }
        return max;
    }
//   方法1：这个相对好理解
//    public int lengthOfLongestSubstring(String s){
//        int i = 0, j = 0;
//        int max = 0;
//        Set<Character> set = new HashSet<>();
//        while (j < s.length()) {
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                max = Math.max(max, set.size());
//            } else {
//                set.remove(s.charAt(i++));   //只要有相同的就一直删除第一个，直到删除到没有相同的
//            }
//        }
//        return max;
//
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("Abcabcbb"));
    }
}