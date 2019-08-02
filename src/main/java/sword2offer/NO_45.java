package sword2offer;

/**
 * 翻转单词顺序列
 * 题目描述：I am a student. --> student. a am I
 */
public class NO_45 {
    public String reverseSentence(String str){
        if (str == null || str.trim().length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split(" ");
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (i != len - 1){
                sb.append(String.valueOf(strs[len - 1 - i])).append(" ");
            }else {
                sb.append(String.valueOf(strs[len - 1 - i]));
            }
        }
        return sb.toString();
    }
}
