import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileCopy {

    public static void main(String[] args) {
        // Replace "your_file_path.txt" with the actual path to your text file
        String inputFilePath = "src/main/resources/sql/customer.sql";
        String outputFilePath = "src/main/resources/sql/customer_copy.sql";

        try {
            // Read all lines from the input file
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));

            // Write all lines to the output file
            Files.write(Paths.get(outputFilePath), lines);

            System.out.println("File copy successful.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File copy failed.");
        }
    }
}
