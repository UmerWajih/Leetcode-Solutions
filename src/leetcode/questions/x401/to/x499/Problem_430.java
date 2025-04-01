package leetcode.questions.x401.to.x499;

public class Problem_430 {
	static class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	    public Node(int val) {
	        this.val = val;
	    }
	};
	
	
	public static Node buildTestCase() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        // First level
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;

        // Child of 3
        n3.child = n7;
        n7.next = n8;
        n8.prev = n7;

        // Child of 5
        n5.child = n9;
        n9.next = n10;
        n10.prev = n9;

        // Child of 8
        n8.child = n11;
        n11.next = n12;
        n12.prev = n11;

        return flatten(n1);
    }
	
	public static Node flatten(Node head) {
        Node node = head;
        recusivelyFlattenChild(head, null);
        
        while (node != null) {
			System.out.print("Prev:"+ (node !=null && node.prev!=null ? node.prev.val:""));
			System.out.print("-  Val:"+ node.val);
			System.out.print("-  Next:"+(node !=null && node.next!=null?node.next.val:""));
			System.out.println();
			node = node.next;
		}
        
        return node;
    }
	
	
	private static void recusivelyFlattenChild(Node node, Node nextNode) {
		while (node != null) {
			if(node.val==7)
				System.out.println();
			if (node.child != null) {
				node.child.prev=node;
				recusivelyFlattenChild(node.child, node.next);
				node.next=node.child;
				node.child=null;
			}
			if(node.next ==null) {
				node.next=nextNode;
				if (nextNode!=null)nextNode.prev=node;
				return;
			} 
			node = node.next;
		}
	}
}
