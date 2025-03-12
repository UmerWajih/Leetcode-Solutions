package leetcode.questions.x101.to.x200;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer
public class Problem_138 {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyRandomList(Node head) {
		if(head==null) return null;
		Map<Node, Node> map =new HashMap<>();
		
		Node node = new Node(head.val);
		map.put(head, node);
		
		Node startNode= node, startHead=head, returnNode=node; 
		
		head=head.next;		
		while(head!=null) {
			node.next=new Node(head.val);
			node=node.next;
			map.put(head, node); //map will now have all of its copy ref
			head=head.next;
		}
		
		node = startNode; head=startHead; 
		while(head!=null) {
			if(head.random!=null) {
				node.random= map.get(head.random);
			}
			node=node.next;
			head=head.next;
		}
		
		
		
		
		return returnNode;
    }

}
