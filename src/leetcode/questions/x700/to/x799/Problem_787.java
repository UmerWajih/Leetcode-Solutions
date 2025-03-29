package leetcode.questions.x700.to.x799;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/cheapest-flights-within-k-stops
public class Problem_787 {
	
	private static class Tracker{
		public int getLocation() {
			return location;
		}
		public int getCost() {
			return cost;
		}
		public Set<Integer> getPastLocations() {
			return pastLocations;
		}
		int location;
		int cost;
		Set<Integer> pastLocations;
		
		Tracker(int location, int cost, Set<Integer> pastLocations){
			this.location=location;
			this.cost=cost;
			this.pastLocations=pastLocations;
					
		}
		
	}
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		//create adjacency list
		Map<Integer, List< Integer[]>> map =new HashMap<>();
		
		for(int[] i : flights ) {
			if(!map.containsKey(i[0]))map.put(i[0], new ArrayList<>());
			map.get(i[0]).add(new Integer[] {i[1],i[2]});
		}
		
		Queue<Tracker> q = new LinkedList<>();
		Set<Integer>set = new HashSet<>();
		set.add(src);
		q.add(new Tracker (src,0, set) );		
		
		int minCost=Integer.MAX_VALUE, stops=0;
		
		while(!q.isEmpty()) {
			if(stops > k) break;
			
			int currentQueueSize  = q.size();
			
			for(int i=0; i < currentQueueSize; i++) {
				Tracker output = q.poll();
				int source = output.getLocation();
				int currentCost=output.getCost();
				Set<Integer> pastDestination = output.getPastLocations();//for cyclic dependencies
				
				if(map.containsKey(source)) {
					List< Integer[]> destinations = map.get(source);
					
					for(Integer[] j : destinations) {
						if(pastDestination.contains(j[0]))continue;
						
						if(j[0] == dst) {
							minCost = Math.min(minCost, currentCost + j[1]);
							continue;
						}
						
						Set<Integer>newSet = new HashSet<>(pastDestination);
						newSet.add(j[0]);
						q.add(new Tracker (j[0],currentCost + j[1], newSet) );
					}
					
					
				}
				
			}	
			stops++;
		}
		
		
		return minCost==Integer.MAX_VALUE ? -1 : minCost;
		
    }
}
