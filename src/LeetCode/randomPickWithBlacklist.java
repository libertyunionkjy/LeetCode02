package LeetCode;

import java.util.*;

/**
 * LeetCode.710
 * https://leetcode-cn.com/problems/random-pick-with-blacklist/
 */
class Solution {
    Random rand;
    int effNum;
    HashMap<Integer,Integer> data;
    public Solution(int n, int[] blacklist) {
        this.effNum = n - blacklist.length;
        data = new HashMap<>();
        rand = new Random();

        HashSet<Integer> trailWhite = new HashSet<>();
        for (int i = effNum; i < n; i++) {
            trailWhite.add(i);
        }
        for(int i : blacklist){
            trailWhite.remove(i);
        }
        Iterator<Integer> it = trailWhite.iterator();
        for(int i : blacklist){
            if(i < effNum){
                data.put(i,it.next());
            }
        }
    }

    public int pick() {
        int k = rand.nextInt(effNum);
        return data.getOrDefault(k,k);
    }
}

