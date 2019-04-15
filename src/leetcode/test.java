package leetcode;

public class test {
    public void change(Integer val){
        val = 5;
    }

    public static void main(String[] args) {
        Integer val = 3;
        test t = new test();
        t.change(val);
        System.out.println(val);
    }
}
