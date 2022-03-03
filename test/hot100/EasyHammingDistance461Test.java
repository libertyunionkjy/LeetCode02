package hot100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EasyHammingDistance461Test {

    @Test
    void hammingDistance() {
        EasyHammingDistance461 test = new EasyHammingDistance461();
        int x = 1;
        int y = 4;
        System.out.println(test.hammingDistance(x,y));
    }
}