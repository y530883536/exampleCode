package leetCode.array;

import java.util.Arrays;

/*
给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。

 

示例:

输入:
[1,2,3]

输出:
3

解释:
只需要3次移动（注意每次移动会增加两个元素的值）：

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

*/
public class LeetCode453 {

    public static void main(String[] args) {
        int nums[] = {1,3,5,9};
        System.out.println(minMoves1(nums));
    }

    //1.排序法（具体要去看LeetCode里的解释）
    public static int minMoves1(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length-1; i > 0; i--) {
            count = count + (nums[i] - nums[0]);
        }
        return count;
    }

    //2.数学法（思路及其巧妙）
    //将除一个元素之外的全部元素+1，等价于将该元素-1，所以本质就是除了最小的数，其他数减到最小数所需要的次数
    public static int minMoves2(int[] nums) {
        //先找出数组里的最小值，可以直接用sort，但是时间复杂度就大了，线性遍历一次数组即可
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int num : nums) {
            if(num < min) {
                min = num;
            }
        }
        for (int num : nums) {
            count = count + (num - min);
        }
        return count;
    }
}
