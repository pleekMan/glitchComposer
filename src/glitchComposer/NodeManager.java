package glitchComposer;

import glitchComposer.globals.ImageData;
import glitchComposer.globals.ImageDataManager;
import glitchComposer.globals.PAppletSingleton;
import glitchComposer.operators.*;

import java.util.ArrayList;

import processing.core.PImage;

public class NodeManager {

	Main p5; // for P5 Singleton
	ImageDataManager imageDataManager; // FOR imageDataManager SINGLETON
	int nodeId;
	int imageDataId;

	ArrayList<Node> operators;
	//ArrayList<ImageData> imageData;
	ArrayList <OutputDisplayer> outputDisplay;

	public NodeManager() {
		p5 = getP5();
		imageDataManager = getImageDataManager();


		operators = new ArrayList<Node>();
		nodeId = 0;
		imageDataId = 0;
		//imageData = new ArrayList<ImageData>();
		outputDisplay = new ArrayList<OutputDisplayer>();
	}

	// P5 SINGLETON
	protected Main getP5() {
		return PAppletSingleton.getInstance().getP5Applet();
	}
	protected ImageDataManager getImageDataManager(){
		return ImageDataManager.getInstance();
	}

	public void render() {

		
		if (imageDataManager.hasImages()) {
			imageDataManager.getImageDataList().get(0).renderImage();
		}

		for (int i = 0; i < operators.size(); i++) {
			operators.get(i).render();
		}
		
		if(!outputDisplay.isEmpty()){
		outputDisplay.get(0).render();
		}
		
	}

	public void addNode(String whatNode) {


		Node newOp = chooseNodeType(whatNode);
		

		operators.add(newOp);

		if (operators.size() > 0) {
			newOp.setParentNode(operators.get(operators.size() - 1));
		}

		nodeId++;

		// outputDisplay.setImage(imageData.get(0).getPxData());
	}

	private Node chooseNodeType(String whatNode) {

		if (whatNode.equals("inputImage")) {
			InputImage newOp = (InputImage) new InputImage(this, p5.mouseX, p5.mouseY, nodeId);
			newOp.setName("Input Image ");
			//newOp.setImageDataLink(imageDataManager.getLastImageData());
			return newOp;
			
		} else if (whatNode.equals("pxSelect")){
			PxSelect newOp = new PxSelect(p5.mouseX, p5.mouseY, nodeId);
			newOp.setName("PxSelect");
			newOp.setImageDataLink(imageDataManager.getLastImageData());
			return newOp;
			
		} else if (whatNode.equals("outputImage")){
			// EACH OutputImage IS LINKED TO BOTH ImageData AND OutputDisplayer
			OutputImage newOutNode = new OutputImage(p5.mouseX, p5.mouseY, nodeId);
			OutputDisplayer newOutDisplay = new OutputDisplayer(p5);
			
			newOutNode.setName("Output Image");
			newOutNode.setImageDataLink(imageDataManager.getLastImageData());
			newOutNode.linkToDisplayer(newOutDisplay);
			
			
			newOutDisplay.setImage(newOutNode.getImage());
			outputDisplay.add(newOutDisplay);
			return newOutNode;
			
		}else {
			return null;
		}
	}

	/*
	public void createNewImageData(PImage imageIn) {
		
		ImageData newImageData = new ImageData(imageDataId);
		newImageData.loadImage(imageIn);
		imageData.add(newImageData);
		imageDataId++;

	}
	*/

	public void evaluateChain() {

		for (int i = 0; i < operators.size(); i++) {

			Operator actualOp = (Operator)operators.get(i);
			actualOp.operate();
		}

	}

	public void operateManual(int manualNodeSelection) {
		// JUST TO TRY OPERATING SPECIFC NODES
		for (int i = 0; i < operators.size(); i++) {
			Node actualOperator = operators.get(i);
			if (operators.get(i).getId() == i) {

				// IF IT'S THE SPECIAL InputImage OPERATOR
				if (actualOperator instanceof InputImage) {
					((InputImage) actualOperator).selectImageInput();
				}

				actualOperator.operate();
				
				break;
			}
		}

	}
}
