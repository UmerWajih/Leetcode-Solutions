package leetcode.questions.x1100.to.x1199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

//https://leetcode.com/problems/analyze-user-website-visit-pattern
public class Problem_1152 {
	private static class Pair{
		public String webiste;
		public int timestamp;
		Pair(String webiste, int timestamp) {
			super();
			this.webiste = webiste;
			this.timestamp = timestamp;
		}
		
	}
	public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		 //adj list
        //user -> list
        //create all tuples possible
        //store them in a map next to count
		
		Map<String, TreeSet<Pair>> map = new HashMap<>();
		
		//here we will have sorted visitations to the website based on time for each user
		for(int i=0; i<username.length; i++) {
			if(!map.containsKey(username[i])) map.put(username[i], new TreeSet<Pair>((a,b)-> a.timestamp - b.timestamp));
			map.get(username[i]).add(new Pair(website[i], timestamp[i]));
		}
		
		Map<List<String>, Integer> tupleCount = new HashMap<>();
		for(String k : map.keySet()) {
			List<String> listOfWebsites = map.get(k).stream().map(c -> c.webiste).collect(Collectors.toList());
			if(listOfWebsites.size() < 3)continue;
			Set<List<String>> tuples = new HashSet<>();
			generateTuples(new ArrayList<>(),  listOfWebsites, tuples, 0);
			for(List<String> l : tuples) {
				tupleCount.put(l, tupleCount.getOrDefault(l, 0)+1);
			}
		}
		
		List<List<String>> output= null;
		int minCount=Integer.MIN_VALUE;

		for(List<String> key : tupleCount.keySet()) {
			if(tupleCount.get(key) > minCount) {
				minCount = tupleCount.get(key);
				output = new ArrayList<>();
				output.add(key);
				continue;
			} 
			
			if(tupleCount.get(key) == minCount) {
				output.add(key);
				continue;
			} 
		}
		
		if(output.size()==1) return output.get(0);
		
		PriorityQueue<String> minHeapForSorting = new PriorityQueue<>();
		
		for(List<String> l : output) {
			minHeapForSorting.add(l.get(0)+"#"+l.get(1)+"#"+l.get(2)) ;
		}
		
		String str = minHeapForSorting.peek();
		List<String> outputList= new ArrayList<>();
		for(String s : str.split("#")) {
			outputList.add(s);
		}
		
		return outputList;
		
    }
	
	
	private static void generateTuples(List<String> list, 
			List<String> listOfWebsites, Set<List<String>> tuples, int index) {
		
		if (list.size() == 3) {
			tuples.add( new ArrayList<>(list));
			
			return;
		}
		
		int size = listOfWebsites.size();
		for(int i=index; i<size; i++) {
			
			list.add(listOfWebsites.get(i));
			generateTuples(list, listOfWebsites, tuples, i+1);
			list.remove(listOfWebsites.get(i));
			
		}
	}
	
	
	
	
}
