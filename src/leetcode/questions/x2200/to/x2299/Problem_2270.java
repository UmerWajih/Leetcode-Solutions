package leetcode.questions.x2200.to.x2299;

//https://leetcode.com/problems/number-of-ways-to-split-array/
public class Problem_2270 {
	public int waysToSplitArray(int[] nums) {
        
		for(int i=1; i< nums.length; i++) {
        	nums[i] = nums[i]+nums[i-1];
        }
		
		int count=0;
		
		for(int i=0; i< nums.length-1; i++) {
        	if(nums[i] >= nums[nums.length-1] -nums[i] ) count++;
        }
		return count;
    }
}
