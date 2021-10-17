public class EpsilonGCTest {
    static final int MEGABYTE_IN_BYTES = 1024 * 1024;
    static final int ITERATION_COUNT = 1024 * 10;

    public static void main(String[] args) {
        System.out.println("Starting pollution");
        long startTime = System.currentTimeMillis();
        int totalCount = 0;
        long totalTime;
        double perIteration;

        try {
            for (int i = 1; i < ITERATION_COUNT; i++) {
                byte[] array = new byte[MEGABYTE_IN_BYTES];
                totalCount = i;
                totalTime = (System.currentTimeMillis()-startTime)*100000;
                perIteration = totalTime/totalCount;
                System.out.println("perIteration="+perIteration);
            }
        }
        catch(Error t) {
            t.printStackTrace();
        }
        finally {
        }

        System.out.println("Terminating");
    }
}
