package com.zero.local.leetcode;

/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1Origin = l1;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);
        //System.out.println(l1.next.val);
        //System.out.println(l1Origin.next.val);
        ListNode l2 = new ListNode(5);
        ListNode l2Origin = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1Origin, l2Origin);
        System.out.println(listNode.val);
        while(listNode.next != null){
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int first = l1.val;
        int second = l2.val;
        int indexFirst = 1;
        int indexSecond = 1;
        while((l1=l1.next)!=null){
            first = first + l1.val * (int)Math.pow(10,indexFirst);
            indexFirst++;
        }
        while((l2=l2.next)!=null){
            second = second + l2.val * (int)Math.pow(10,indexSecond);
            indexSecond++;
        }
        int result = first + second;
        char[] resultChar = String.valueOf(result).toCharArray();
        char unitChar = resultChar[resultChar.length - 1];
        int unit = Integer.valueOf(unitChar+"");
        ListNode listNode = new ListNode(unit);
        ListNode resultNode = listNode;
        for(int i=1;i<resultChar.length;i++){
            char charVal = resultChar[resultChar.length-1-i];
            int intVal = Integer.valueOf(charVal+"");
            listNode.next = new ListNode(intVal);
            listNode = listNode.next;
        }
        return resultNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
