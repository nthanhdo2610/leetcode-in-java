import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileLineByLine {

    public static void main(String[] args) {
        // Replace "your_file_path.txt" with the actual path to your text file
        String filePath = "src/main/resources/sql/customer.sql";

        try {
            // Read all lines from the file into a List of Strings
            List<String> lines = readAllLinesFromFile(filePath);

            // Print the content of the file
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readAllLinesFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }
}
