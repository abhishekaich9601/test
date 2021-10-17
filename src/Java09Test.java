import java.io.IOError;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Java09Test {

    public static void main(String args[]) throws IOException, InterruptedException {
        //testCollectionFactoryMethods();
        // testing interface private method
        DummyIntf dummyImpl = new DummyIntf() {
        };
        //dummyImpl.privateMethodCaller();
        testNewHttpClient();
    }

    private static void testNewHttpClient() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://kubernetes.io/docs/tutorials/kubernetes-basics/"))
                .header("User-Agent", "Java")
                .GET()
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static void testCollectionFactoryMethods() {
        List immutableEmptyList = List.of();
        System.out.println(immutableEmptyList);
        List anotherImmutableList = List.of("one", "two", "three");
        System.out.println(anotherImmutableList);
        Map emptyImmutableMap = Map.of();
        System.out.println(emptyImmutableMap);
        Map nonEmptyImmutableMap = Map.of(1, "one", 2, 2, 3, Integer.valueOf(3));
        System.out.println(nonEmptyImmutableMap);
    }

    public interface DummyIntf {

        //private methods are now allowed
        private void dummyPrivateMethod() {
            System.out.println("Interface private method called");
        }

        default void privateMethodCaller() {
            dummyPrivateMethod();
        }
    }


}
