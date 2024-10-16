package leetcode.questions;

public class Common {

	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode() {
		}
		public ListNode(int val) {
			this.val = val;
		}
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
