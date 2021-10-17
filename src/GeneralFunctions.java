import java.util.Scanner;

public class GeneralFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();

        switch (test) {
            case "a":
                System.out.println("A is there in test");
                //break;
            case "b":
                System.out.println("B is there in test");
                break;
            default:
                System.out.println("Incorrect input");
        }
    }
}
