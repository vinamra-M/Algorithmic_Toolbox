import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w, int n) {
        //write you code here
        int i, we;
        int K[][] = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++) {
            for (we = 0; we <= W; we++) {
                if (i == 0 || we == 0)
                    K[i][we] = 0;
                else if (w[i - 1] <= we)
                    K[i][we] = max(w[i - 1] + K[i - 1][we - w[i - 1]], K[i - 1][we]);
                else
                    K[i][we] = K[i - 1][we];
            }
        }
        return K[n][W];
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(optimalWeight(W, w, n));
    }
}

