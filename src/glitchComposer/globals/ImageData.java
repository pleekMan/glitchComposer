package glitchComposer.globals;

import glitchComposer.Main;

import java.util.BitSet;

import processing.core.PImage;

public class ImageData {

	Main p5;

	int id;
	PImage pxData; // Actual PXs of resulting image
	PImage pxSelection; // K Selection Mask
	PImage channelSelection; // RGB for individual channel picking
	int totalPixels;
	PImage originalImage;

	public ImageData(int _id) {

		p5 = getP5();

		id = _id;
		pxData = new PImage();
		pxSelection = new PImage();
		channelSelection = new PImage();
		totalPixels = 0;
		originalImage = new PImage();

	}

	// P5 SINGLETON
	protected Main getP5() {
		return PAppletSingleton.getInstance().getP5Applet();
	}

	public int getId() {
		return id;
	}

	public void clearPxSelection() {
		pxSelection.loadPixels();
		for (int i = 0; i < totalPixels; i++) {
			pxSelection.pixels[i] = p5.color(0, 255);
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
				pxSelection.pixels[i] = p5.color(255, 255);
			}
		}
		pxSelection.updatePixels();
	}

	public void setPxSelection(PImage _pxSelection) {
		pxSelection = _pxSelection;
	}

	public PImage getPxSelection() {
		return pxSelection;
	}

	public int getPxSelectionCount() {
		int count = 0;

		pxSelection.loadPixels();
		for (int i = 0; i < totalPixels; i++) {

			int redColor = p5.color(pxSelection.pixels[i]);

			if ((redColor >> 16 & 0xFF) == 0xFF) {
				count++;
			}
		}
		// pxSelection.updatePixels();

		return count;
	}

	public int getPxSelectionFirstLinearPx() {
		int firstPixel = 0;

		pxSelection.loadPixels();
		for (int i = 0; i < totalPixels; i++) {
			if (p5.red(pxSelection.pixels[i]) >= 255) {
				firstPixel = i;
				break;
			}
		}
		pxSelection.updatePixels();
		
		return firstPixel;
	}
	
	public int getPxSelectionLastLinearPx() {
		int lastPixel = 0;

		pxSelection.loadPixels();
		for (int i = totalPixels - 1; i >= 0; i--) {
			if (p5.red(pxSelection.pixels[i]) >= 255) {
				lastPixel = i;
				break;
			}
		}
		pxSelection.updatePixels();
		
		return lastPixel;
	}

	public void setPxData(PImage _operationResult) {
		pxData = _operationResult;
	}

	public PImage getPxData() {
		return pxData;
	}

	public PImage getChannelSelection() {
		return channelSelection;
	}

	public int getTotalPixels() {
		return totalPixels;
	}

	public void loadImage(PImage _imageInput) {
		pxData = _imageInput;
		originalImage = _imageInput.get();
		initializeImageData();
	}

	private void initializeImageData() {

		try {

			totalPixels = pxData.pixels.length;

			// INITIALIZE pxSelection MASK, AND SELECT NO PIXELS
			pxSelection = p5.createImage(pxData.width, pxData.height, p5.RGB);
			pxSelection.loadPixels();
			for (int i = 0; i < totalPixels; i++) {
				pxSelection.pixels[i] = p5.color(0, 0);
			}
			pxSelection.updatePixels();

		} catch (Exception e) {
			System.out.println("Did not initialize ImageData");
		}

	}

	public void renderImage() {
		// TEMPORARY METHOD TO CHECK IF IT`S LOADING AND RENDERING AN IMAGE
		// CORRECTLY
		p5.image(originalImage, 0, 0);
		p5.image(pxSelection, pxData.width, 0);

	}
}
