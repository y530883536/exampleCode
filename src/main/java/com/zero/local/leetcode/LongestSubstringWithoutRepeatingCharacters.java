package com.zero.local.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
public class LongestSubstringWithoutRepeatingCharacters {

    public static int maxLength = 0;
    public static int index = 0;

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        for(int i=index;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                char c = s.charAt(j);
                boolean isSuccess = charSet.add(c);
                if(isSuccess){
                    maxLength ++;
                }else{
                    charSet = new HashSet<>();
                    break;
                }
            }
        }
        return maxLength;
    }
}
