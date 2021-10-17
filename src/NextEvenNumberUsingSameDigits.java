import java.util.ArrayList;
import java.util.Scanner;

public class NextEvenNumberUsingSameDigits {

    private static final int ZERO_CHAR = '0';
    private static ArrayList<Character> evenList = null;
    private static ArrayList<Character> oddList = null;


    public static void main(String[] args) {
        while (true) {
            System.out.println("########################################################");
            System.out.println("Enter the number");
            String inputNumber = (new Scanner(System.in)).nextLine();
            evaluateNumber(inputNumber);
        }
    }

    private static void evaluateNumber(String inputNumber) {
        int numberLength = inputNumber.length();
        int lastEvenIndex = -1;
        int inflexionIndex = -1;
        int lengthFromInflection = Integer.MAX_VALUE;
        for (int i = numberLength-1; i >= 1; i--) {
            //System.out.println(inputNumber.charAt(i)-ZERO_CHAR);
            if (inputNumber.charAt(i)>inputNumber.charAt(i-1) || lengthFromInflection<=2) {
                inflexionIndex = i-1;
                lengthFromInflection = numberLength - i +1;
            }
            if ((inputNumber.charAt(i)-ZERO_CHAR)%2==0 && lastEvenIndex==-1) {
                lastEvenIndex = i;
            }
            if (inflexionIndex!=-1 && inflexionIndex<numberLength-2) { // Take minimum of 3 digits to take care of the case of 34
                break;
            }
        }
        if (lastEvenIndex==-1) {
            for (int i = inflexionIndex; i >= 0; i--) {
                if ((inputNumber.charAt(i)-ZERO_CHAR)%2==0) {
                    lastEvenIndex = i;
                }
            }
        }
        //System.out.println("lengthFromInflection="+lengthFromInflection);
        // No inflections point or no even numbers
        if (inflexionIndex==-1 || lastEvenIndex==-1) {
            System.out.println("**********  No number possible   ****************");
            return;
        }
        // Two digit number
        if (lengthFromInflection==2) {
            if ((inputNumber.charAt(inflexionIndex)-ZERO_CHAR)%2!=0) {
                System.out.println("**********  No number possible   ****************");
            }
            else {
                //System.out.println("Two digit number");
                System.out.println(String.valueOf(inputNumber.charAt(1)) + String.valueOf(inputNumber.charAt(0)));
            }
            return;
        }
        int startIndexForNumber = Integer.min(inflexionIndex, lastEvenIndex);
        String prefixNumber = inputNumber.substring(0, startIndexForNumber);
        String numberToRearrange = inputNumber.substring(startIndexForNumber);
        System.out.println("inflexionIndex="+inflexionIndex);
        System.out.println("lastEvenIndex="+lastEvenIndex);
        System.out.println("startIndexForNumber="+startIndexForNumber);
        System.out.println("prefixNumber=" + prefixNumber);
        System.out.println("Substring to consider=" + numberToRearrange);
        // Handle more than 2 digit number
        populateEvenAndOddBucket(numberToRearrange);
        rearrangeNumber(numberToRearrange.toCharArray());


    }

    private static void rearrangeNumber(char[] charArray) {
        // Replace inflection point by next biggest number
        int minimumNext = -1;
        for (int index = 1; index < charArray.length; index++) {
            //if (charArray[])
        }
        // Put biggest even number at the end
    }

    private static void populateEvenAndOddBucket(String inputNumber) {
        evenList = new ArrayList<>();
        oddList = new ArrayList<>();
        for (int index = 0; index < inputNumber.length(); index++) {
            if ((inputNumber.charAt(index)-ZERO_CHAR)%2==0) {
                evenList.add(inputNumber.charAt(index));
            }
            else {
                oddList.add(inputNumber.charAt(index));
            }
        }
    }


}
