package passing_mechanism;

class Dog {
    String name;
}

// Other class can not extend from final class
final class Cat extends Dog {
    String name;
}

public class PractivePassingMechanism {

    static void change(int x) {
        x = 10;
    }

    static int update(int x) {
        x = 10;
        return x;
    }

    static void rename(Dog d) {
        d.name = "Max";
    }

    static void notRename(Dog d) {
        d = new Dog();
        d.name = "James";
    }

    public static void main(String[] args) {
        int a = 5;
        change(a);
        System.out.println(a); //  x is a copy of a. Changing x doesn't affect a.
        System.out.println(update(a)); // value return is x after it was changed

        Dog dog = new Dog();
        dog.name ="Buddy";

        rename(dog);
        System.out.println(dog.name); // Max because both point to the same object → object fields can be modified.

        notRename(dog);
        System.out.println(dog.name);
    }
}
