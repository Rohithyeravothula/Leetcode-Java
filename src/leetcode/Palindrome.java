package leetcode;

public class Palindrome {

    // check every character to be the same or not with its counter part
    // ex: abcba
    // check a at pos 0 with a at pos 4
    // check b at pos 1 with a at pos 3
    // ex: abe
    // check a at pos 0 with e at pos 2, not same so returns false
    // time O(n) and space O(n)
    public static boolean checkIfPalindrome(String input){
        int l = input.length();
        for(int i=0;i<l/2;i++){
            if(input.charAt(i) != input.charAt(l-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.checkIfPalindrome("abba"));
    }

}
