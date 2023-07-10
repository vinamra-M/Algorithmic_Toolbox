import java.util.Scanner;

public class MaxLoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int W = scanner.nextInt();
        int[] costs = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        boolean[] select = new boolean[n];
        for (int i = 0; i < n; i++) {
            select[i] = false;
        }
        float[] ratio = new float[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = costs[i]/weights[i];
        }
        scanner.close();
        System.out.println(max(n, W, costs, weights,select,ratio));
    }
    
    public static float max(int n,int W, int[] costs, int[] weights, boolean[] select,float[] ratio) {
        if (W == 0)
            return 0;
        int m=0;
        float maxRatio = -500;
        for (int i = 0; i < n; i++) {
            if (ratio[i] > maxRatio && select[i] == false) {
                maxRatio = ratio[i];
                m = i;
            }
        }
        if (select[m] == true)
            return 0;
        select[m] = true;
        int amount = Math.min(W, weights[m]);
        float value = (float)(costs[m] * amount)/weights[m];
        W = W - amount;
        return (value + max(n, W, costs, weights, select, ratio));     
    }
}