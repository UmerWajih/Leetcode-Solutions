package leetcode.questions;

import leetcode.questions.Common.ListNode;

//https://leetcode.com/problems/partition-list/
public class Problem_86 {

	public static ListNode partition(ListNode head, int x) {
        ListNode before = null;
        ListNode after= null;
        
        
        ListNode returnNode=null, afterStart=null;
        while(head!=null) {
        	ListNode temp = head;
        	head=head.next;
        	if(temp.val < x) {
        		if(before == null) {
        			before = temp;
        			returnNode = temp;
        		}else {
        			before.next=temp;
        			before = before.next;
        		} 
        	}else {
        		if(after == null) {
        			after = temp;
        			afterStart=temp;
        		} else {
        			after.next=temp;
        			after =after.next;
        		} 
        	}
        	temp.next=null;
        }
        if(returnNode == null) return afterStart; //all values are greater than x;
        before.next=afterStart;
        
        return returnNode;
    }
}
