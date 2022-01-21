package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> target = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(Character c : p.toCharArray()){
            target.put(c,target.getOrDefault(c,0) + 1);
        }

        int left = 0,right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(target.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if(target.get(c).intValue() == window.get(c).intValue())
                    valid++;
            }

            while(right - left >= p.length()){
                if(valid == target.size()){
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if(target.containsKey(d)){
                    if(target.get(d).intValue() == window.get(d).intValue())
                        valid--;
                    window.put(d,window.getOrDefault(d,0) - 1);
                }
            }
        }
        return res;
    }
}
