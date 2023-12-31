import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int an = a.length;
        int bn = b.length;
        int cn = c.length;
        // Write your code here
        int L[][][] = new int[an + 1][bn + 1][cn+1];

        // Following steps build L[an+1][bn+1] in bottom up
        // fashion. Note that L[i][j] contains length of LCS
        // of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= an; i++) {
            for (int j = 0; j <= bn; j++) {
                for (int k = 0; k <= cn; k++) {
                    if (i == 0 || j == 0 || k == 0)
                        L[i][j][k] = 0;
                    else if (a[i - 1] == b[j - 1] && b[j-1] == c[k-1])
                        L[i][j][k] = L[i - 1][j - 1][k-1] + 1;
                    else
                        L[i][j][k] = max(L[i - 1][j][k], L[i][j - 1][k], L[i][j][k-1]);
                }
            }
        }
        return L[an][bn][cn];
    }

    static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)
            return b;
        else
            return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(lcs3(a, b, c));
    }
}
