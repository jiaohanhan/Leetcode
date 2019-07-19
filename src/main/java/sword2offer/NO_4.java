package sword2offer;
/**
 * 问题描述：请实现一个函数，把字符串中的每个空格替换成"%20".
 *          输入："We are happy"
 *          输出："We%20are%20happy"
 *
 * 解题思路：先通过一次遍历字符串计算出含有的空格数，然后new一个数组
 *          长度为原数组的字符串长度+空格数*2，因为一个"%20"等于3空
 *          格字符的长度；然后就逆序把字符串拷贝到数组中，每遇到空格
 *          就用"%20"替换
 *
 * 解题思路二：可以直接用StringBuilder，在O(n)时间就能完成
 *
 */
public class NO_4 {

    public static void main(String[] args) {
        String s = "we are happy";
        char[] charArr = s.toCharArray();
        System.out.println(change1(charArr));
        System.out.println(change2(s));
    }

    private static String change1(char[] charArr) {
        // 统计空格数
        int count = 0;
        for (int i = 0; i < charArr.length; i++)
            if (charArr[i] == ' ')
                count++;
        // 容错处理
        if (count == 0) return null;
        char[] temp = new char[charArr.length + 2 * count];
        // 返回结果的尾指针
        int j = temp.length - 1;
        // 原字符串的尾指针
        int i = charArr.length - 1;
        while (i >= 0) {
            if (charArr[i] == ' ') {
                temp[j] = '0';
                temp[j - 1] = '2';
                temp[j - 2] = '%';
                j = j - 3;
            } else {
                temp[j] = charArr[i];
                j--;
            }
            i--;    // i--要放在判定条件的外面，i是扫描指针
        }
        return new String(temp);
    }

    private static String change2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
