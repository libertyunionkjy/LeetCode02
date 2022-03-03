package hot100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSum01Test {

    @Test
    void twoSum() {
        EasyTwoSum01 test = new EasyTwoSum01();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(test.twoSum(nums,7)));
    }
}