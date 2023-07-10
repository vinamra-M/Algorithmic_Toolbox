import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        sc.close();
        System.out.println(money(money));
    }

    public static int money(int money) {
        int ten = money / 10;
        money = money % 10;
        int five = money / 5;
        money = money % 5;
        int one = money;
        
        return ten + five + one;
    }
}