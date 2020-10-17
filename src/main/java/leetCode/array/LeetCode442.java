package leetCode.array;

import java.util.*;

/*
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]
*/
public class LeetCode442 {

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,3,2,1};
        findDuplicates2(nums);
    }

    //最简单的解决方案，但耗时极长
    public static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (!numSet.add(num)) {
                resultList.add(num);
            }
        }
        Collections.sort(resultList);
        return resultList;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        //leetCode上面的答案不需要sort，也是奇怪
        Arrays.sort(nums);
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                resultList.add(Math.abs(nums[i]));
            }
        }
        return resultList;
    }

}
