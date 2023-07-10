import java.util.*;

public class Signatures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rods = new int[n][2];
        for (int i = 0; i < n; i++) {
            rods[i][0] = sc.nextInt();
            rods[i][1] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(rods, (a, b) -> Integer.compare(a[1], b[1]));
        // System.out.println(rods);
        boolean[] array = new boolean[n];
        for (int i = 0; i < n; i++) {
            array[i] = false;
        }
        sign(rods, array);
    }

    public static void sign(int[][] rods, boolean[] array) {
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < rods.length; i++) {
            if (array[i] == false) {
                count++;
                arr.add(rods[i][1]);
                array[i] = true;
                for (int j = i + 1; j < rods.length; j++) {
                    if (rods[i][1] >= rods[j][0] && rods[i][1] <= rods[j][1] && array[j] == false) {
                        array[j] = true;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.print(arr.get(0));
        for(int i = 1; i < arr.size();i++){
            System.out.print(" "+arr.get(i));
        }

    }
}