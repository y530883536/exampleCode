package leetCode.array;
/*
给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

示例 1:

输入: [3, 2, 1]

输出: 1

解释: 第三大的数是 1.
示例 2:

输入: [1, 2]

输出: 2

解释: 第三大的数不存在, 所以返回最大的数 2 .
示例 3:

输入: [2, 2, 3, 1]

输出: 1

解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。

*/
public class LeetCode414 {
    public static void main(String[] args) {

    }

    public static int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean hasFirst = false;
        boolean hasSecond = false;
        boolean hasThird = false;
        for (int num : nums) {
            //数字相同的忽略掉
            if(hasFirst && num == first) {
                continue;
            }
            if(hasSecond && num == second) {
                continue;
            }
            if(hasThird && num == third) {
                continue;
            }
            if(num >= first) {
                int firstTemp = first;
                int secondTemp = second;
                first = num;
                if(!hasFirst) {
                    hasFirst = true;
                } else {
                    second = firstTemp;
                    if(!hasSecond) {
                        hasSecond = true;
                    } else {
                        third = secondTemp;
                        hasThird = true;
                    }
                }
                continue;
            }
            if(num >= second) {
                int secondTemp = second;
                second = num;
                if(!hasSecond) {
                    hasSecond = true;
                } else {
                    third = secondTemp;
                    hasThird = true;
                }
                continue;
            }
            if(num >= third) {
                third = num;
                hasThird = true;
            }
        }
        if(!hasThird) {
            return first;
        } else {
            return third;
        }
    }
}
