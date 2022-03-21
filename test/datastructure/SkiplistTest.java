package datastructure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkiplistTest {

    @Test
    void randomLevel() {
    }

    @Test
    void add() {
    }

    @Test
    void erase() {
    }

    @Test
    void search() {
        String opts = "Skiplist,add,add,add,add,add,add,add,add,add,add,add,search,search,erase,erase,add,search,erase,search,search,add,search,add,erase,erase,add,erase,erase,erase,search,search,erase,erase,erase,search,add,add,add,add,erase,erase,add,add,erase,erase,erase,search,search,add,add,erase,erase,search,add,search,search,search,search,search,search,search,search,search,search,search,search";
        String nums =  "-1,3,14,3,18,1,18,17,8,5,16,3,10,9,14,13,18,11,16,1,4,7,0,5,12,11,20,17,2,1,4,17,12,1,20,7,6,21,2,13,16,17,6,5,10,13,10,17,0,1,8,7,4,15,14,13,0,13,0,19,18,1,20,15,0,21,18";
        String str1 = "null,null,null,null,null,null,null,null,null,null,null,null,false,false,true,false,null,false,true,true,false,null,false,null,false,false,null,true,false,true,false,false,false,false,true,true,null,null,null,null,false,false,null,null,false,true,false,false,false,null,null,true,false,false,null,false,false,false,false,false,true,true,false,false,false,false,true";
        String str2 = "null,null,null,null,null,null,null,null,null,null,null,null,false,false,true,false,null,false,true,true,false,null,false,null,false,false,null,true,false,true,false,false,false,false,true,true,null,null,null,null,false,false,null,null,false,true,false,false,false,null,null,true,false,false,null,false,false,false,false,false,true,true,false,false,false,true,true";
        String[] opt = opts.split(",");
        System.out.println(opt.length);
        String[] num = nums.split(",");
        System.out.println(num.length);
        String[] strArr1 = str1.split(",");
        System.out.println(strArr1.length);
        String[] strArr2 = str2.split(",");
        System.out.println(strArr2.length);


        Skiplist test = new Skiplist();

        for (int i = 0; i < num.length; i++) {
            String tmpOpt = opt[i];
            int tmpNum = Integer.parseInt(num[i]);

            if (tmpOpt.equalsIgnoreCase("Skiplist")) continue;
            else if (opt[i].equalsIgnoreCase("add")) {
                test.add(tmpNum);
            } else if (opt[i].equalsIgnoreCase("erase")) {
                test.erase(tmpNum);
            } else if (opt[i].equalsIgnoreCase("search")) {
                if(tmpNum == 21) {
                    test.printAll();
                    System.out.println(test.search(tmpNum));
                    continue;
                }
                test.search(tmpNum);
            }
        }

    }

    @Test
    void skiplist(){
        String[] opts = {"Skiplist","add","add","add","add","add","add","add","add","add","erase","search","add","erase","erase","erase","add","search","search","search","erase","search","add","add","add",
                "erase","search","add","search","erase","search","search","erase","erase","add","erase","search","erase","erase","search","add","add","erase","erase","erase","add","erase","add","erase","erase",
                "add","add","add","search","search","add","erase","search","add","add","search","add","search","erase","erase","search","search","erase","search","add","erase","search","erase","search","erase",
                "erase","search","search","add","add","add","add","search","search","search","search","search","search","search","search","search"};
        String in = "[[],[16],[5],[14],[13],[0],[3],[12],[9],[12],[3],[6],[7],[0],[1],[10],[5],[12],[7],[16],[7],[0],[9],[16],[3],[2],[17],[2],[17],[0],[9],[14],[1],[6],[1],[16],[9],[10],[9],[2],[3],[16],[15]," +
                "[12],[7],[4],[3],[2],[1],[14],[13],[12],[3],[6],[17],[2],[3],[14],[11],[0],[13],[2],[1],[10],[17],[0],[5],[8],[9],[8],[11],[10],[11],[10],[9],[8],[15],[14],[1],[6],[17],[16],[13],[4],[5],[4],[17],[16],[7],[14],[1]]";

        String myout = "null,null,null,null,null,null,null,null,null,null,true,false,null,true,false,false,null,true,true,true,true,false,null,null,null,false,false,null,false,false,true,true,false,false,null,true,true,false,true,true,null,null," +
                "false,true,false,null,true,null,true,true,null,null,null,false,false,null,true,false,null,null,true,null,false,false,false,true,true,false,false,null,true,false,false,false,false,true,false,false,null,null,null,null,true,true,true," +
                "true,true,true,false,false,true";

        String stdout = "[null,null,null,null,null,null,null,null,null,null,true,false,null,true,false,false,null,true,true,true,true,false,null,null,null,false,false,null,false,false,true,true,false,false,null,true,true,false,true,true,null,null," +
                "false,true,false,null,true,null,true,true,null,null,null,false,false,null,true,false,null,null,true,null,false,false,false,true,true,false,true,null,true,false,false,false,true,true,false,false,null,null,null,null,true,true,true," +
                "true,true,true,false,false,true";

        List<Integer> get = new ArrayList<>();
        get.add(0);
        int sum = 0;
        for (int i = 0; i < in.length(); i++) {
            if(!(in.charAt(i) >= '0' && in.charAt(i) <= '9')){
                continue;
            }else {
                sum = 0;
                while (in.charAt(i) >= '0' && in.charAt(i) <= '9'){
                    sum = sum * 10 + (in.charAt(i) - '0');
                    i++;
                }
                get.add(sum);
            }
        }



        String[] my = myout.split(",");
        String[] std = stdout.split(",");

        Skiplist test = new Skiplist();

        for (int i = 0; i < opts.length; i++) {
            String opt = opts[i];
            if (opt.equalsIgnoreCase("Skiplist")) continue;
            else if (opt.equalsIgnoreCase("add")) {
                test.add(get.get(i));
            } else if (opt.equalsIgnoreCase("erase")) {
                test.erase(get.get(i));
            } else if (opt.equalsIgnoreCase("search")) {
                test.search(get.get(i));
            }

            if (get.get(i) == 9) {
                System.out.println(opt);
            }

            if (!my[i].equalsIgnoreCase(std[i])) {
                System.out.println("对应的i为:   " + i);
                System.out.println("对应的操作为:   " + opts[i]);
                System.out.println("对应的操作数为:   " + get.get(i));
                System.out.println(my[i]);
                System.out.println(std[i]);
                test.printAll();
                System.out.println("=====================");
            }
        }

    }
}