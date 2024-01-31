import java.util.List;

public class LeakMemoryProblem {

    public static void main(String[] args) throws InterruptedException {
        leakMemory();
    }

    static void leakMemory() throws InterruptedException {

        MyCollection collection1 = new MyCollection(List.of("collection1"));
        MyCollection collection2 = new MyCollection(List.of("collection2"));

        MyCollection collection3 = collection1;

        collection1 = null;
        collection2 = null;

        System.gc();
        Thread.sleep(3000);

        collection3 = null;
        System.gc();
        Thread.sleep(3000);
    }
}

class MyCollection {

    private final List<String> collections;

    public MyCollection(List<String> collections) {
        this.collections = collections;
        System.out.println("Object created: " + this);
    }

    @Override
    protected void finalize() {
        System.out.println("Object garbage collected: " + this);
    }

    @Override
    public String toString() {
        return "Garbage{" +
                "collections=" + collections +
                '}';
    }
}
