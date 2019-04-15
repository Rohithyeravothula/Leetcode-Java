package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p){
        if(s==null || s.length() == 0 || p==null || p.length() == 0)
            return Collections.emptyList();
        int sl = s.length(), pl = p.length(), j,i=0, inta=Character.getNumericValue('a');
        if(pl > sl)
            return Collections.emptyList();

        List<Integer> ans = new ArrayList<>();
        int[] pkey = new int[26], curkey = new int[26];
        for(i=0;i<pl;i++){
            pkey[Character.getNumericValue(p.charAt(i))-inta]++;
            curkey[Character.getNumericValue(s.charAt(i))-inta]++;
        }
        boolean match = true;
        for(i=0;i<26;i++){
            if(pkey[i] != curkey[i]){
                match = false;
                break;
            }
        }
        if(match)
            ans.add(0);

        for(i=pl;i<sl;i++){

            curkey[Character.getNumericValue(s.charAt(i))-inta]++;
            curkey[Character.getNumericValue(s.charAt(i-pl))-inta]--;

            match = true;
            for(j=0;j<26;j++){
                if(pkey[j] != curkey[j]){
                    match = false;
                    break;
                }
            }
            if(match)
                ans.add(i-pl);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s,p;
        s = "";
        p = "a";
        s = "a";
        p = "b";
        Anagrams ag = new Anagrams();
        System.out.println(ag.findAnagrams(s, p));
    }
}
