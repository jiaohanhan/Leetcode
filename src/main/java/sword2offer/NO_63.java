package sword2offer;

/**
 * 机器人的运动范围
 */
public class NO_63 {
    public int movingCount(int threshold, int rows, int cols) {
        int[][]  flag = new int[rows][cols];
        return dfs(0, 0, rows, cols, flag, threshold);
    }

    private int dfs(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) {
            return 0;
        }
        return dfs(i - 1, j, rows, cols, flag, threshold)
                + dfs(i + 1, j, rows, cols, flag, threshold)
                + dfs(i, j - 1, rows, cols, flag, threshold)
                + dfs(i, j + 1, rows, cols, flag, threshold);
    }

    private int numSum(int num) {
        int sum = 0;
        do {
            sum += num % 10;
        } while ((num = num / 10) > 0);
        return sum;
    }
}
