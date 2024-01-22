import java.util.HashMap;
import java.util.Map;

public class BestAverageProblem {

    public static String[] findBestAverage(String[][] studentGrades) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (String[] grade : studentGrades) {
            sum.put(grade[0], sum.getOrDefault(grade[0], 0) + Integer.parseInt(grade[1]));
            cnt.put(grade[0], cnt.getOrDefault(grade[0], 0) + 1);
        }
        double bestAvg = 0.0;
        String student = "";
        for (Map.Entry<String, Integer> entry : sum.entrySet()) {
            int avg = entry.getValue() / cnt.get(entry.getKey());
            if (avg > bestAvg) {
                bestAvg = avg;
                student = entry.getKey();
            }
        }
        return new String[]{student, String.valueOf(bestAvg)};
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
