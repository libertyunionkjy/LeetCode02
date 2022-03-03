package leetcode;

import LeetCode.LongestValidParentheses32;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParentheses32Test {

    @Test
    void longestValidParentheses()
    {
        String s = "())";
        LongestValidParentheses32 test = new LongestValidParentheses32();
        System.out.println(test.longestValidParentheses(s));
    }
}