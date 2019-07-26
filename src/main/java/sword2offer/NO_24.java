package sword2offer;
/**
 * 题目描述：二叉搜索树的后序遍历
 *      输入一个整数数组，判断该数组是不是某个二叉搜索树的后续遍历的结果。
 *      如果是则返回true，否则返回false。假设输入的数组的任意两个数字都
 *      互不相同。
 *
 * 解题思路：后序遍历的序列中，最后一个数字是树的根结点的值。数组中前面的
 *      数字可以分为两部分：第一部分是左子树结点的值，它们都比根结点的值小
 *      ；第二部分是右子树结点的值，它们都比根结点的值大。
 *
 *
 */
public class NO_24 {

    public static void main(String[] args) {
        int[] arr = {5,7,6,9,11,10,8};
        System.out.println(verifySequenceOfBST(arr, 0, arr.length-1));

    }

    private static boolean verifySequenceOfBST(int[] arr,int start,int end){
        if(arr == null || arr.length == 0
                || start > end || start < 0 || end <0)
            return false;

        if(start == end)
            return true;

        int root = arr[end];
        int i = start;
        for(;i<=end;i++){
            if(arr[i] > root)
                break;
        }
        int j = i;
        for(;j<=end;j++){
            if(arr[j]<root)
                return false;
        }
        boolean left = true;
        if(i>start){
            left=verifySequenceOfBST(arr, start, i-1);
        }
        boolean right = true;
        if(i<end){
            right = verifySequenceOfBST(arr, i, end-1);
        }

        return left&&right;
    }
}

