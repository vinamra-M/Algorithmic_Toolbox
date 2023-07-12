import java.util.*;
public class Majority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(majority(arr));
    }

    public static int majority(int[] arr) {
        Map<Integer, Integer> hash = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (hash.containsKey(arr[i])) {
                int v = hash.get(arr[i]);
                v++;
                hash.put(arr[i], v);
            } else {
                hash.put(arr[i], 1);
            }
        }
        int m = n / 2;
        for (int a : hash.values()) {
            if (a > m)
                return 1;
        }
        return 0;
    }
    
}