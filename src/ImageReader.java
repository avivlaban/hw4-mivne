import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageReader {
	private static final int WHITE = -1;
	
	static public Archipelago readImage(String bmpPath) throws IOException {
		BufferedImage img = ImageIO.read(new File(bmpPath));
		int height = img.getHeight();
		int width = img.getWidth();
		Archipelago ar = new Archipelago(width, height);
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				int pixelValue = img.getRGB(i, j);
				if (pixelValue == WHITE)
					ar.setLandType(i, j, LandType.WATER);
				else
					ar.setLandType(i, j, LandType.LAND);
			}
		}
		return ar;
	}
}
