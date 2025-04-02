package leetcode.questions.x1200.to.x1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_1235 {

	public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        //int[] output = new int[startTime.length];

        int [][]jobs = new int[startTime.length][];

        for(int i=0; i< startTime.length; i++){
            jobs[i] =new int[]{startTime[i], endTime[i], profit[i]} ;
        }
        
        Arrays.sort(jobs, (a,b) -> {
            int comparator = Integer.compare(a[0],b[0]);
            return comparator != 0 ? comparator : Integer.compare(a[1],b[1]);
        } );

        Queue<Integer[]> q = new LinkedList<>();
        int result=0;
        for(int j=0; j< startTime.length; j++){

            q.add(new Integer[]{j,jobs[j][2]});
            int[] visited = new int[startTime.length];
            int maxSize=0;

            while(!q.isEmpty()){
                int size= q.size();

                for(int i=0; i< size; i++){
                   Integer[] arr = q.poll();
                   visited[arr[0]] =1;
                   maxSize= Math.max(maxSize, arr[1]);
                   List<Integer> list= getIndexes(jobs[arr[0]][1], arr[0]+1, jobs);
                   for(Integer l : list){
                     q.add(new Integer[]{l, arr[1] + jobs[l][2]});
                   }
                }
            }
            result = Math.max(maxSize, result);
        }
        return result;
    }

    private List<Integer> getIndexes(int endTime, int index, int [][]jobs ){
        List<Integer> list= new ArrayList<>();
        for(int i=index; i< jobs.length; i++){
            if(jobs[i][0] >= endTime){
                list.add(i);
            }
        }
        return list;
    }

}
