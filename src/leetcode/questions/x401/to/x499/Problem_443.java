package leetcode.questions.x401.to.x499;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/string-compression
public class Problem_443 {

	public static int compress(char[] chars) {
		
		int index=1;
		int size=1;
		
		for(int i=1; i<chars.length;i++) {
			if(i < chars.length && chars[i] == chars[i-1]) {
				size++;
			}else {		
				if(size==1) {
					chars[index]=chars[i];
					index++;
					continue;
				}
				List<Integer> list =new ArrayList<>();
				while(size > 0) {
					list.add(size%10);
					size/=10;
				}
				int listSize= list.size();
				
				for(int s=listSize-1; s>=0; s--){
					chars[index]= Character.forDigit(list.get(s), 10);
					index++;
				}
				size=1;
				chars[index]=chars[i];
				index++;
			}
		}
		
		if(size>1) {
			List<Integer> list =new ArrayList<>();
			while(size > 0) {
				list.add(size%10);
				size/=10;
			}
			int listSize= list.size();
			
			for(int s=listSize-1; s>=0; s--){
				chars[index]= Character.forDigit(list.get(s), 10);
				index++;
			}
		}
		
		return index;
		
    }
}
