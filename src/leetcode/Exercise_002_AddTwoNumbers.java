package leetcode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

import java.util.List;

public class Exercise_002_AddTwoNumbers {
    int carry;

    public static void main(String[] args){
        final  ListNode testData1 = new ListNode(2, new ListNode(3, new ListNode(5)));
        final  ListNode testData2 = new ListNode(3, new ListNode(1, new ListNode(9)));
        ListNode result = new Exercise_002_AddTwoNumbers().addTwoNumbers(testData1, testData2);
        String resultString = "";
        do{
            resultString  = resultString.concat(Integer.toString(result.val));
            result = result.next;
        }
        while(result != null);

        System.out.println(resultString);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if(l1 == null && l2 == null) {
            if(carry == 1)
                return new ListNode(1);
            return null;
        }
        else if(l1 == null)
            l1 = new ListNode();
        else if(l2 == null)
            l2 = new ListNode();

        int valSum = l1.val + l2.val + carry;
        this.carry = valSum / 10;
        return new ListNode(valSum % 10, this.addTwoNumbers(l1.next, l2.next));
    }


}

class ListNode{
    int val;
    ListNode next;

    public ListNode(){
    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

