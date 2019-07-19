package leetcode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        for (int i : relativeSortArray(arr1, arr2)) {
            System.out.print(i + " ");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr1) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int num : arr2) {
            if (map.containsKey(num)) {
                int cnt = map.get(num);
                while (cnt-- > 0) res.add(num);
                map.put(num, 0);
            }
        }
        for (int num : arr1) {
            if(!res.contains(num))
                list.add(num);
        }
        Collections.sort(list);
        for (int num : list) {
            res.add(num);
        }
        int[] ans = new int[res.size()];
        int count = 0;
        for (int num : res) {
            ans[count++] = num;
        }
        return ans;
    }
}
