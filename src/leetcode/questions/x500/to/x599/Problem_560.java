package leetcode.questions.x500.to.x599;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k
public class Problem_560 {
	
	public int subarraySum(int[] nums, int k) {
        //create a map
		//this map will contains sum, and its number of occurances
		Map<Integer, Integer> map= new HashMap<>();
		
		int count =0;
		
		//to start of our sum will be 0 so this will automatically be 1
		int sum=0;
		map.put(0, 1);
		
		for(int i=0;i<nums.length;i++) {
			//add current value to sum
			sum+=nums[i];
			//now we need to check if difference between sum and k exists
			//the number of occurances will be added to count
			if(map.containsKey(sum-k)) {
				count+=map.get(sum-k);
			}
			map.put(sum,map.getOrDefault(sum,0)+1);
		}
		
		return count;
    }
	
	

}
