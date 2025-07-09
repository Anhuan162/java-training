package generic;
// generic class
class Box<T> {
    private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }
}

// generic interface
interface Repository<T> {
    void save(T item);
}

class User {
    private String name;

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }
}

class UserRepository implements Repository<User> {
    public void save(User user) {
        System.out.println("Saving user: " + user.getName());
    }
}

class People {
    protected String name;
}

class Man extends People{
}

public class GenericExample {

    public static void main(String[] args) {
        Box<Integer> box = new Box<Integer>();
        box.set(10);
        System.out.println(box.get());

        User user = new User();
        user.setName("John");
        UserRepository repo = new UserRepository();
        repo.save(user);

    }

}
