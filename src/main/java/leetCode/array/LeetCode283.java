package leetCode.array;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
*/
public class LeetCode283 {

    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println("aaa");
    }

    //比较傻的方法，时间复杂度高
    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                continue;
            }
            for(int j=i+1;j< nums.length;j++) {
                if(nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
            }
        }
    }

    //1.首先遍历数组，遇到非0元素就放到数组最左边，然后nonZeroNum++;
    //2.第一遍遍历完之后，所有非0元素都存到最左边了，接着从nonZeroNum开始遍历数组，把后面的元素全部置0就可以了
    public static void moveZeroes2(int[] nums) {
        int nonZeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonZeroNum] = nums[i];
                nonZeroNum++;
            }
        }
        for (int i = nonZeroNum; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
