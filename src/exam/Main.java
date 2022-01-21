package exam;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input.next());
        }
        int i = 0;
        for(String s : set){
            System.out.print(s);
            if (i < n - 1) {
                System.out.print(" ");
            }
            i++;
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Task("task1"));
        executor.submit(new Task("task2"));
        executor.submit(new Task("task3"));
        executor.shutdown();
    }

}
class Task implements Runnable{
    private final String name;
    Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start " + name);
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
        }
        System.out.println("end task " + name);
    }
}
