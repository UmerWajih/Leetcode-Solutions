package leetcode.questions.x800.to.x899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/find-eventual-safe-states/
public class Problem_802 {

	public static List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> list = new TreeSet<>();
        Map<Integer, Boolean>checkedNodes = new HashMap<>();
        for(int i=0;i<graph.length; i++) {
        	if(checkedNodes.containsKey(i))continue;
        	isValidNode(graph, list, i, new int[graph.length], checkedNodes);
        }
        
        return new ArrayList<>(list);
    }

	private static boolean isValidNode(int[][] graph, Set<Integer>list, int node, int[]visited, Map<Integer,Boolean>checkedNodes) {
		
		int[] path = graph[node];
		
		for(int i=0; i< path.length; i++) {
			if(visited[path[i]] == 1) return false; //cycle
			visited[path[i]] = 1;
			
			if((checkedNodes.containsKey(path[i]) && !checkedNodes.get(path[i])) || 
					!isValidNode(graph, list, path[i], visited, checkedNodes)) {
				checkedNodes.put(path[i], false);
				return false;
			}
			visited[path[i]] = 0;
		}
			
		checkedNodes.put(node, true);
		list.add(node);
		return true;
		
	}

}



