package leetCode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
* */




public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans;
        int val = (l1.val+l2.val)%10;
        int upsum = (l1.val+l2.val)/10;
        if(l1.next == null && l2.next == null){
            if (upsum>0){
                ans = new ListNode(val,new ListNode(upsum));
                return ans;
            } else {
                ans = new ListNode(val);
                return ans;
            }
        }
        if(l1.next == null){
            ans = new ListNode(val,addTwoNumbers(new ListNode(upsum),l2.next));
            return ans;
        }
        if (l2.next == null){
            ans = new ListNode(val,addTwoNumbers(l1.next,new ListNode(upsum)));
            return ans;
        }
        l1.next.val += upsum;

        ans = new ListNode(val,addTwoNumbers(l1.next,l2.next));

        return ans;
    }

    public static void printList(ListNode l){
        System.out.print(l.val + " ");
        if(l.next != null){
            printList(l.next);
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));

        printList(addTwoNumbers(l1,l2));
    }

}
