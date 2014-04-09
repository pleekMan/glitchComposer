package glitchComposer.operators;

import processing.core.PImage;
import glitchComposer.Operator;


public class PxSelect extends Operator{
	
	int firstPx, lastPx;
	
	boolean rectangularMode;
	
	//imageDataLink IS ON Operator

	
	public PxSelect(int x, int y, int id){
		super(x, y, id);
		
		firstPx = 0;
		lastPx = 10000;
		rectangularMode = false;

	}
	
	public void setFirstPx(int pixel){
		firstPx = pixel;
	}
	public void setLastPx(int pixel){
		lastPx = pixel;
	}
	public void setFirstLastPx(int firstPixel, int lastPixel){
		firstPx = firstPixel;
		lastPx = lastPixel;
	}
	
	
	public void operate(){
		
		// rectangularMode MEANS THE USER MAKES A RECTANGULAR AREA SELECTION. OTHERWISE, IT'S JUST A LINEAR SELECTION ON THE PIXEL ARRAY
		if(!rectangularMode){
			//imageDataLink.clearPxSelection();
			PImage pxSelection = imageDataLink.getPxSelection();
			
			if (lastPx >= pxSelection.pixels.length) {
				lastPx = pxSelection.pixels.length - 1;
			}

			// SET pxSelection MASK
			pxSelection.loadPixels();
			for (int i = 0; i < imageDataLink.getTotalPixels(); i++) {
				if (i >= firstPx && i < lastPx) {
					pxSelection.pixels[i] = p5.color(255, 255);
				} else {
					pxSelection.pixels[i] = p5.color(0, 255);
				}
			}
			pxSelection.updatePixels();
			
		} else {
			
		}
		
	}
}
