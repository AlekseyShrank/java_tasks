package leetCode;
/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
*/

public class ReverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int listLenght = 0;
        ListNode q = head;
        while (q != null) {
            listLenght++;
            q = q.next;
        }
        ListNode startNextNodeK = head;
        ListNode newHead = null;

        for (int c = 0; c < listLenght/k; c++) {

            ListNode[] kArr = new ListNode[k];
            takeK(startNextNodeK, kArr);
            ListNode[] endKArr = new ListNode[k];
            startNextNodeK = kArr[k-1].next;
            for (int i = 0; i < k; i++) {
                endKArr[i] = kArr[k-1-i];
            }

            for (int i = 0; i < k-1; i++) {
                endKArr[i].next = endKArr[i+1];
            }

            if(c != (listLenght/k)-1 ){
                ListNode l = startNextNodeK;
                for(int j = 1; j < k; j++){
                    l = l.next;
                }
                endKArr[k-1].next = l;
            }else {
                endKArr[k-1].next = startNextNodeK;
            }

            if(newHead == null){
                newHead = endKArr[0];
            }
        }

        return newHead == null ? head : newHead;
    }

    public static void takeK(ListNode head, ListNode[] kArr) {
        kArr[0] = head;
        for (int i = 1; i < kArr.length; i++) {
            kArr[i] = kArr[i-1].next;
        }
    }

    public static void printList(ListNode head) {
        System.out.println(" ");
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static ListNode setList(String s) {
        ListNode head = new ListNode(s.charAt(0)-'0');
        ListNode p = head;
        for (int i = 1; i < s.length(); i++) {
            p.next = new ListNode(s.charAt(i)-'0');
            System.out.println();
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = setList("12345");
        printList(head);
        printList(reverseKGroup(head, 5));
    }
}
