import java.util.HashMap;
import java.util.Map;

public class BestAverageProblem {

    public static String[] findBestAverage(String[][] studentGrades) {
        Map<String, Integer> sumGrades = new HashMap<>();
        Map<String, Integer> countGrades = new HashMap<>();

        // Calculate sum and count of grades for each student
        for (String[] student : studentGrades) {
            String name = student[0];
            int grade = Integer.parseInt(student[1]);

            sumGrades.put(name, sumGrades.getOrDefault(name, 0) + grade);
            countGrades.put(name, countGrades.getOrDefault(name, 0) + 1);
        }

        // Find the student with the highest average grade
        String bestStudent = null;
        double bestAverage = 0.0;

        for (Map.Entry<String, Integer> entry : sumGrades.entrySet()) {
            String name = entry.getKey();
            int sum = entry.getValue();
            int count = countGrades.get(name);
            double average = (double) sum / count;

            if (average > bestAverage) {
                bestAverage = average;
                bestStudent = name;
            }
        }

        return new String[]{bestStudent, String.valueOf(bestAverage)};
    }

    public static void main(String[] args) {
        String[][] studentGrades = {
                {"Mark", "70"},
                {"Alex", "60"},
                {"Alex", "62"},
                {"Stephen", "75"}
        };

        String[] result = findBestAverage(studentGrades);

        System.out.println("Student with the best average grade: " + result[0]);
        System.out.println("Best average grade: " + result[1]);
    }
}
