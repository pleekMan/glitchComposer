package glitchComposer.globals;

import glitchComposer.Main;

import java.util.BitSet;

import processing.core.PImage;

public class ImageData {

	Main p5;

	int id;
	PImage pxData;
	PImage pxSelection;
	boolean[] channelSelection = { true, true, true };
	int totalPixels;

	public ImageData(int _id) {

		p5 = getP5();

		id = _id;
		pxData = new PImage();
		pxSelection = new PImage();
		totalPixels = 0;

	}

	// P5 SINGLETON
	protected Main getP5() {
		return PAppletSingleton.getInstance().getP5Applet();
	}

	public void clearPxSelection() {
		pxSelection.loadPixels();
		for (int i = 0; i < totalPixels; i++) {
			pxSelection.pixels[i] = p5.color(0, 0);
		}
		pxSelection.updatePixels();
	}

	public void setPxSelection(int firstPx, int lastPx) {

		// CHECK OVERFLOW IN SELECTION
		if (lastPx >= pxSelection.pixels.length) {
			lastPx = pxSelection.pixels.length - 1;
		}

		// SET pxSelection MASK
		pxSelection.loadPixels();
		for (int i = 0; i < totalPixels; i++) {
			if (i >= firstPx && i < lastPx) {
				pxSelection.pixels[i] = p5.color(0, 0, 255, 255);
			}
		}
		pxSelection.updatePixels();
	}
	public PImage getPxSelection() {
		return pxSelection;
	}

	public void setPxData(PImage _operationResult) {
		pxData = _operationResult;
	}
	public PImage getPxData() {
		return pxData;
	}

	
	public boolean[] getChannelSelection() {
		return channelSelection;
	}

	public void loadImage(PImage _imageInput) {
		pxData = _imageInput;
		initializeImageData();
	}

	private void initializeImageData() {

		totalPixels = pxData.pixels.length;

		// INITIALIZE pxSelection MASK, AND SELECT ALL PIXEL
		pxSelection = p5.createImage(pxData.width, pxData.height, p5.ALPHA);
		pxSelection.loadPixels();
		for (int i = 0; i < totalPixels; i++) {
			pxSelection.pixels[i] = p5.color(0, 255);
		}
		pxSelection.updatePixels();

	}

	public void renderImage() {
		// TEMPORARY METHOD TO CHECK IF IT`S LOADING AND RENDERING AN IMAGE
		// CORRECTLY
		p5.image(pxData, 0, 0);
		p5.image(pxSelection, pxData.width, 0);

	}
}
