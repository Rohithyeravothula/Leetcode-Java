package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class KClosest {

    class Point{
        int x,y,d;
        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.d = Math.abs(x*x + y*y);
        }
    }

    class PointComparator implements Comparator<Point> {

        @Override
        public int compare(Point point, Point t1) {
            return t1.d - point.d;
        }
    }


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pqueue = new PriorityQueue<>(new PointComparator());
        for(int i=0;i<points.length;i++){
            Point p = new Point(points[i][0], points[i][1]);
            if(pqueue.isEmpty() || pqueue.size() < k || pqueue.peek().d > p.d){
                pqueue.add(p);
            }
            if(pqueue.size() > k){
                pqueue.poll();
            }
        }


        int[][] ans = new int[pqueue.size()][2];
        int i = 0;
        while(!pqueue.isEmpty()){
            Point p = pqueue.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] points = {{1,3}, {-2, 2}, {1,1}, {0,0}, {5,5}, {100, 1}};
//        int[][] points = {{2,2}, {2,2}, {1,1}};
        KClosest kc = new KClosest();
        int [][] ans = kc.kClosest(points, 3);
        for(int[] point: ans){
            System.out.println(point[0] + " " + point[1]);
        }
    }
}
