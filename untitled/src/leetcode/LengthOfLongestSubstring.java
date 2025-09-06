package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s.length() <= 1)
            return s.length();
       String temp="";
        for (int i=0;i<s.length();i++){
            if(temp.indexOf(s.charAt(i))>=0){
                res=Math.max(res,temp.length());
                temp=temp.substring(temp.indexOf(s.charAt(i))+1);
                --i;
            }else {
                temp+=s.charAt(i);
            }
        }
        return Math.max(res,temp.length());
    }
}
