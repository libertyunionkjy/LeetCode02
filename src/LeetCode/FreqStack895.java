package LeetCode;

import java.util.*;

/**
 * 实现push:
 * 1.元素到频率的映射
 * HashMap<Integer,Integer>
 * 2.记录入栈的顺序
 * <p>
 * 实现pop
 * 1.要有频率到元素的映射，Map
 * 2.要能一下子找到频率最高的元素，TreeMap
 * 3.HashMap<Integer,Stack<Integer>>
 * 4.如果频率最高的元素有多个，那么应该弹出最近使用的
 */

public class FreqStack895 {
    int maxFreq;
    HashMap<Integer, Integer> valToFreq;
    HashMap<Integer, Deque<Integer>> freqToVal;

    public FreqStack895() {
        valToFreq = new HashMap<>();
        maxFreq = 0;
        freqToVal = new HashMap<>();
    }

    public void push(int val) {
        if (!valToFreq.containsKey(val)) {
            if (maxFreq == 0) {
                maxFreq = 1;
                freqToVal.put(1, new ArrayDeque<>());
            }
            valToFreq.put(val, 1);
            freqToVal.get(1).push(val);
        } else if (valToFreq.containsKey(val)) {
            int freq = valToFreq.get(val);
            if (freq == maxFreq) {
                maxFreq++;
                freqToVal.put(freq + 1, new ArrayDeque<>());
            }
            freqToVal.get(freq + 1).push(val);
            valToFreq.put(val, freq + 1);
        }
    }

    public int pop() {
        int val = freqToVal.get(maxFreq).pop();
        if(freqToVal.get(maxFreq).isEmpty()){
            freqToVal.remove(maxFreq);
            maxFreq--;
        }
        valToFreq.put(val,valToFreq.get(val) - 1);
        return val;
    }
}
