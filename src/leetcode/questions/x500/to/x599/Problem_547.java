package leetcode.questions.x500.to.x599;

public class Problem_547 {

	public static int findCircleNum(int[][] isConnected) {
		int provinces=0;
        for(int j=0;j<isConnected[0].length;j++){
            provinces += removeConnectedProvinces(isConnected, j);
        }
        return provinces;
   }
	
	private static int removeConnectedProvinces(int[][] isConnected, int city) {
		if(isConnected[city][city] == 0) return 0; //we have gone through this iteration
		
		isConnected[city][city] = 0;
		
		for(int i=0; i<isConnected[city].length;i++) {
			if(isConnected[city][i] ==1) {
				//proceed to mark all its connections as 0
				removeConnectedProvinces(isConnected, i);
			}
		}		
		return 1; //size will be 1 as all provinces are interconnected
	}
	//mark all provices connected from node n as 0
}
