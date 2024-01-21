import java.util.ArrayList;
import java.util.List;

public class CheapestPriceInterval {

    /**
     * You are given a list of price intervals, where each interval is represented as (start-time, end-time, price).
     * The goal is to find the cheapest price intervals, such that you get the best deal.
     *
     * @param intervals
     * @return
     */
    public static List<PriceInterval> findCheapestPrices(List<PriceInterval> intervals) {
        if (intervals.isEmpty() || intervals.size() < 2)
            return intervals;

        List<PriceInterval> lst = intervals.stream().sorted(PriceInterval::compareTo).toList();
        PriceInterval crr = lst.get(0);
        List<PriceInterval> result = new ArrayList<>();
        for (int i = 1; i < lst.size(); i++) {
            PriceInterval next = lst.get(i);
            if (crr.endTime > next.startTime) {
                if (crr.price >= next.price) {
                    crr.endTime = next.startTime;
                } else {
                    next.startTime = crr.endTime;
                }
            }
            result.add(crr);
            crr = next;
        }
        result.add(crr);
        return result;
    }

    public static void main(String[] args) {
        List<PriceInterval> intervals = new ArrayList<>();
        intervals.add(new PriceInterval(1, 5, 20));
        intervals.add(new PriceInterval(3, 8, 15));
        intervals.add(new PriceInterval(7, 10, 8));

        List<PriceInterval> cheapestPrices = findCheapestPrices(intervals);

        // Print the result
        for (PriceInterval interval : cheapestPrices) {
            System.out.println("(" + interval.startTime + "," + interval.endTime + "," + interval.price + ")");
        }
    }
}
