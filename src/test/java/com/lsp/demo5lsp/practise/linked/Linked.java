package com.lsp.demo5lsp.practise.linked;

public class Linked {

    /**
     * 递归法翻转单链表
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = reverseList1(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 遍历法翻转单链表
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        ListNode newHead = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        head.next = a;
        a.next = b;
        /*while(head != null){
            System.out.print(head.getValue()+">");
            head = head.next;
        }*/
        //ListNode temp = a;
        //System.out.print(temp);
        ListNode reverse = reverseList2(head);
        System.out.print(reverse);
    }
}
