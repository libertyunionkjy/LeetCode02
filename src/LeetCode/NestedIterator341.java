package LeetCode;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }

public class NestedIterator341 {
    public class NestedIteratorBFS implements Iterator<Integer> {
        private Iterator<Integer> it;
        public NestedIteratorBFS(List<NestedInteger> nestedList) {
            List<Integer> res = new ArrayList<>();
            for(NestedInteger ne : nestedList){
                traverse(ne,res);
            }
            this.it = res.listIterator();
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        void traverse(NestedInteger nesdInt, List<Integer> res){
            if(nesdInt.isInteger()){
                res.add(nesdInt.getInteger());
            }else{
                for(NestedInteger ne : nesdInt.getList()){
                    traverse(ne,res);
                }
            }
        }
    }

    /**
     * 优化
     */
}
class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> element;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.element = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return element.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!element.isEmpty() && !element.get(0).isInteger()){
             List<NestedInteger> first = element.getFirst().getList();
             element.removeFirst();
            for (int i = first.size() - 1; i >= 0 ; i--) {
                element.addFirst(first.get(i));
            }
        }
        return !element.isEmpty();
    }
}
