package leetcode;

/**
 * 遍历，八个方向都用if判断太麻烦了，设置偏移标志数组
 */
public class ImageSmoother_661 {
    int row = 0;
    int col = 0;

    public int[][] imageSmoother(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) return null;
        row = matrix.length;
        col = matrix[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = calc(matrix, i, j);
            }
        }
        return res;
    }
    // 上、下、左、右、上左、上右、下左、下右
    int[] dirR = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dirC = {0, 0, -1, 1, -1, 1, -1, 1};
    private int calc(int[][] matrix, int i, int j) {
        int count = 1;
        int sum = matrix[i][j];
        for (int k = 0; k < dirR.length; k++) {
            int x = i + dirR[k];
            int y = j + dirC[k];
            if (x >= 0 && x < row && y >= 0 && y < col) {
                count++;
                sum += matrix[x][y];
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] res = new ImageSmoother_661().imageSmoother(M);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] imageSmoother1(int[][] M) {
        if(M == null) return null;
        int lenRow = M.length;
        int lenCol = M[0].length;
        int[][] res = new int[lenRow][lenCol];
        for (int i = 0; i < lenRow; i++) {
            for (int j = 0; j < lenCol; j++) {
                int sum = 0;
                int count = 1;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sum += M[i - 1][j - 1];
                    count++;
                }
                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                if (i + 1 < lenRow && j - 1 >= 0) {
                    sum += M[i + 1][j - 1];
                    count++;
                }
                if (i - 1 >= 0) {
                    sum += M[i - 1][j];
                    count++;
                }
                if (i + 1 < lenRow) {
                    sum += M[i + 1][j];
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < lenCol) {
                    sum += M[i - 1][j + 1];
                    count++;
                }
                if (j + 1 < lenCol) {
                    sum += M[i][j + 1];
                    count++;
                }
                if (i + 1 < lenRow && j + 1 < lenCol) {
                    sum += M[i + 1][j + 1];
                    count++;
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
