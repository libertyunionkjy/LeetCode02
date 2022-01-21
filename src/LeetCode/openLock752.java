package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class openLock752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>();
        for (String str :
                deadends) {
            deadend.add(str);
        }
        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int steps = 0;
        visit.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (deadend.contains(cur)) continue;
                if(target.equals(cur)) return steps;

                for (int j = 0; j < 4; j++) {
                    String plusStr = plus(cur, j);
                    String reduStr = reduce(cur, j);
                    if (!visit.contains(plusStr)) {
                        queue.offer(plusStr);
                        visit.add(plusStr);
                    }
                    if (!visit.contains(reduStr)) {
                        queue.offer(reduStr);
                        visit.add(reduStr);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private String plus(String str,int j){
        char[] ch = str.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        }else{
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String reduce(String str,int j){
        char[] ch = str.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        }else{
            ch[j] -= 1;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(new openLock752().openLock(deadends,target));
    }
}
