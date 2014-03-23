package glitchComposer.operators;

import java.io.File;

import glitchComposer.*;
import glitchComposer.globals.ImageDataManager;

public class InputImage extends Operator{

	String inputImagePath;
	//String inputImagePath = "/PROJECTS/Glitch Composer/Image Glitch Test/Signal.gif";
	NodeManager nodeManagerLink;
	boolean isFinishedLoading = false;
	//int imageDataId = 0;


	public InputImage(NodeManager _nodeManager, int x, int y, int id){
		super(x, y, id);

		nodeManagerLink = _nodeManager;
		
	}
		

	public String getImagePath(){
		return inputImagePath;
	}
	public void operate(){
		
	}
	
	public void selectImageInput(){
		
		
		File newFile = new File("dummyString");
		p5.selectInput("SELECT IMAGE TO GLITCH: ", "fileSelector", newFile,this);
		
		// SelectInput RUNS ON A SEPARATE THREAD. THIS MEANS THAT ALL THE OTHER CODE
		// THAT DEPENDS ON IT , STILLS RUNS IN THE BACKGROUND.
		// THUS GetImagePath RUNS FASTER THAN THE USER CAN SELECT A FILE.
		// SOMEHOW, I HAVE TO RUN SelectInput, AND THEN CHECK IT'S FINISHED TO ASK FOR IMAGE-PATH
		
		
	}

	public void fileSelector(File selection) {
		if (selection == null) {
			p5.println("Window was closed or the user hit cancel.");
			
		} 
		else {
			p5.println("User selected " + selection.getAbsolutePath());

			inputImagePath = selection.getAbsolutePath();
			//nodeManagerLink.createNewImageData(p5.loadImage(inputImagePath));
			
			// USE THE imageDataManager SINGLETON ACCESS TO CREATE THE imageData
			imageDataManager.createImageData(p5.loadImage(inputImagePath));
			setImageDataLink(imageDataManager.getLastImageData());
			

		}
	}
}
