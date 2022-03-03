package hot100;

import org.junit.jupiter.api.Test;

class LengthOfLongestSubstring03Test {

    @Test
    void lengthOfLongestSubstring() {
        MidLengthOfLongestSubstring03 test = new MidLengthOfLongestSubstring03();
        String s = "abcabc";
        System.out.println(test.lengthOfLongestSubstring(s));
    }

}