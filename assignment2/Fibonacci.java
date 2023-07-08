import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if(n == 1) return 1;
        
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n+1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}