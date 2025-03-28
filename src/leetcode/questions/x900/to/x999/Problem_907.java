package leetcode.questions.x900.to.x999;

//https://leetcode.com/problems/sum-of-subarray-minimums
public class Problem_907 {
	
	public static int sumSubarrayMins(int[] arr) {
		int mod = (int) 1e9 + 7;
		int sum=0;
		
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
			sum%=mod;
			int min= arr[i];
			for(int j=i+1; j<arr.length; j++) {
				min = Math.min(min, arr[j]);
				sum+=min;
				sum%=mod;
			}
		}
		
		
		return sum;
    }
}
