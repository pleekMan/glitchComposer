package glitchComposer;
import glitchComposer.globals.PAppletSingleton;
import processing.core.PImage;

public class OutputDisplayer {

	Main p5;
	
	PImage outputImage;
	
	public OutputDisplayer(){
		
		p5 = getP5();
		
		outputImage = new PImage(); // THIS INITIALIZATION COULD BRING PROBLEMS
	}
	
	// P5 SINGLETON
	protected Main getP5() {
		return PAppletSingleton.getInstance().getP5Applet();
	}
	
	public void setImage(PImage imageOut){
		outputImage = p5.createImage(imageOut.width, imageOut.height, p5.RGB);
		outputImage = imageOut.get();
	}
	
	public void render(){
		p5.image(outputImage, 0, outputImage.height + 10);
	}
}
