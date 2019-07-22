package sword2offer;

/**
 * 题目描述：对一个有几万人的公司的员工的年龄排序
 *
 * 解题思路：因为年龄都在0~99，所以是一个小范围排序，可以记录下
 *      每个年龄出现的次数，再处理
 *
 * @author 焦含寒
 *
 */
public class NO_7_2 {

    public static void main(String[] args) {
        int[] employeeAge = {22,22,34,23,44,56,28,30,38,22,34,20,34,36};
        try {
            sortAges(employeeAge);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < employeeAge.length; i++) {
            System.out.print(employeeAge[i] + " ");
        }
    }

    private static void sortAges(int[] ages) throws Exception{
        if(ages == null || ages.length == 0)
            return;

        int oldestAge = 99;
        int[] timesOfAge = new int[100];

        for(int i =0;i<timesOfAge.length;i++)
            timesOfAge[i] = 0;


        for(int i = 0;i<ages.length;++i){
            int age = ages[i];
            if(age < 0 || age > oldestAge)
                throw new Exception("年龄超出范围");
            ++timesOfAge[age];
        }

        int index = 0;
        for(int i=0;i<oldestAge;i++){
            for(int j = 0;j<timesOfAge[i];j++){
                ages[index] = i;
                ++index;
            }
        }
    }

}

