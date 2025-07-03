package string;

public class PraticeString {
    public static void main(String[] args) {
        Integer n1 = 300;
        Integer n2 = Integer.valueOf(n1);
        Integer n4 = 3;
        Integer n5 = Integer.valueOf(n4);
        Integer n3 = new Integer(n4);


        System.out.println(n2 == n1);   // true vì cùng trỏ đên integer cahe khi gia tri nam
        System.out.println(n4 == n5);   // tu -128 - 127 , ngoai khoang nay tra false do

        System.out.println(n2.equals(n1));  // true vì equals so sanh gia tri
        System.out.println(n2 == n4);   // false vi tro den khac vung nho


        String a = "Hello";
        a.concat(" World"); // Immutable
        System.out.println(a); // Hello

        StringBuilder b = new StringBuilder("Hello");
        b.append(" World"); // Mutable
        System.out.println(b); // Hello World
    }
}
