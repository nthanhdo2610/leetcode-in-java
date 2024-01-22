import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));
        List<String> sortedTickets = findItinerary(tickets);
        sortedTickets.forEach(System.out::println);
    }

    /**
     * <a href="https://leetcode.com/problems/reconstruct-itinerary/">332. Reconstruct Itinerary</a>
     *
     * @param tickets
     * @return
     */
    public static List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.isEmpty())
            return new ArrayList<>();

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            String depart = ticket.get(0);
            String destination = ticket.get(1);
            PriorityQueue<String> destinations = map.getOrDefault(depart, new PriorityQueue<>());
            destinations.add(destination);
            map.put(depart, destinations);
//            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        dfs("JFK", map, result);

        return result;
    }

    public static void dfs(String airport, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> destinations = map.getOrDefault(airport, new PriorityQueue<>());

        while (!destinations.isEmpty()) {
            dfs(destinations.poll(), map, result);
        }

        result.add(0, airport);
    }
}
