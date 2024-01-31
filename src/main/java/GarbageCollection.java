import java.util.List;

public class GarbageCollection {

    private final List<String> collections;

    public GarbageCollection(List<String> collections) {
        this.collections = collections;
        System.out.println("Object created: " + this);
    }

    @Override
    protected void finalize(){
        System.out.println("Object garbage collected: " + this);
    }
    @Override
    public String toString() {
        return "Garbage{" +
                "collections=" + collections +
                '}';
    }
}
