/*
    New Features in Java 10

    1. Changes in release versioning
    2. Local variable type inference
    3. Graal - Complete rewrite of JIT compiler in Java from scratch (Experimaental: -XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler)
    4. Application class data sharing: Reduces startup time by sharing common class meta data across different java processes
    5. Parallel Full GC or G1: G1 was defaulted in Java 9, now it has been upgraded to run in parallel threaded mode
    6. Improved modularity in Internal GC code
    7. Consolidate JDK Forest into single repository
    8. Heap allocation on alternative memory devices
    9. There are others but nothing hugely important

 */
public class Java10Test {

    public static void main(String[] args) {

        testLocalVariableTypeInference();
    }

    private static void testLocalVariableTypeInference() {
        var myString = "Hellow World";
        var myInteger = 4;
        System.out.println(myString.getClass());
        System.out.println(2 + myInteger);
    }
}
