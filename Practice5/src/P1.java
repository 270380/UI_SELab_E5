import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[] subset = new boolean[n + 1];
        subSet(subset, n, 0, 0);
    }

    static void subSet( boolean[] subSet, int n, int i, int count_yes) {
        if (i == n) {
            System.out.print("{");
            i = 1;
            while (count_yes > 1){
                if (subSet[i]) {
                    System.out.print((char) (i + 96) + ", ");
                    count_yes--;
                }
                i++;
            }

            while (i <= n) {
                if (subSet[i]) System.out.print((char) (i + 96));
                i++;
            }
            System.out.println("}");
        }
        else {
            subSet [i + 1] = false;
            subSet(subSet, n, i + 1, count_yes);
            subSet [i + 1] = true;
            subSet(subSet, n, i + 1, count_yes + 1);
        }
    }
}
