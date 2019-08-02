package sword2offer;

/**
 * 将字符串转换成整数
 * 题目描述：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数
 *      数值为0或者字符串不是一个合法的数值则返回0
 */
public class NO_50 {
    private int str2Int(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chs = str.toCharArray();
        int sum = 0;
        int sign = 0;
        boolean flag = false;
        if (chs[0] == '-') {
            sign = 1;
            flag = true;
        }
        if (chs[0] == '+') sign = 1;
        for (int i = sign; i < chs.length; i++) {
            if (chs[i] < 48 || chs[i] > 57) {
                return 0;
            }
            sum = sum * 10 + chs[i] - 48;
        }
        return flag == false ? sum : sum * (-1);
    }
}
