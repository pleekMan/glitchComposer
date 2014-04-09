package glitchComposer.operators;

import processing.core.PImage;
import glitchComposer.Operator;
import glitchComposer.OutputDisplayer;
import glitchComposer.globals.ImageData;

public class OutputImage extends Operator{

	OutputDisplayer displayer;
	PImage imageOut;
	
	public OutputImage(int x, int y, int id){
		super(x, y, id);

		imageOut = new PImage();
		
		//outputDisplay = new OutputDisplayer(p5);
		
	}
	
	public void linkToDisplayer(OutputDisplayer _displayer){
		displayer = _displayer;
	}
	
	public void operate(){
		imageOut = imageDataLink.getPxData().get();
		//imageOut.mask(imageDataLink.getPxSelection());
		
		// EVERYTIME THIS NODES OPERATES, IT UPDATES THE LINKED OutputDisplayer
		displayer.setImage(imageOut);
		
	}
	
	public PImage getImage(){
		return imageOut;
	}
}
