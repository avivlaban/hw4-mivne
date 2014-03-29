public class Archipelago {
	private LandType[][] archipelagoMap;
	private int width;
	private int height;
	
	
	Archipelago(int mapWidth, int mapHeight) {
		archipelagoMap = new LandType[mapWidth][mapHeight];
		width = mapWidth;
		height = mapHeight;
	}
	
	public void setLandType(int x, int y, LandType t) {
		archipelagoMap[x][y] = t;
	}
	
	public LandType getLandType(int x, int y) {
		return archipelagoMap[x][y];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
