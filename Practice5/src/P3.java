import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt(), n, k;
        for (int i = 0; i < t; i++) {
            n = input.nextInt();
            k = input.nextInt();
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) numbers[j] = input.nextInt();
            if (Divisibility(numbers, n, k, 1, numbers[0])) System.out.println("Divisible");
            else System.out.println("Not divisible");
        }
    }
    static boolean Divisibility (int[] numbers, int n, int k, int i, int sum) {
        if (i == n) return sum % k == 0;
        else return Divisibility(numbers, n, k, i + 1, sum + numbers[i]) || Divisibility(numbers, n, k, i + 1, sum - numbers[i]);
    }
}