package leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
public class Contest128 {
    public int bitwiseComplement(int n) {
        if(n==0)
            return 1;
        StringBuffer sb = new StringBuffer();
        while(n > 0){
            sb.append(1-(n%2));
            n = n >> 1;
        }
        sb = sb.reverse();
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void testp1(String[] args) {
        Contest128 ct = new Contest128();
        System.out.println(ct.bitwiseComplement(0));
    }

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> counter = new HashMap<>();
        int totaltime, ans = 0;
        for(int curtime: time){
            totaltime = 60-curtime;
            while(totaltime < 501){
                if(counter.containsKey(totaltime)){
                    ans+=counter.get(totaltime);
                }
                totaltime+=60;
            }
            int curcount = 1;
            if(counter.containsKey(curtime)){
                curcount = 1+counter.get(curtime);
            }
            counter.put(curtime, curcount);
        }
        return ans;
    }

    public static void testp2(String[] args) {
//        int[] a = {1,2,3};
//        int[] a = {60};
//        int[] a = {60, 60, 60};
        int[] a = {30,20,150,100,40};
        Contest128 ct = new Contest128();
        System.out.println(ct.numPairsDivisibleBy60(a));
    }

    public int countDays(int[] weights, int d){
        int ans = 0;
        int i=0,l=weights.length;
        while(i<l){
            int capacity = d;
            while(i<l){
                if(weights[i] > capacity){
                    break;
                }
                capacity -= weights[i];
                i++;
            }
            ans++;
        }
        return ans;
    }

    public int shipWithinDays(int[] weights, int d) {
        int l = weights.length;
        int minCap=0, maxCap=0;
        for(int curval: weights){
            maxCap += curval;
            minCap = Math.max(curval, minCap);
        }

        if(l == d)
            return minCap;

        int ans = maxCap;
        while(minCap <= maxCap){
            System.out.println(minCap + " " + maxCap);
            int midCap = (minCap + maxCap)/2;
            int days = countDays(weights, midCap);
            if(days > d){
                minCap = midCap+1;
            }
            else if(days <= d){
                ans = Math.min(ans, midCap);
                maxCap = midCap-1;
            }
        }
        return ans;
    }

    public static void testp3(String[] args) {
//        int[] a = {1,2,3,4,5,6,7,8,9,10};
//        int[] a = {3,2,2,4,1,4};
        int[] a = {1,2,3,1,1};
        Contest128 ct = new Contest128();
        System.out.println(ct.shipWithinDays(a, 5));
    }

    public double digits(int d){
        if(d<2)
            return 0;
        else if (d==2)
            return 9;
        double ans = 0;
        ans += 9 * Math.pow(10, d - 2) * (d-1);
        ans += (81 * Math.pow(10, d - 3) * (d-2) * (d-1))/2;
        return ans+1;
    }

    public double atob(int right, int d){
        if(right == 0 || d == 0)
            return 0;
        System.out.println(right + " " + d);
        double cw = Math.pow(10, d-1);
        double ans = 0;
        for(int i = 1; i<right; i++){
            ans += digits(d-1);
            ans += cw;
        }
        return Math.max(ans, 1);
    }

    public int numDupDigitsAtMostN(int n) {
        double ans = 0;
        int d = 0;
        int right;
        while(n > 0){
            right = n%10;
            ans += atob(right, d);
            d += 1;
            n = n/10;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Contest128 ct = new Contest128();
        System.out.println(ct.numDupDigitsAtMostN(23));
//        System.out.println(ct.digits(4));
    }
}
