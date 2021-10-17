import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Function function = getMyFunction();
        System.out.println(function.apply(5));
    }

    public static Function<Integer, String> getMyFunction() {
        return new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "The integer provided is: " + integer;
            }
        };
    }
}
