package leetcode.questions.x800.to.x899;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_857 {
	//https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
	
	
	public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {		
		double[][] workers = new double[quality.length][2];

		for (int i = 0; i < quality.length; i++) {
		    workers[i][0] = (double) wage[i] / quality[i];  // wageQualityRatio
		    workers[i][1] = quality[i];                    // quality
		}

		Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 
		int qualitySum = 0;
		double minCost = Double.MAX_VALUE;

		
		for (double[] worker : workers) {
		    maxHeap.add((int) worker[1]);  // Add current quality to the heap
		    qualitySum += worker[1];       // Update the total quality sum

		    if (maxHeap.size() > k) {      // If more than k workers, remove the largest quality
		        qualitySum -= maxHeap.poll();
		    }

		    if (maxHeap.size() == k) {     // When exactly k workers are in the heap
		        minCost = Math.min(minCost, qualitySum * worker[0]);
		    }
		}

		return minCost;
    }
}
