import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int g = gcd(n, m);
        long p = (long) m * (long) n;
        p = p/g;
        System.out.println(p);

    }
    
    public static int gcd(int a, int b) {
        if (a == b)
            return a;
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int ans = 0;
        while (b > 0) {
            ans = b;
            int rem = a % b;
            a = b;
            b = rem;
        }
        return ans;
    }
    
}