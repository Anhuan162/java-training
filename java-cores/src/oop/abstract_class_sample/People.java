package oop.abstract_class_sample;

public class People implements PlayBadminton, PlayFootball{
    @Override
    public String playBadminton() {
        return "Play Badminton";
    }

    @Override
    public String playFootball() {
        return "Play Football";
    }

    public static void main(String[] args) {
        System.out.println(new People().playBadminton());
        System.out.println(new People().playFootball());
    }
}
