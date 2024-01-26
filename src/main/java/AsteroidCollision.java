import java.util.Stack;

public class AsteroidCollision {

    /**
     * <a href="https://leetcode.com/problems/asteroid-collision/">735. Asteroid Collision</a>
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            while (!st.isEmpty() && asteroid * st.peek() < 0 && asteroid < 0) {
                int pre = st.pop();
                if (asteroid + pre == 0) {
                    asteroid = 0;
                } else if (Math.abs(asteroid) < Math.abs(pre)) {
                    asteroid = pre;
                }
            }
            if (asteroid != 0) {
                st.push(asteroid);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; 0 <= i; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();
        int[] asteroids = {5, 10, -5};
        int[] result = solution.asteroidCollision(asteroids);

        System.out.print("Result: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
