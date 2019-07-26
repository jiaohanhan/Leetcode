package sword2offer;
import java.util.Stack;

/**
 * 题目描述：栈的压入、弹出序列
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出
 *      顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、5是某粘的压栈序列，序列
 *      4、5、3、2、1是该压栈序列对应的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列
 *      的弹出序列。
 *
 * 解题思路：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶
 *      就把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
 *      如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
 *
 */
public class NO_22 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,3,5,2,1};
        int[] arr3 = {4,3,5,1,2};
        System.out.println(isPopOrder(arr1, arr2));
        System.out.println(isPopOrder(arr1, arr3));
    }

    private static boolean isPopOrder(int[] arr1,int[] arr2){
        if(arr1 == null || arr2 == null)
            return false;

        int point1 = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0;i<arr2.length;i++){
            if(!stack.isEmpty() && stack.peek() == arr2[i]){
                stack.pop();
            }else{
                if(point1 == arr1.length)
                    return false;
                else{
                    do{
                        stack.push(arr1[point1++]);
                    }while(stack.peek()!=arr2[i] && point1 != arr1.length);
                    if(stack.peek() == arr2[i])
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
