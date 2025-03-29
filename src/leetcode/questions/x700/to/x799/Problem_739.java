package leetcode.questions.x700.to.x799;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures
public class Problem_739 {

	public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        
        int[] output =new int [temperatures.length];
        
        
        for(int i=temperatures.length-1 ; i>=0; i--){
        	int count=1;
        	int previous=i;
        	while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
            	//stack.pop();
            	count+=(stack.peek()-previous);
            	previous=stack.pop();
            }
        	
        	
            if(stack.isEmpty()){
                output[i] = 0;
                stack.push(i);
                continue;
            }
            
            output[i] = count+=(stack.peek()-previous-1);
            stack.push(i);
            
        }
        return output;
    }
}
