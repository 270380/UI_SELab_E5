///test branch
import java.util.Scanner;

public class MaximumSubArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt(), first, last, compare;
        long sub_array;

        int[] arr = new int[n * k];
        long[] sum = new long[n * k];
        sub_array = 0;
        first = last = -1;
        compare = -10000;

        for (int j = 0; j < n; j++) {
            arr[j] = input.nextInt();
            if (0 < arr[j]) {
                if (first == -1) {
                    first = last = j;
                    sub_array = sum[first] = arr[j];
                } else last = j;
            } else if (compare < arr[j]) compare = arr[j];
        }

        int l = n, z = 0;
        while (0 < k - 1) {
            arr[l++] = arr[z++];
            if (0 < arr[l - 1]) last = l - 1;
            else if (compare < arr[l - 1]) compare = arr[l - 1];
            if (z == n) {
                z = 0;
                k--;
            }
        }

        if (first == -1) sub_array = compare;
        else {
            for (int j = first + 1; j <= last; j++) {
                sum[j] = sum[j - 1] + arr[j];
                if (sum[j] < arr[j]) sum[j] = arr[j];
                if (sub_array < sum[j]) sub_array = sum[j];
            }
        }
        System.out.println(sub_array);

    }
}
