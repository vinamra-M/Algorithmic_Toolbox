import java.util.Scanner;

public class Placing{
    private static long getMaximValue(String exp) {
        int n = (exp.length() + 1) / 2;
        int[] d = new int[n];
        char[] ops = new char[n - 1];
        for (int i = 0; i < exp.length(); i++) {
            if (i % 2 == 0)
                d[i / 2] = (int) exp.charAt(i) - 48;
            else
                ops[(i - 1) / 2] = exp.charAt(i);
        }
        long[][] m = new long[n+1][n+1];
        long[][] M = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                m[i][j] = -1;
            }
        }
        for (int i = 1; i <= n; i++) {
            m[i][i] = d[i-1];
            M[i][i] = d[i-1];
        }

        for (int s = 1; s <= n - 1; s++) {
            for (int i = 1; i <= n - s; i++) {
                int j = i + s;
                long[] arr = minAndMax(i, j, m, M, ops);
                m[i][j] = arr[0];
                M[i][j] = arr[1];
            }
        }

        return M[1][n];
    }

    private static long min(long a, long b, long c, long d, long e) {
        long ans = Integer.MAX_VALUE;
        ans = Math.min(ans, a);
        ans = Math.min(ans, b);
        ans = Math.min(ans, c);
        ans = Math.min(ans, d);
        ans = Math.min(ans, e);
        return ans; 
    }
    
    private static long max(long a, long b, long c, long d, long e) {
        long ans = Integer.MIN_VALUE;
        ans = Math.max(ans, a);
        ans = Math.max(ans, b);
        ans = Math.max(ans, c);
        ans = Math.max(ans, d);
        ans = Math.max(ans, e);
        return ans;
    }

    private static long[] minAndMax(int i, int j, long[][] m, long[][] M, char[] ops){
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for (int k = i; k <= j - 1; k++) {
            long a = eval(M[i][k], M[k + 1][j], ops[k - 1]);
            long b = eval(M[i][k], m[k + 1][j], ops[k - 1]);
            long c = eval(m[i][k], m[k + 1][j], ops[k - 1]);
            long d = eval(m[i][k], M[k + 1][j], ops[k - 1]);
            min = min(min, a, b, c, d);
            max = max(max, a, b, c, d);
        }
        return new long[] {min,max};
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        scanner.close();
        System.out.println(getMaximValue(exp));
    }
}
