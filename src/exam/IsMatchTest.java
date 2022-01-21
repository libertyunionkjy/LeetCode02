package exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsMatchTest {

    @Test
    void isMatch() {
        IsMatch test = new IsMatch();
        String s = "aab";
        String p = "c*a*b";
        System.out.printf("result = "+test.isMatch(s,p));
    }

    @Test
    void match() {
        IsMatch test = new IsMatch();
        String s = "abcdddd";
        String p = "abc.*";
        test.match(s,p,0,0);
        System.out.printf("result = "+test.match(s,p,4,4));
    }
}