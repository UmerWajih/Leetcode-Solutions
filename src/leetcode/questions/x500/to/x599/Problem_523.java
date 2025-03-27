package leetcode.questions.x500.to.x599;

import java.util.HashMap;

//https://leetcode.com/problems/continuous-subarray-sum
public class Problem_523 {

	public boolean checkSubarraySum(int[] nums, int k) {
//		int sum = 0;
//		Set<Integer> set = new HashSet<>();
//		set.add(0);
//		for (int i : nums) {
//			sum += i;
//			int multiplier = 1;
//			while (sum - (k * multiplier) >= 0) {
//				if (set.contains(sum - (k * multiplier)))return true;
//				multiplier++;
//			}
//		}
//		return false;
		
		int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum % k == 0 && i > 0) 
                return true;
            if (map.containsKey(sum % k) && i - map.get(sum % k) >= 2)
                return true;
            
            if (!map.containsKey(sum % k))
                map.put(sum % k, i);
        } 
        
        return false;

	}
}
