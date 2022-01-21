package LeetCode;

import java.util.*;

/**
 * LeetCode.380
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */
class RandomizedSet {
    List<Integer> data;
    HashMap<Integer,Integer> valToIndex;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.data = new ArrayList<>();
        this.valToIndex = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)){
            return false;
        }else{
            data.add(val);
            valToIndex.put(val,data.size() - 1);
        }
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)){
            return false;
        }else{
            int index = valToIndex.get(val);
            int trailData = data.get(data.size() - 1);
            data.set(index,trailData);
            valToIndex.put(trailData,index);
            data.remove(data.size() - 1);
            valToIndex.remove(val);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(rand.nextInt(data.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
