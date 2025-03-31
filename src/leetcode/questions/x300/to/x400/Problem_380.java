package leetcode.questions.x300.to.x400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_380 {
	private static class RandomizedSet {
		List<Integer> list;
		Map<Integer,Integer>map;
	    public RandomizedSet() {
	        list= new ArrayList<>();
	        map=new HashMap<>();
	    }
	    
	    public boolean insert(int val) {
	    	if(map.containsKey(val)) return false;
	        map.put(val, list.size());
	        list.add(val);
	        return true;
	    }
	    
	    public boolean remove(int val) {
	    	if(!map.containsKey(val)) return false;
	    	int index= map.get(val);
	    	
	    	
	    	int value = list.get(list.size()-1);
	    	
	    	list.set(index, value);
	    	map.put(value,index);
	    	
	    	list.remove(list.size()-1);
	    	map.remove(val);
	    	return true;
	    	
	    }
	    
	    public int getRandom() {
	       return list.get((int)(Math.random() * list.size()) +1) ;
	    }
	}
}
