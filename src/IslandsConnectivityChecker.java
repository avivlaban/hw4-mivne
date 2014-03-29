import java.io.IOException;




public class IslandsConnectivityChecker {
	
	private UpTreeForest UTF;
	private Archipelago image;
	private int numComponents;
	
	public IslandsConnectivityChecker(String bmpPath){
		try {
			image = ImageReader.readImage(bmpPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UTF = new UpTreeForest(image.getHeight() * image.getWidth());
		numComponents = (image.getHeight() * image.getWidth());
		
		for(int i = 0; i < image.getWidth(); i++){
			for(int j = 0; j < image.getHeight(); j++){
				
				if(i < (image.getWidth() - 1)){
					connectCoords(i, j, i+1, j);
				}
				
				if(j < (image.getHeight() - 1)){
					connectCoords(i, j, i, j+1);
				}
				
			}
		}
		
		
	}
	
	public void connectCoords(int x1, int y1, int x2, int y2){
		int firstLocation = UTF.find(position(x1, y1));
		int secondLocation = UTF.find(position(x2, y2));
		
		if((image.getLandType(x1, y1) == image.getLandType(x2, y2)) && (firstLocation != secondLocation)){
			UTF.union(firstLocation, secondLocation);
			numComponents--;
		}
		
	}
	
	public boolean areConnected(int x1, int y1, int x2, int y2){
		if(UTF.find(position(x1, y1)) == UTF.find(position(x2, y2))){
			return true;
		}
		
		return false;
	}
	
	public int getNumComponents(){
		
		return numComponents;
	}
	
	private int position(int x1, int y1){
		int position = ((image.getWidth()*y1) + x1);
		return position;
	}
	

}
