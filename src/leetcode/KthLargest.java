package leetcode;


import java.util.PriorityQueue;
import java.util.Arrays;

public class KthLargest {

    Integer k;
    PriorityQueue<Integer> pqueue;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pqueue = new PriorityQueue<>();
        for(int curnum: nums){
            pqueue.add(curnum);
        }
        while(pqueue.size() > k)
            pqueue.poll();
    }

    public int add(int val) {
        if(pqueue.size() < this.k)
            pqueue.add(val);
        else if(pqueue.peek() < val){
            pqueue.add(val);
            pqueue.poll();
        }
        return pqueue.peek();
    }

    public static void main(String[] args) {
        int[] a = {2,5,2,3,5,1,2,8,9,21,2,1,42,89};
        int[] b = {2,5,2,3,5,1,2,8,9,21,2,1,42,89};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        KthLargest kl = new KthLargest(3, a);
        System.out.println(kl.add(0));
    }
}
