package glitchComposer.globals;

import java.util.ArrayList;

import processing.core.PImage;
import glitchComposer.Main;

public class ImageDataManager {

	Main p5;
	// SINGLETON STUFF
	private static ImageDataManager imageDataManagerInstance = new ImageDataManager();

	ArrayList<ImageData> imageDatas = new ArrayList<ImageData>();
	int imageDataId;

	private ImageDataManager() {

		p5 = getP5();
		imageDataId = 0;

	}

	public static ImageDataManager getInstance() {
		// SINGLETON RETURNER
		return imageDataManagerInstance;
	}

	// P5 SINGLETON
	protected Main getP5() {
		return PAppletSingleton.getInstance().getP5Applet();
	}

	public void createImageData(PImage _image) {
		ImageData newImageData = new ImageData(imageDataId);
		newImageData.loadImage(_image);
		imageDatas.add(newImageData);
		imageDataId++;
		
	}

	public ImageData getLastImageData() {
		return imageDatas.get(imageDatas.size() - 1);
	}

	public boolean hasImages() {
		return imageDatas.isEmpty() ? false : true;
	}
	
	public ArrayList<ImageData> getImageDataList(){
		return imageDatas;
	}
}
