package glitchComposer.operators;

import processing.core.PImage;
import glitchComposer.Operator;
import glitchComposer.globals.ImageData;

public class PxOffset extends Operator{

	
	int xAmount, yAmount;
	
	boolean rectangularMode;

	
	public PxOffset(int x, int y, int id){
		super(x, y, id);

		xAmount = yAmount = 200;
		rectangularMode = false;

	}
	
	public void operate(){
		
		PImage pxData = imageDataLink.getPxData();
		PImage pxSelection = imageDataLink.getPxSelection();
		/*
		imageDataLink.getPxData().loadPixels();
		for (int i = 0; i < imageDataLink.getPxData().pixels.length; i++) {
			if(imageDataLink.getPxData().pixels[i].)
		
		}
		*/
		
	}
}
