package example;

import java.util.Comparator;
import java.util.function.Function;


public class Animal {
    public Integer age;
    String name;


    Animal(String name){
        this.name = name;
        printName("");
    }

    public void printName(String name){

        System.out.println(name);
        System.out.println(this.name);
    }

    public void testSome(Function<Integer, Integer> f1){
//        Comparator.comparing()
    }

    public static void main(String[] args) {
    }
}
