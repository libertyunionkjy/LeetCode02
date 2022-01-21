package LeetCode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> window = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0) + 1);
            if(window.get(c).intValue() == 1){
                res = right - left > res ? right - left : res;
            }
            while(window.get(c).intValue() != 1){
                char d = s.charAt(left);
                left++;
                window.put(d,window.get(d) - 1);
            }
        }
        return res;
    }
}
