package sword2offer;
/**
 * 题目描述：顺时针打印矩阵
 *      输入一个矩阵，按照从外向里以顺时针的顺序打印出每一个数字
 *      例如，输入矩阵：
 *          1   2   3   4
 *          5   6   7   8
 *          9   10  11  12
 *          13  14  15  16
 *      打印结果：1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10
 *
 * 解题思路：可以矩阵思考成若干的圈，一层嵌套一层。这个问题就变成了两个问题，
 *      一个矩阵应该打印多少圈和每一圈该怎么去打印。先来解决第一个问题，该打
 *      印多少圈？不难发现，每一圈的起点的横纵坐标都是相同的，假设这个矩阵有
 *      rows行，有columns列，当圈数继续进行下去的条件是rows > startX*2 &&
 *      columns > startY*2;再来解决如何打一圈的问题？总共分为四步，第一步
 *      从左到右，第二步从上向下，第三步从右向左，第四步从下到上。注意最后
 *      一圈会退化，可能只会有三步，两步甚至一步。第一步总是需要的，因为打印
 *      一圈至少有一步。需要第二步的前提条件是终止行号大于起始行号，需要第三步
 *      的条件至少有两行两列，也就是除了要求终止行号大于起始行号之外，还需要终
 *      止列号大于起始列号。需要第四步的前提条件是至少三行两列，因此要求终止行
 *      号比起始行号至少大2，同时终止行号大于起始行号。
 *
 */
public class NO_20 {
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        printArray(arr);
        printMatixClockwisely(arr);
    }

    private static void printArray(int[][] arr) {
        for(int i =0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatixClockwisely(int[][] arr){
        if(arr == null)
            return;
        int start = 0;
        while(arr[0].length > start*2 && arr.length > start *2){
            printOneCircle(arr,start);
            start++;
        }
    }

    private static void printOneCircle(int[][] arr, int start) {
        // 打印从坐向右的一行
        for(int i = start;i<arr[0].length-start;i++)
            System.out.print(arr[start][i] + " ");

        //判断并打印从上到下的一列
        if(arr.length-1-start > start){
            for(int i = start+1;i<arr.length-1-start;i++)
                System.out.print(arr[i][arr[0].length-1-start] + " ");
        }

        //判断并打印从左向右的一行
        if(arr[0].length-start-1 > start && arr.length-start-1 >start){
            for(int i=arr.length-1-start;i>start;i--){
                System.out.print(arr[arr.length-1-start][i] +  " ");
            }
        }

        //判断并打印从下到上的一列
        if(arr.length-start-1 >start && arr[0].length-start-1 > start  ){
            for(int i=arr.length-1-start;i>start;i--){
                System.out.print(arr[i][start] +  " ");
            }
        }
    }
}

