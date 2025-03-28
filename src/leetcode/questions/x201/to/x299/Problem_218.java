package leetcode.questions.x201.to.x299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_218 {
	public static List<List<Integer>> getSkyline(int[][] buildings) {
        //max height =0
        //10

        //if in a map we put start and end against index
        //then we can take out size

		
		
		Integer[][] buildingCount = new Integer[buildings.length * 2][];
		
		int index=0;
		Map<Integer[], Integer> map = new HashMap<>();
		
		for(int [] val : buildings) {
			buildingCount[index]= new Integer[]{val[0],1, val[2]};
			map.put(buildingCount[index], val[2]);
			index++;
			
			buildingCount[index]= new Integer[]{val[1],-1, val[2]};
			map.put(buildingCount[index], val[2]);
			index++;
		}
		
		Arrays.sort(buildingCount, (a, b) -> {
            int primaryComparison = Integer.compare(a[0], b[0]);
            return primaryComparison != 0 ? primaryComparison : 
            	Integer.compare(b[1], a[1] ) != 0 ? Integer.compare(b[1], a[1] ) : 
            		a[1]==-1 ? Integer.compare(a[2], b[2] ) :Integer.compare(b[2], a[2] );
        });
		//this will have len of building
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		List<List<Integer>> output = new ArrayList<>();
		
		for(Integer[] building : buildingCount) {
			if(building[1]==1) {
				if(queue.isEmpty() || map.get(building) > queue.peek()){
					output.add(Arrays.asList(building[0],map.get(building)));
				}
				queue.add(map.get(building));
			}else {
				int val = map.get(building);
				int val2=queue.peek();
				if(val ==val2) {
					queue.poll();
					if(queue.isEmpty())output.add(Arrays.asList(building[0],0));
					else if(queue.peek() != map.get(building)) {
						val2=queue.peek();
						output.add(Arrays.asList(building[0],val2));
					}
				}else {
					queue.remove(map.get(building));
				}
			}
		}
		return output;
    }
}
