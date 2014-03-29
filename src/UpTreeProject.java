import java.io.IOException;

public class UpTreeProject {
	public static void main(String[] args) throws IOException {
		//Args[0] should be the path to Archipelago.bmp
		String mapPath = "/Users/IDC-Aviv/Desktop/Ex4/Archipelago.bmp";
		IslandsConnectivityChecker connChecker = 
				new IslandsConnectivityChecker(mapPath);
		int numOfErrors = 0;
		
		/*****************/
		boolean result;
		int sets;
		sets = connChecker.getNumComponents();
		System.out.println("expected 16 and got: " + sets);
		if (sets != 16) { numOfErrors++; }
		result = connChecker.areConnected(13, 23, 101, 93); //Two sea points - should be connected
		System.out.println("expected true and got "+ result);
		if (result != true) { numOfErrors++; }
		result = connChecker.areConnected(47, 10, 35, 10); //Two sea points - should be connected
		System.out.println("expected true and got "+ result);
		if (result != true) { numOfErrors++; }
		result = connChecker.areConnected(78, 15, 88, 15); //Two sea points - should not be connected
		System.out.println("expected false and got "+ result);
		if (result != false) { numOfErrors++; }
		result = connChecker.areConnected(23, 16, 41, 10); //Two land points - should not be connected
		System.out.println("expected false and got "+ result);
		if (result != false) { numOfErrors++; }
		result = connChecker.areConnected(59, 85, 83, 60); //Two land points - should be connected
		System.out.println("expected true and got "+ result);
		if (result != true) { numOfErrors++; }
		/*****************/
		
		/*****************/
		result = connChecker.areConnected(40, 66, 97, 11); //Two land points - should not be connected
		System.out.println("expected false and got "+ result);
		if (result != false) { numOfErrors++; }
		connChecker.connectCoords(34, 66, 82, 18); //Connecting two land points
		result = connChecker.areConnected(40, 66, 97, 11); //Two land points - now they should be connected
		System.out.println("expected true and got "+ result);
		if (result != true) { numOfErrors++; }
		sets = connChecker.getNumComponents();
		System.out.println("expected 15 and got: " + sets);
		if (sets != 15) { numOfErrors++; }
		/*****************/
		
		/*****************/
		result = connChecker.areConnected(84, 96, 90, 15); //Two sea points - should not be connected
		System.out.println("expected false and got "+ result);
		if (result != false) { numOfErrors++; }
		connChecker.connectCoords(8, 42, 89, 16); //Connecting two sea points
		result = connChecker.areConnected(84, 96, 90, 15); //Two sea points - should now be connected
		System.out.println("expected true and got "+ result);
		if (result != true) { numOfErrors++; }
		sets = connChecker.getNumComponents();
		System.out.println("expected 14 and got: " + sets);
		if (sets != 14) { numOfErrors++; }
		/*****************/
		
		System.out.println("Num of Errors: " + numOfErrors);
	}
}
