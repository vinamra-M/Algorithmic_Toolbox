import java.util.Scanner;

public class Money {
    private static int getChange(int m, int[] coins, int size) {
        // write your code here
        int table[] = new int[m + 1];
        table[0] = 0;
        for (int i = 1; i <= m; i++)
            table[i] = Integer.MAX_VALUE;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < size; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }

        }

        if (table[m] == Integer.MAX_VALUE)
            return -1;

        return table[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        int[] coins = { 1, 3, 4 };
        int size = 3;
        System.out.println(getChange(m, coins, size));

    }
}
