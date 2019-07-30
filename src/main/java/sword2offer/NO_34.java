package sword2offer;

/**
 * 丑数
 * 把只包含因子2、3、5的数称作丑数
 *
 */
public class NO_34 {
    public int getUglyNumber(int index){
        if (index < 7) return index;
        int[] ret = new int[index];
        ret[0] = 1;
        int t2 = 0; int t3 = 0; int t5 = 0;
        for (int i = 1; i < index; i++) {
            ret[i] = Math.min(Math.min(ret[t2] * 2, ret[t3] * 3), ret[t5] * 5);
            if (ret[i] == ret[t2] * 2) t2++;
            if (ret[i] == ret[t3] * 3) t3++;
            if (ret[i] == ret[t5] * 5) t5++;
        }
        return ret[index - 1];
    }
}
