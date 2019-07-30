package sword2offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * 在一个字符串中找到第一个只出现一次的字符。并返回它的位置
 */
public class NO_35 {
    public int firstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) return -1;
        Map<Character, Integer> map = new LinkedHashMap();
        for (char ch : str.toCharArray()) {
            if(map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }
        for (char key : map.keySet()) {
            if(map.get(key) == 1) return str.indexOf(key);
        }
        return -1;
    }
}
