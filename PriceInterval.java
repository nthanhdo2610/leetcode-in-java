import java.util.Comparator;

public class PriceInterval implements Comparable<PriceInterval> {
    int startTime;
    int endTime;
    int price;

    public PriceInterval(int startTime, int endTime, int price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    @Override
    public int compareTo(PriceInterval o) {
        return this.startTime - o.startTime;
    }
}
