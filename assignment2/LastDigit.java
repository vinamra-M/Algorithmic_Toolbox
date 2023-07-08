import java.util.Scanner;

public class LastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(lastDigit(n));
    }

    public static int lastDigit(int n){
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