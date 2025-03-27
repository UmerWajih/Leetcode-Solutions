package leetcode.questions.x1000.to.x1099;


//https://leetcode.com/problems/max-consecutive-ones-iii/
public class Problem_1004 {
	public static int longestOnes(int[] nums, int k) {
        int len=0, maxLen=0;
        int startIndex=0, availableFlips=k, secondIndex=0;
        
        while(startIndex < nums.length) {
        	int i=secondIndex;
        	for(; i<nums.length ;i ++ ) {
        		if(nums[i]==1) len++;
        		else if(availableFlips > 0) {
        			len++;
        			availableFlips--;
        			startIndex=i;
        		}else {
        			break;
        		}
        	}
        	
        	maxLen=Math.max(maxLen, len);
        	availableFlips=k;
        	len=0;
        	if(i==nums.length) break;
        	//secondIndex++;
        	if(nums[secondIndex] == 0)secondIndex++;
        	else {
        		while(nums[secondIndex]==1)secondIndex++;
        	}
        	
        }
        
        
        return maxLen;
    }
}
