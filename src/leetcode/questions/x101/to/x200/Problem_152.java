package leetcode.questions.x101.to.x200;

//https://leetcode.com/problems/maximum-product-subarray/
public class Problem_152 {

	public int maxProduct(int[] nums) {
		int max=Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			int current = nums[i];
			max=Math.max(current, max);
			for(int j=i+1; j<nums.length; j++) {
				current*=nums[j];
				max=Math.max(current, max);
			}
		}
		return max;
    }
}
