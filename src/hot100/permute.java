package hot100;

import java.util.LinkedList;
import java.util.List;

public class permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> trace = new LinkedList<>();
        backtrace(res, nums, trace);
        return res;
    }

    public void backtrace(List<List<Integer>> res, int[] nums, LinkedList<Integer> trace) {
        if(trace.size() == nums.length){
            res.add(new LinkedList<>(trace));
            return;
        }
        for (int i : nums) {
            if (trace.contains(i))
                continue;
            trace.add(i);
            backtrace(res,nums,trace);
            trace.removeLast();
        }
    }
}
