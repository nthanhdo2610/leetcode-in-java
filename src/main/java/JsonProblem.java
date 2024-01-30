import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonProblem {

    public static void main(String[] args) {
        String filePath = "./src/main/resources/json/data.json";
        try {
            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON from file and parse it into a JsonNode
            JsonNode root = mapper.readTree(new File(filePath));
            JsonNode users = root.get("results");

            Set<String> case1 = new HashSet<>();
            List<String> case2 = new ArrayList<>();
            ObjectNode case3 = mapper.createObjectNode();
            ArrayNode nodes = mapper.createArrayNode();
            int count = root.get("result_count").asInt();

            for (int i = 0; i < users.size(); i++) {
                JsonNode user = users.get(i);
                case1.add(user.get("mod_user").asText());
                if (user.get("dock_type_id").get("key").asText().contains("IN")) {
                    case2.add(user.get("dock_nbr").asText());
                }
                if (user.has("dock_ref_nbr") && !user.get("dock_ref_nbr").asText().isEmpty()) {
                    nodes.add(user);
                } else {
                    count--;
                }
            }
            case3.put("result_count", count);
            case3.put("results", nodes);

            System.out.println("Extract the all the distinct values of the mod_user");
            case1.forEach(System.out::println);
            System.out.println("Extract the values of the dock_nbr if the dock_type_id > key  contains “IN”");
            case2.forEach(System.out::println);
            System.out.println("Remove the result without the dock_ref_nbr from the JSON and update the result_count with the remaining total");
            System.out.println(case3.toPrettyString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
