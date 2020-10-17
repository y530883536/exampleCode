package leetCode.array;

import java.util.*;

/*
给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:

输入: [1, 2, 2, 3, 1]
输出: 2
解释:
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2:

输入: [1,2,2,3,1,4,2]
输出: 6
注意:

nums.length 在1到50,000区间范围内。
nums[i] 是一个在0到49,999范围内的整数。

*/
public class LeetCode697 {
    public static void main(String[] args) {
        int nums[] = {1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }

    //1：用Map存放出现的数字和对应的次数
    //2：对Entry的value排序（或者直接用Collections.max(Collection)），获取出现次数的最大值
    //3：遍历Map，把相关的key取出来，并找出它们的第一次出现和最后一次出现的位置，最短那个就是答案
    //这里提供一个额外的思路：再加两个HashMap(leftMap和rightMap),分别存放元素和它的firstIndex和lastIndex（在第一次遍历数组就可以做了），最后取出来相减就可以了
    public static int findShortestSubArray(int[] nums) {
        int minArrayLength = Integer.MAX_VALUE;
        Map<Integer,Integer> numTimesMap = new HashMap<>();
        List<Integer> maxTimesNumList = new ArrayList<>();
        for (int num : nums) {
            numTimesMap.put(num, numTimesMap.getOrDefault(num,0)+1);
        }
        int maxTimes = Collections.max(numTimesMap.values());
        for (Map.Entry<Integer, Integer> entry : numTimesMap.entrySet()) {
            if(entry.getValue() == maxTimes) {
                maxTimesNumList.add(entry.getKey());
            }
        }
        for (Integer num : maxTimesNumList) {
            int numMinLength = getLastIndex(nums,num) - getFirstIndex(nums,num) + 1;
            if(numMinLength < minArrayLength) {
                minArrayLength = numMinLength;
            }
        }
        return minArrayLength;
    }

    public static int getFirstIndex(int nums[], int num) {
        for (int i = 0; i < nums.length; i++) {
            if(num == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int getLastIndex(int nums[], int num) {
        for (int i = nums.length-1; i > -1; i--) {
            if(num == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}




















