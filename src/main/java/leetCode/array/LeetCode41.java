package leetCode.array;

/*
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

 

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
 

提示：

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。

*/
public class LeetCode41 {

    public static void main(String[] args) {
        int nums[] = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    //本质还是下标负数反转
    //最终结果只会在[1,nums.length+1]这个范围内，这是解题关键
    public static int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        for (int num : nums) {
            if(num == 1) {
                hasOne = true;
                break;
            }
        }
        if(!hasOne) {
            return 1;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= 0 || nums[i] > nums.length) {
                    nums[i] = 1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if(nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
}












