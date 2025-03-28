package leetcode.questions.x300.to.x400;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class Problem_300 {

	public static int lengthOfLIS(int[] nums) {
        int maxValue= getMaximumLen(nums,0, 0,Integer.MIN_VALUE, 1);
        return maxValue== Integer.MIN_VALUE ? 1 : maxValue;
    }
	
	
	private static int getMaximumLen(int[] nums, int startIndex, int secondIndex, int maxLen, int curLen) {
		if(startIndex>=nums.length) return maxLen;
		
		for(int i=secondIndex+1; i<nums.length ; i++) {
			if(nums[i] <= nums[secondIndex]) continue;
			maxLen =Math.max(maxLen, getMaximumLen(nums,startIndex, i, maxLen, curLen+1));
		}
		if(secondIndex != startIndex) return Math.max(maxLen,curLen);
		while(startIndex+1 < nums.length &&  nums[startIndex+1] > nums[startIndex])startIndex++;
		return getMaximumLen(nums, startIndex+1,startIndex+1, maxLen, 1);
	}
}
