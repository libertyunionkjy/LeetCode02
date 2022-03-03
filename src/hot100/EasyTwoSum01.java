package hot100;

import java.util.HashMap;
import java.util.Map;

public class EasyTwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
