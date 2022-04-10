public class Q1 {
    static int n;
    static int[] col;
    public static void main(String[] args) {
        n = 12;
        col = new int[n + 1];
        queens(0);
    }

    static boolean queens (int i) {
        boolean b = false;

        if (promising(i)) {
            if (i == n) {
                for (int j = 1; j <= n; j++) System.out.print(col[j] + " ");
                System.out.println();
                return true;
            }
            else {
                for (int j = 1; j <= n; j++) {
                    col[i + 1] = j;
                    if (!b) b  = queens(i + 1);
                }
            }
        }
        return b;
    }

    static boolean promising (int i) {
        int j = 1;
        while (j < i) {
            if (col[i] == col[j] || Math.abs(col[i] - col[j]) == i - j) return false;
            j++;
        }
        return true;
    }
}

