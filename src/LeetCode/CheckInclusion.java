package LeetCode;

import java.util.HashMap;

public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(Character c : s1.toCharArray()){
            target.put(c,target.getOrDefault(c,0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (target.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0) + 1);
                if(window.get(c).intValue() == target.get(c).intValue())
                    valid++;
            }
            //System.out.print(right+", ");
            //System.out.println(left);
            while ((right - left) >= s1.length()) {
                if(valid == target.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if(target.containsKey(d)){
                    if(window.get(d).intValue() == target.get(d).intValue())
                        valid--;
                    window.put(d,window.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));
    }
}
