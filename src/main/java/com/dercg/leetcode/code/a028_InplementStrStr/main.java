package com.dercg.leetcode.code.a028_InplementStrStr;

public class main {
    /**
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */
    public static void main(String[] args) {
        System.out.println("-->" + strStr("a", ""));
        System.out.println("-->" + strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }

        if (haystack == null || "".equals(haystack)) {
            return -1;
        }

        int hayIndex = 0, needIndex = 0, startIndex = -1;
        while (hayIndex < haystack.length()) {
            if (haystack.charAt(hayIndex) == needle.charAt(needIndex)) {
                if (startIndex == -1) startIndex = hayIndex;
                needIndex++;
            } else {
                if (startIndex != -1) {
                    hayIndex = startIndex;
                    startIndex = -1;
                    needIndex = 0;
                }
            }
            if (needIndex == needle.length()) {
                return startIndex;
            }
            hayIndex++;
        }

        return -1;
    }
}
