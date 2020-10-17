package leetCode.array;

import java.util.*;

/*
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]

*/
public class LeetCode448 {

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers2(nums));
    }

    //不用说明，代码很好懂
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            //如果插入成功说明丢失了这个数字
            if(numSet.add(i+1)) {       //!numSet.contain(i+1)  这个的效率稍微好一点，但差不了太多
               resultList.add(i+1);
            }
        }
        return resultList;
    }

    //这种解法很巧妙，但是很难说明，看不懂去leetCode看图解吧，非常有趣的解题思路
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                resultList.add(i+1);
            }
        }
        return resultList;
    }
}
