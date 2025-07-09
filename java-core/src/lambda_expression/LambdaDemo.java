package lambda_expression;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {
    public static void main(String[] args) throws NumberFormatException {

        // Predicate    -- check condition
        Predicate<String> p1 = s -> s.startsWith("a");
        Predicate<String> p2 = s -> s.endsWith("b");
        System.out.println(p1.test("abcd"));
        System.out.println(p1.and(p2).test("abcd"));

        System.out.println("\n");

        // Function -- convert data
        Function<String, Integer> f1 = s -> Integer.parseInt(s);
        System.out.println(f1.apply("8"));

        // Consumer -- execute, not return
        Consumer<String> c1 = s ->  {
            s = s.concat("out ulll");
            System.out.println(s);
        };
        c1.accept("8");

        // Supplier -- provide data
        Supplier<Integer> s1 = () -> 8;
        System.out.println(s1.get());
    }
}
