import java.util.*;

public class Profit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] prices = new long[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextLong();
           }
        long[] clicks = new long[n];
        for(int i = 0; i < n; i++){
            clicks[i] = sc.nextLong();
        }
        sc.close();
        long profit = 0;
        Arrays.sort(prices);
        Arrays.sort(clicks);
        for (int i = 0; i < n; i++) {
            profit += prices[i]*clicks[i];
        }
        System.out.println(profit);
    }
}