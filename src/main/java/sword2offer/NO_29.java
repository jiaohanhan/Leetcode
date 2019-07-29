package sword2offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 *
 */
public class NO_29 {
    // 无聊的人总喜欢用统计各个数字出现的次数
    public int moreThanHalfNum(int[] array) {
        if (array.length == 1) return array[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int halfLen = array.length / 2;
        for (int num : array) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
                if(map.get(num) > halfLen )
                    return num;
            }
        }
        return 0;
    }

    /**
     * 遇到相同元素 count++
     * 遇到不同元素 count--， 当减到0的时候，重新count = 1
     */
    public int moreThanHalfNum_(int[] array){
        if (array.length == 1) return array[0];
        int result = array[0];
        int counter = 0;
        for (int num : array) {
            if (counter == 0) {
                result = num;
                counter = 1;
            } else if (result == num) {
                counter++;
            }else{
                counter--;
            }
        }
        // 二次确认
        counter = 0;
        for (int i = 0; i < array.length; i++) {
            if(result == array[i]) counter++;
        }
        if(counter * 2 <= array.length) result = 0;
        return result;
    }
}


