import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        dfs(s, res, new ArrayList<String>(), 0);
        return res;
    }

    private void dfs(String s, List<List<String>> res, ArrayList<String> list, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                list.add(s.substring(i, j + 1));
                dfs(s, res, list, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end){
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
