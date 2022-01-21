package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 *
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 */

class LFUCache {

    HashMap<Integer,Integer> keyToVal;
    HashMap<Integer,Integer> keyTofreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyTofreq = new HashMap<>();
        freqToKey = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        //1.return val
        //2.freq++
        //3.move the key which in the freq linked to freq+1 linked
        //4.if minFreq = freq, refresh minFreq
        if(capacity == 0 || !keyToVal.containsKey(key))
            return -1;
        refreshFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(capacity == 0)
            return;
        if(capacity == keyToVal.size() && !keyToVal.containsKey(key)){
            removeAKey();
        }
        if(!keyToVal.containsKey(key)){
            putNewKey(key,value);
            return;
        }else{
            keyToVal.put(key,value);
            refreshFreq(key);
        }
    }

    void putNewKey(int key,int value){
        minFreq = 1;
        keyToVal.put(key,value);
        keyTofreq.put(key,1);
        if(freqToKey.containsKey(1)){
            freqToKey.get(1).add(key);
        }else{
            LinkedHashSet<Integer> my = new LinkedHashSet<>();
            my.add(key);
            freqToKey.put(1,my);
        }
    }

    int removeAKey(){
        int keyremo = freqToKey.get(minFreq).iterator().next();
        keyToVal.remove(keyremo);
        keyTofreq.remove(keyremo);
        freqToKey.get(minFreq).remove(keyremo);
        if(freqToKey.get(minFreq).isEmpty()){
            freqToKey.remove(minFreq);
            minFreq++;
        }
        return keyremo;
    }

    /**
     * function:
     *  1.refresh keyFreq HashMap
     *  2.from freqToKey LinkedHashSet remove key
     *  3.update minFreq
     *  4.add the key to freq + 1 LinkedHashSet
     * @param key
     */
    void refreshFreq(int key){
        int myFreq = keyTofreq.get(key);
        keyTofreq.put(key,myFreq + 1);
        freqToKey.get(myFreq).remove(key);
        if(myFreq == minFreq && freqToKey.get(myFreq).isEmpty()){
            freqToKey.remove(myFreq);
            minFreq++;
        }
        if(freqToKey.containsKey(myFreq + 1)){
            freqToKey.get(myFreq+1).add(key);
        }else{
            LinkedHashSet<Integer> my = new LinkedHashSet<>();
            my.add(key);
            freqToKey.put(myFreq+1,my);
        }
    }
}
