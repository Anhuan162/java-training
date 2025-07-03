package oop_final_static.interface_and_abstract_sample;

abstract class People {
    private static int age = 15;

    abstract String say();

    public static void setAge(int age) {
        People.age = age;
    }

    public static int getAge() {
        return age;
    }

    String haveNoBreasts() {
        return "Have no breasts";
    }

    static String haveShortHair() {
        return "Have short hair";
    }

    final static String playSportWell() {
        return "Play sport well";
    }   // can not override + hiding

    static String likeFootball() {
        return "Like football";
    }
    // can not override but have hiding
}


// other class can not extend final class
final class Woman extends People{
    String name = "Helen";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    String say() {
        return "Woman say that ....";
    }

    static String likeFootball(String s) {
        return s;
    }
}

public class Man extends People implements PlayBadminton, PlayFootball{
    public final static String name = "Huan";

    @Override
    public String playBadminton() {
        return "Play Badminton";
    }

    @Override
    public String playFootball() {
        return "Play Football";
    }

    @Override
    String say() {
        return "Everybody say no";
    }

    String haveNoBreasts() {
        return "Have no breasts 1";
    }

    public static void main(String[] args) {
        System.out.println(new Man().playBadminton());
        System.out.println(new Man().playFootball());

        // using overrided method of Man object
        People p = new Man();
        People p2 = new People() {
            @Override
            String say() {
                return "okkk";
            }
        };
        name.concat("abc");
        System.out.println(name); // can not update

        p.setAge(20);
        System.out.println(p.getAge());   // update age successfull

        p2.setAge(30);
        System.out.println(p2.getAge());

        Woman w = new Woman();
        w.setName("Majar");  // can update name, nhung final object khong the gan lai
        System.out.println(w.getName());
        Woman.likeFootball("Hello");   // hiding
        System.out.println(Woman.likeFootball("Hello"));

        People p3 = new Woman();
        p3.haveNoBreasts();

        System.out.println(p2.haveNoBreasts());

        Man m = new Man();
        System.out.println(m.say());
        System.out.println(m.haveNoBreasts());
        System.out.println(p.haveNoBreasts());
        System.out.println(Man.haveShortHair());
        System.out.println(oop_final_static.interface_and_abstract_sample.Man.haveShortHair());
        System.out.println(new Man().playSportWell());
    }
}
