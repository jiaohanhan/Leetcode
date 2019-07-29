package sword2offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 * 题目描述：输入一个字符串，按字典序打印出该字符串中字符的所有排列，例如输入字符串adb,
 *  所有排列出来的字符串abc,acb,bac,bca,cab,cba
 *
 *
 */
public class NO_28 {
    public ArrayList<String> permutation(String str){
        ArrayList<String> res = new ArrayList<String>();
        if (str != null && str.length() > 0){
            permutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    private void permutationHelper(char[] chs, int i, ArrayList<String> res) {
        if (chs.length - 1 == i) {
            String val = String.valueOf(chs);
            if (!res.contains(val)) res.add(val);
        } else {
            for (int j = i; j < chs.length; j++) {
                swap(i, j, chs);
                permutationHelper(chs, i + 1, res);
                swap(i, j, chs);
            }
        }
    }

    private void swap(int i, int j, char[] chs) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
