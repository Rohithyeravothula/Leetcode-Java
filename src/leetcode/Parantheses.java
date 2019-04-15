package leetcode;

import java.util.*;

public class Parantheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(')
                stk.push(')');
            else if(c == '[')
                stk.push(']');
            else if(c == '{')
                stk.push('}');
            else if(stk.isEmpty() || !stk.pop().equals(c))
                return false;
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        String example;
        example = "[";
        Parantheses palgo = new Parantheses();
        System.out.println(palgo.isValid(example));
    }
}
