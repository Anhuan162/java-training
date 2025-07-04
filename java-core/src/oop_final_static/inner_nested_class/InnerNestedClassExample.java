package oop_final_static.inner_nested_class;

class Category {
    String name;
    int count;

    static class Product {
        String productName;
    }
}

class Car {
    private String engineStatus = "off";

    class Engine {
        void start() {
            engineStatus = "on"; // inner class accesses outer's private field
            System.out.println("Engine started.");
        }
    }
}

public class InnerNestedClassExample {
    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine engine = car.new Engine();  // need outer class to create
        engine.start();

        Category.Product product = new Category.Product();  // don't need outer class to create

    }

}
