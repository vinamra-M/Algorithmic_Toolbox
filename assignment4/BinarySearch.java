import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] toSearch = new int[m];
        for (int i = 0; i < m; i++) {
            toSearch[i] = sc.nextInt();
        }
        sc.close();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = binarySearch(arr, toSearch[i]);
        }
        for(int i = 0; i < m; i++){
            System.out.print(ans[i]+" ");
        }
    }
    
    public static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }
}