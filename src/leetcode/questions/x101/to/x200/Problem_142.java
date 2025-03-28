package leetcode.questions.x101.to.x200;

import java.util.HashSet;

import leetcode.questions.Common.ListNode;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class Problem_142 {
	public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head))return head;
            set.add(head);
            head=head.next;
        }
        return head;
    }
}
