import java.util.List;

public class LeakMemoryProblem {

    public static void main(String[] args) throws InterruptedException {
        leakMemory();
    }

    static void leakMemory() throws InterruptedException {

        GarbageCollection collection1 = new GarbageCollection(List.of("collection1"));
        GarbageCollection collection2 = new GarbageCollection(List.of("collection2"));
        GarbageCollection collection3 = new GarbageCollection(List.of("collection3"));

        collection1 = null;
        collection2 = null;

        System.gc();
        Thread.sleep(3000);
    }
}