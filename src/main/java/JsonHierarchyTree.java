import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class JsonHierarchyTree {

    public static void main(String[] args) throws IOException {
        // Your JSON string goes here
        String jsonString = "{ \"name\": \"Root\", \"children\": [ { \"name\": \"Node1\", \"children\": [ { \"name\": \"Node1.1\", \"children\": [] }, { \"name\": \"Node1.2\", \"children\": [] } ] }, { \"name\": \"Node2\", \"children\": [ { \"name\": \"Node2.1\", \"children\": [] } ] } ] }";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonString);

        NameHierarchy nameRoot = buildTree(root);
        printTreeBFS(nameRoot);
    }

    private static NameHierarchy buildTree(JsonNode node) {
        String name = node.get("name").asText();
        JsonNode childrenNode = node.get("children");
        NameHierarchy[] children = new NameHierarchy[childrenNode.size()];

        for (int i = 0; i < childrenNode.size(); i++) {
            children[i] = buildTree(childrenNode.get(i));
        }

        return new NameHierarchy(name, children);
    }

    private static void printTreeBFS(NameHierarchy root) {
        Queue<NameHierarchy> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                NameHierarchy node = queue.poll();
                System.out.print(node.name + " ");

                for (NameHierarchy child : node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            System.out.println(); // Move to the next line for the next level
        }
    }
}
