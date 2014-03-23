package glitchComposer.operators;

import glitchComposer.Operator;


public class PxSelect extends Operator{
	
	int firstPx, lastPx;
	
	boolean rectangularMode;
	
	//imageDataLink IS ON Operator

	
	public PxSelect(int x, int y, int id){
		super(x, y, id);
		
		firstPx = 0;
		lastPx = 1;
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
			imageDataLink.setPxSelection(firstPx, lastPx);
		} else {
			
		}
		
	}
}
