import java.util.Scanner;

public class P2 {
    static int part;
    static int[][] matrix;
    static String[][] part_capsules;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt(), col = input.nextInt();
        matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String s = input.next();
                if (!s.equals("-")) matrix[i][j] = Integer.parseInt(s);
            }
        }
        part = input.nextInt();
        part_capsules = new String[part][];
        for (int i = 0; i < part; i++) {
            part_capsules[i] = new String[input.nextInt()];
            for (int j = 0; j < part_capsules[i].length; j++) part_capsules[i][j] = input.next();

        }
        capsule(0, 0);
    }

    static void capsule (int i, int j) {
        if (i == part) {
            for (int[] ints : matrix) {
                for (int k = 0; k < ints.length - 1; k++) System.out.print(ints[k] + " ");
                System.out.println(ints[ints.length - 1]);
            }
        }
        else if (j == part_capsules[i].length) capsule(i + 1, 0);
        else {
            int index_row = part_capsules[i][j].charAt(1) - 49, index_col = part_capsules[i][j].charAt(3) - 49;
            int val = matrix[index_row][index_col];
            if (matrix[index_row][index_col] != 0) capsule(i, j + 1);
            else for (int k = 1; k <= part_capsules[i].length; k++) {
                if (promising1(i, j, k)) capsule(i, j + 1);
            }
            matrix[index_row][index_col] = val;
        }
    }

    static boolean promising1 (int part, int i, int val) {
        int index_row = part_capsules[part][i].charAt(1) - 49, index_col = part_capsules[part][i].charAt(3) - 49;
        for (int j = 0; j < part_capsules[part].length; j++) {
            if (i != j) {
                int ind_row = part_capsules[part][j].charAt(1) - 49, ind_col = part_capsules[part][j].charAt(3) - 49;
                if (matrix[ind_row][ind_col] == val) return false;
            }
        }
        if (promising2(index_row, index_col, val)) {
            matrix[index_row][index_col] = val;
            return true;
        }
        return false;
    }

    static boolean promising2 (int row, int col, int val) {
        return (0 > col - 1 || matrix[row][col - 1] == 0 || val != matrix[row][col - 1])
                && (col + 1 >= matrix[row].length || matrix[row][col + 1] == 0 || val != matrix[row][col + 1])
                && (0 > row - 1 || ((matrix[row - 1][col] == 0 || val != matrix[row - 1][col])
                && (0 > col - 1 || matrix[row - 1][col - 1] == 0 || val != matrix[row - 1][col - 1])
                && (col + 1 >= matrix[row].length || matrix[row - 1][col + 1] == 0 || val != matrix[row - 1][col + 1])))
                && (row + 1 >= matrix.length || ((matrix[row + 1][col] == 0 || val != matrix[row + 1][col])
                && (0 > col - 1 || matrix[row + 1][col - 1] == 0 || val != matrix[row + 1][col - 1])
                && (col + 1 >= matrix[row].length || matrix[row + 1][col + 1] == 0 || val != matrix[row + 1][col + 1])));
    }
}