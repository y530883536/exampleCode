package leetCode.array;

import java.util.Arrays;

/*
给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数 不超过 h 次。）

例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。

 

示例：

输入：citations = [3,0,6,1,5]
输出：3
解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 

提示：如果 h 有多种可能的值，h 指数是其中最大的那个。
*/
public class LeetCode274 {

    public static void main(String[] args) {
        int[] nums = {3,0,6,1,5};
        hIndex(nums);
    }

    //从最大引用次数没max开始倒序遍历数组，看之前是否有max个元素的引用次数大于等于max
    public static int hIndex(int[] citations) {
        if(citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int times = citations[citations.length-1];
        if(times == 0) {
            return 0;
        }
        for(int i=times-1;i>-1;i--) {
            if(i > citations.length - 1) {
                continue;
            }
            //i+1就是引用次数
            if(citations[citations.length-1-i] >= i+1) {
                return i+1;
            }
        }
        return 0;
    }
}
