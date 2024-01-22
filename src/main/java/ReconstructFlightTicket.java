import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructFlightTicket {

    public static List<String> sortTickets(List<String> tickets, String start) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String ticket : tickets) {
            String[] airports = ticket.split("-");
            map.putIfAbsent(airports[0], new PriorityQueue<>());
            map.get(airports[0]).add(airports[1]);
        }

        List<String> result = new ArrayList<>();
        dfs(start, map, result);

        return result;
    }

    private static void dfs(String depart, Map<String, PriorityQueue<String>> map, List<String> result) {

        PriorityQueue<String> destinations = map.getOrDefault(depart, new PriorityQueue<>());
        while (!destinations.isEmpty()) {
            dfs(destinations.poll(), map, result);
        }

        result.add(0, depart);
    }

    public static void main(String[] args) {
        List<String> tickets = Arrays.asList("NJ-FL", "TX-NY", "WA-NJ", "NY-WA");
        String startCity = "TX";

        List<String> sortedTickets = sortTickets(tickets, startCity);

        System.out.println("Sorted Tickets:");
        for (String ticket : sortedTickets) {
            System.out.println(ticket);
        }
    }
}
