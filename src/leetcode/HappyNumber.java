package leetcode;

import java.util.HashSet;
public class HappyNumber {
    HashSet<Integer> seen = new HashSet<>();
    public int getsum(int n){
        int ans = 0;
        while(n>0){
            int d = n%10;
            ans += d*d;
            n = n/10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        seen.add(n);
        while(true){
            int cur = getsum(n);
            if(cur == 1)
                return true;
            else if(seen.contains(cur))
                return false;
            seen.add(cur);
            n = cur;
        }
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(6));
    }
}
