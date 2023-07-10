import java.util.Scanner;

public class Fueling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] stop = new int[n];
        for (int i = 0; i < n; i++) {
            stop[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(fueling(d,m,n,stop));
    }

    public static int fueling(int d, int m, int n, int[] stop) {
        int current = 0;
        if (stop[n - 1] + m < d)
            return -1;
        if(m >= d) return 0;
        int ans = 0;
        while (current < d) {
            current+=m;
            for (int i = 0; i < n; i++) {
                if (stop[i] == current) {
                    ans++;
                    break;
                } else if (stop[i] > current) {
                    if (i == 0)
                        return -1;
                    int temp = stop[i - 1];
                    if (temp <= current - m)
                        return -1;
                    current = temp;
                    ans++;
                    break;
                }
            }
            if (current > stop[n-1] && current < d) {
                current = stop[n-1];
                ans++;
            } 
        }
        return ans;
    }
}