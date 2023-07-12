import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        for (int i = 1; i < n + 1; i++) {
            if (dp[i] != 0) {
                if (i + 1 < n + 1 && (dp[i + 1] == 0 || dp[i + 1] > dp[i] + 1)) {
                    dp[i + 1] = dp[i] + 1;
                }
                if (i * 2 < n + 1 && (dp[i * 2] == 0 || dp[i * 2] > dp[i] + 1)) {
                    dp[i * 2] = dp[i] + 1;
                }
                if (i * 3 < n + 1 && (dp[i * 3] == 0 || dp[i * 3] > dp[i] + 1)) {
                    dp[i * 3] = dp[i] + 1;
                }
            }
        }

        while (n >= 1) {
            sequence.add(n);
            if (dp[n - 1] == dp[n] - 1) {
                n--;
            }
            else if (n % 2 == 0 && dp[(int) Math.floor(n / 2)] == dp[n] - 1) {
                n = (int) Math.floor(n / 2);
            }
            else if (n % 3 == 0 && dp[(int) Math.floor(n / 3)] == dp[n] - 1) {
                n = (int) Math.floor(n / 3);
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
