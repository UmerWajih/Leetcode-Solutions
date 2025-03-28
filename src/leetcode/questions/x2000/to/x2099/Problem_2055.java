package leetcode.questions.x2000.to.x2099;

import java.util.ArrayList;
import java.util.List;

public class Problem_2055 {

	public static int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer []> list = new ArrayList<>();
        int startPlate=-1;
        int plateCount=0;
        
        char[] chars= s.toCharArray();
        for(int i=0; i< chars.length; i++) {
        	if(chars[i] == '*') {
        		if(startPlate <0)continue;
        		plateCount++;
        	}
        	if(chars[i] == '|') {
        		if(plateCount > 0) list.add(new Integer[] {startPlate, i, plateCount});
        		startPlate=i;
        		plateCount=0;
        	}
        }
        //list is now has all the look ups
        int[] output= new int[queries.length];
        int outputIndex=0;
        for(int[] query : queries) {
        	int start=0;
        	while(list.get(start)[0] < query[0])start++;
        	int sum=0;
        	while(start<list.size() && list.get(start)[1]  <= query[1]) {
        		sum+=list.get(start)[2];
        		start++;
        	}
    		output[outputIndex]=sum;
        	outputIndex++;
        }  
        
        
        return output;
    }
}
