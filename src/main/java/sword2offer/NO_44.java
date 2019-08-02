package sword2offer;

/**
 * 左旋转字符串
 * 题目描述：对于给定的字符序列S，输出循环左移K位后的序列
 */
public class NO_44 {
    public String leftRotateString(String str, int n) {
        if(str == null || str.length() == 0) return str;
        int k = n % str.length();
        return str.substring(k, str.length()) + str.substring(0, k);
    }
}
