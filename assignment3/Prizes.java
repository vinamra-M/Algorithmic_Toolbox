import java.util.*;

public class Prizes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        ArrayList<Integer> arr = new ArrayList<>();
        prizes(n, arr);
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void prizes(int n, ArrayList<Integer> arr) {
        if (n == 1 || n == 2) {
            arr.add(n);
            return;
        }
        int temp = 1;
        while (n > 2 * temp) {
            arr.add(temp);
            n -= temp;
            temp++;
        }
        arr.add(n);
    }
}