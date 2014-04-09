package glitchComposer.operators;

import processing.core.PImage;
import glitchComposer.Operator;
import glitchComposer.globals.ImageData;

public class PxOffset extends Operator {

	int xAmount, yAmount;

	boolean rectangularMode;

	public PxOffset(int x, int y, int id) {
		super(x, y, id);

		xAmount = yAmount = 5000;
		rectangularMode = false;

	}

	public void operate() {

		PImage pxData = imageDataLink.getPxData();
		PImage pxSelection = imageDataLink.getPxSelection();

		PImage pxBuffer = p5.createImage(pxData.width, pxData.height, p5.RGB);

		pxData.loadPixels();
		pxSelection.loadPixels();
		pxBuffer.loadPixels();

		for (int i = 0; i < pxData.pixels.length; i++) {

			if (p5.red(pxSelection.pixels[i]) >= 255) {
				if ((i + xAmount) < pxData.pixels.length) {
					pxBuffer.pixels[i + xAmount] = pxData.pixels[i];
				}
			} else {
				pxBuffer.pixels[i] = 0;
			}

		}

		for (int i = 0; i < pxData.pixels.length; i++) {
			if (p5.red(pxBuffer.pixels[i]) != 0) {
				pxData.pixels[i] = pxBuffer.pixels[i];
			}
		}

		pxData.updatePixels();
		pxSelection.updatePixels();
		pxBuffer.updatePixels();
	}

}
