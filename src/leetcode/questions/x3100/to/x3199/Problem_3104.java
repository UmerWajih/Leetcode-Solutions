package leetcode.questions.x3100.to.x3199;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-longest-self-contained-substring/
public class Problem_3104 {
	public int maxSubstringLength(String s) {
		//store first and last occurance in an array
        //caabbdd

        Map<Character, Integer> firstOccurrences = new HashMap<>();
        Map<Character, Integer> lastOccurrences = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!firstOccurrences.containsKey(c)) {
                firstOccurrences.put(c, i);
                lastOccurrences.put(c, i);
            } else {
                lastOccurrences.put(c, i);
            }
        }

        int max = -1; 
       
        for (char c1 : firstOccurrences.keySet()) {
            int start = firstOccurrences.get(c1);
            int end = lastOccurrences.get(c1);
            
            for (int j = start; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if (firstOccurrences.get(c2) < start) {
                    break; //this character c1 is not a valid start point
                }
                //get last occurance of either c1 or c2
                //if our this current nested loop reaches this char it means this is valid substrign
                //add this 
                end = Math.max(end, lastOccurrences.get(c2)); 
                
                if (end == j && end - start + 1 != s.length())  max = Math.max(max, end - start + 1);
                
            }
        }
        return max;
        
    }
}
