package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute46 {
    boolean[] flag;
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();


    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        this.flag = new boolean[len];

        dfs(nums);
        return res;
    }

    void dfs(int[] nums){
        // 到叶子结点
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            // 做出选择
            flag[i] = true;
            track.addLast(nums[i]);
            // 递归
            dfs(nums);
            // 回溯
            flag[i] = false;
            track.removeLast();
        }
        return;
    }


}
