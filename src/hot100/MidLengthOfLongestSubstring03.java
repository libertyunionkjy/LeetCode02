package hot100;

import java.util.HashSet;
import java.util.Set;

public class MidLengthOfLongestSubstring03 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = left;
        while ( right < s.length()){
            right = moveRight(s,right,set);
            // 左边界对应的右边界找到了，更新结果
            int tmp = right - left;
            res = tmp > res ? tmp : res;
            // 如果到了字符串末尾，就遍历完了
            if(right == s.length())
                return res;
            // 如果还没到末尾，就更新左边界
            left = moveLeft(s,left,s.charAt(right),set) + 1;
        }
        return res;
    }

    // 更新左边界，返回第一个重复字符的位置，新的左边界应该 + 1
    public int moveLeft(String s,int left,char c,Set<Character> set){
        while(s.charAt(left) != c){
            set.remove(s.charAt(left));
            left++;
        }
        set.remove(c);
        return left;
    }

    // 更新右边界，返回重复字符的位置或者字符串的末尾
    public int moveRight(String s,int right,Set<Character> set){
        while (right < s.length()){
            if(set.contains(s.charAt(right))){
                return right;
            }else{
                set.add(s.charAt(right));
                right++;
            }
        }
        return right;
    }
}
