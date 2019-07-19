package leetcode;

public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        String s = "    d ddd    ddd";
        System.out.println(s.trim());
        System.out.println(s.split(" ", 0).length);
    }
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int p = 0;
        int end = s.length() - 1;
        for (int i = end; i >= 0 ; i--) {
//            while(s.charAt(i) != ' ')
        }
        return null;
    }
}
