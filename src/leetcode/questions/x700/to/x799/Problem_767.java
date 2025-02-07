package leetcode.questions.x700.to.x799;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_767 {
	private static class CharacterCounter{
		char character;
		int count;
		
		public CharacterCounter(char character, int count) {
			this.character=character;
			this.count= count;
		}
		
		public int decrementCount() {
			return this.count--;
		}
		public char getChar() {
			return this.character;
		}
		public int getCount() {
			return this.count;
		}
	}
	
	public static String reorganizeString(String s) {
		char[] output= new char[s.length()];
		Map<Character, Integer> count = new HashMap<>();
		char[] sChar= s.toCharArray();
		
		for(char c: sChar) {
			count.put(c, count.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<CharacterCounter> maxHeap = new PriorityQueue<>(
				(a, b) -> {
					if(b.count != a.count) return Integer.compare(b.count, a.count);
					else return Integer.compare(a.character, b.character);
				} 
				);
		
		for(Character c : count.keySet()) {
			maxHeap.add(new CharacterCounter(c, count.get(c)));
		}
		
		int index=0;
		while (!maxHeap.isEmpty()) {
			//start putting top 2 chars side by side
			CharacterCounter char1 = maxHeap.poll();
			if(index>0 && output[index-1] == char1.getChar()) return "";
			index=setHeap(char1,  maxHeap,output,index);

			CharacterCounter char2 = !maxHeap.isEmpty() ? maxHeap.poll() : null;
			if(char2!=null) {
				index=setHeap(char2,  maxHeap,output,index);
				addToHeap(char2, maxHeap);
			}
			addToHeap(char1, maxHeap);
			
		}
		if(!maxHeap.isEmpty()) return "";
		else return String.valueOf(output);
    }
	private static void addToHeap(CharacterCounter charCount, PriorityQueue<CharacterCounter> maxHeap) {
		if(charCount.getCount()>0) {
			maxHeap.add(charCount);
		}
	}
	private static int setHeap(CharacterCounter charCount, PriorityQueue<CharacterCounter> maxHeap,
			char[] output, int index) {
		output[index]= charCount.getChar();
		charCount.decrementCount();
		
		return index+1;
	}
}
