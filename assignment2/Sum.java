import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        System.out.println(sum(n+1));
    }

    public static int sum(long n) {
        long ans = 0;
        // int repeat = 60;
        for(int i = 0; i < 60; i++){
            long last = lastDigit(i);
            ans = (ans+last)%10;
        }
        long iter = (n) / 60;
        long rest = n % 60;
        ans = (ans*iter)%10;
        for(int i = 0; i < rest; i++){
            long last = lastDigit(i);
            ans = (ans+last)%10;
        }
        return (int)ans;
    }

    public static int lastDigit(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int ans = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n + 1; i++) {
            ans = (a + b) % 10;
            a = b;
            b = ans;
        }
        return ans;
    }
}