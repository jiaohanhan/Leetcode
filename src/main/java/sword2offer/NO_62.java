package sword2offer;

/**
 * 矩阵中的路径
 * 题目描述：判断一个矩阵中是否存在一条包含某字符串所有字符的路径
 */
public class NO_62 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int idx = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols
                || matrix[idx] != str[k] || flag[idx] == 1) {
            return false;
        }
        if (k == str.length - 1) return true;
        if (dfs(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || dfs(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || dfs(matrix, rows, cols, i, j - 1, str, k, flag)
                || dfs(matrix, rows, cols, i, j + 1, str, k + 1, flag)
        ) {
            return true;
        }
        flag[idx] = 0;
        return false;
    }
}
