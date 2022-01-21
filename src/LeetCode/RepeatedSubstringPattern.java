package LeetCode;

import java.util.ArrayList;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        RepeatedSubstringPattern solution = new RepeatedSubstringPattern();
        System.out.println(solution.repeatedSubstringPattern("abac"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int size = s.length();
        for (int i = 1; i <= size / 2; i++) {
            if (size % i == 0) {
                String str1 = s.substring(0, i);
                int left = i, right = 2 * i;
                String str2 = s.substring(left, right);
                while (str1.equals(str2) && right <= size) {
                    left = left + i;
                    right = right + i;
                    if(right <= size)
                        str2 = s.substring(left, right);
                }
                if(right > size)
                    return true;
            }
        }
        return false;
    }
}
