package leetcode.questions.x600.to.x699;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/
public class Problem_658 {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		// arr = [1,2,3,4,5], k = 4, x = 3
		
		int start=0, end=arr.length-1;
		while(end-start>=k) {
			if(Math.abs(arr[start]-x ) >  Math.abs(arr[end]-x)) {
				start++;
			}else {
				end--;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i= start; i<= end; i++) {
			list.add(arr[i]);
			if(list.size() == k) break;
		}
		return list;
    }
}
