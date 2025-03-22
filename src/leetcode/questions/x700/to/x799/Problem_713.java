package leetcode.questions.x700.to.x799;

//https://leetcode.com/problems/subarray-product-less-than-k
public class Problem_713 {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0;
        int count=0;
        for(int i=0; i<nums.length;i++) {
        	if(nums[i] < k) count++;
        	else {
        		start=i+1;
        		continue;
        	}
        	
        	int index=i-1, product=nums[i];
        	while(index >=start) {
        		product*=nums[index];
        		if(product < k) {
        			count++;
        		}else {
        			start=index+1;
        			break;
        		}
        		index--;
        	}
        	
        	
        }
        return count;
        
    }
}
