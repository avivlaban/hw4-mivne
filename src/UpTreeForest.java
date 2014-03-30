
public class UpTreeForest {
	
	private static final int ROOT = -1;
	private int up[];
	private int weight[];
	private int numberOfSets;
	
	public UpTreeForest(int size){
		//Creating new array to represent every element's location and initalizing it to ROOT
		up = new int[size];
		for(int i = 0; i < up.length; i++){
			up[i] = -1;
		}
		//Creating new array to represent number of elements in every set
		weight = new int[size];
		for(int i = 0; i < weight.length; i++){
			weight[i] = 1;
		}
		
		numberOfSets = size;
	}
	
	public void union(int i, int j){
		//If one of the givven int is not a ROOT returnes error
		if((up[i] != ROOT) || (up[j] != ROOT)){
			throw new IllegalArgumentException("One or two of the givven integers aren't representatives");
		}
		
		if(weight[i] > weight[j]){
			weight[i] = weight[i] + weight[j];
			up[j] = i;
		}
		
		else{
			weight[j] = weight[j] + weight[i];
			up[i] = j;
		}
		
		numberOfSets--;
	}
	
	public int find(int i){
		
		int currentIndex = i;
		while(up[currentIndex] != ROOT){
			currentIndex = up[currentIndex];
		}
		if (i != currentIndex) { 
	         int k = up[i]; 
	         while (k != currentIndex) { 
	            up[i] = currentIndex; 
	            i = k; 
	            k = up[k]; 
	         } 
		}
		
		return currentIndex;
	}
	
	public int getNumDisjointSets(){
		
		return numberOfSets;
	}

}
