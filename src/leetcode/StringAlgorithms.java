package leetcode;

import java.util.*;

public class StringAlgorithms {

    public void reverseString(char[] s){
        for(int i=0,j=s.length-1;i<j;i++,j--){
            s[i] = (char)(s[i]^s[j]);
            s[j] = (char)(s[i]^s[j]);
            s[i] = (char)(s[i]^s[j]);
        }
    }

    public void testreverseString(){
        char[] s = {'w', 'o', 'r', 'l', 'd'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;
        int[] chars = new int[26];
        for(char c: s.toCharArray())
            chars[c-'a']++;
        for(char c: t.toCharArray())
            chars[c-'a']--;

        for(int i=0;i<26;i++){
            if(chars[i] != 0)
                return false;
        }
        return true;
    }

    public void testanagram(){
        String s="aabc", t="caba";
        System.out.println(isAnagram(s, t));
    }

    public int firstUniqChar(String s) {
        int[] counts = new int[26];
        Arrays.fill(counts, -1);
        int length = s.length();
        for(int i=0;i<length;i++){
            if(counts[s.charAt(i)-'a'] == -1)
                counts[s.charAt(i) - 'a'] = i;
            else
                counts[s.charAt(i) - 'a'] = -2;
        }
        int ans = length;
        for(int i=0;i<26;i++){
            if(counts[i] >= 0)
                ans = Integer.min(ans, counts[i]);
        }
        if(length == ans)
            return -1;
        return ans;
    }

    public void testFistUniqueChar(){
        System.out.println(firstUniqChar("eelloohh"));
    }

    public String countAndSay(int n){
        String cur = "1";
        for(int i=1;i<n;i++){
            StringBuilder updated = new StringBuilder();
            int count=0;
            char curchar = cur.charAt(0);
            for(char newchar: cur.toCharArray()){
                if(newchar == curchar)
                    count++;
                else{
                    updated.append(count);
                    updated.append(curchar);
                    curchar = newchar;
                    count = 1;
                }
            }
//            System.out.println(count + " " + curchar + " " + updated.toString());
            updated.append(count);
            updated.append(curchar);
            cur = updated.toString();
        }
        return cur;
    }

    public void testCountAndSay(){
        for(int i=1;i<10;i++)
            System.out.println(countAndSay(i));
    }

    public static void main(String[] args) {
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        stringAlgorithms.testCountAndSay();
    }
}
