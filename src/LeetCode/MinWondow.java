package LeetCode;

import java.util.HashMap;

/**
 * url:https://leetcode-cn.com/problems/minimum-window-substring/
 * tag：滑动窗口
 *
 * //注意target中是可能重复的
 * //left,right   左闭右开
 * //hashmap<Character,Integer> window,target
 * //valid
 * //right++:
 * //          1.right  target中没有
 * //          2.target中有但是window中已经有了
 * //          3.target中有且window中还没有--->valid++
 * //valid等于target.size结束
 * //left++:
 * //          1.target中没有
 * //          2.target中有但是window中还有
 * //          3.target中有且window中没有了--->更新结果, valid--
 * //valid--后结束
 * //特殊情况：
 * //1.如果right到头了但是找不到匹配的
 *
 * 坑：Integer比较要使用equals方法(https://www.jianshu.com/p/9cb9c61b0986)
 * 资源：阿里巴巴开发手册(https://developer.aliyun.com/special/tech-java)
 */

public class MinWondow {
    public String minWindow(String s, String t) {
        if(t.length() == 0){
            return "";
        }

        int left = 0, right = 1;
        int valid = 0;
        //初始化target
        HashMap<Character,Integer> target = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(Character c : t.toCharArray()){
            if(target.containsKey(c)){
                target.put(c,target.get(c) + 1);
            }else{
                target.put(c,1);
            }
        }

        int sourceSize = s.length();
        int targetSize = target.size();
        String res = "";
        while(right <= sourceSize){
            //滑动右指针
            while(valid != targetSize && right <= sourceSize){
                char sChar = s.charAt(right - 1);
                if(!target.containsKey(sChar)){
                    right++;
                    continue;
                }else if(target.containsKey(sChar)){
                    if(!window.containsKey(sChar)){
                        window.put(sChar,1);
                    }else if(window.containsKey(sChar)){
                        window.put(sChar,window.get(sChar) + 1);
                    }

                    if(target.get(sChar).equals(window.get(sChar))){
                        valid++;
                    }
                }
                right++;
            }
            //滑动左指针
            String tmp = "";
            while(valid == targetSize){
                char sChar = s.charAt(left);
                if(!target.containsKey(sChar)){
                    left++;
                    continue;
                }else if(target.containsKey(sChar)){
                    if(window.get(sChar) > target.get(sChar)){
                        window.put(sChar,window.get(sChar) - 1);
                    }else if(window.get(sChar).equals(target.get(sChar))){
                        valid--;
                        tmp = s.substring(left,right - 1);
                        if(window.get(sChar) > 1){
                            window.put(sChar,window.get(sChar) - 1);
                        }else{
                            window.remove(sChar);
                        }
                    }
                }
                left++;
            }
            //更新结果
            if(tmp.length() == 0){
                return res;
            }else if(res.length() == 0 && tmp.length() != 0){
                res = tmp;
            }else if(res.length() != 0 && tmp.length() != 0){
                res = tmp.length() < res.length() ? tmp : res;
            }
        }
        return res;
    }
}
