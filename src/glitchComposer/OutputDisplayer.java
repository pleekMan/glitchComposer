package glitchComposer;
import processing.core.PImage;

public class OutputDisplayer {

	Main p5;
	
	PImage outputImage;
	
	public OutputDisplayer(Main _p5){
		
		p5 = _p5;
		
		outputImage = new PImage(); // THIS INITIALIZATION COULD BRING PROBLEMS
	}
	
	public void setImage(PImage imageOut){
		outputImage = p5.createImage(imageOut.width, imageOut.height, p5.RGB);
		outputImage = imageOut.get();
	}
	
	public void render(){
		p5.image(outputImage, 0, outputImage.height + 10);
	}
}
