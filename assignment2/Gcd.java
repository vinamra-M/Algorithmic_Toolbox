import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        System.out.println(gcd(n,m));
    }

    public static int gcd(int a, int b) {
        if(a == b) return a;
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