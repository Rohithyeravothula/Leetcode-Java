package example;

public class Dog {
    Integer age;
    String name;
    Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[10];
        System.out.println(dogs);
    }
}
