package oop_final_static.overload_override;

class Cat implements Animal {

    @Override
    public String eat() {
        return "Cat eat fish";
    }
}

class Dog implements Animal {

    @Override
    public String eat() {
        return "Dog eat meat";
    }

    public static void barks(String p) {
        System.out.println(p);
    }

    public static void barks(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Dog barks");
        }
    }
}


public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        System.out.println(cat.eat());
        System.out.println(dog.eat());

        Dog.barks("Gau Gau");
        Dog.barks(3);
    }
}
