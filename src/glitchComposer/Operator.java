package glitchComposer;

import glitchComposer.globals.ImageData;
import glitchComposer.globals.ImageDataManager;

public class Operator extends Node {

	protected ImageDataManager imageDataManager;
	protected ImageData imageDataLink;

	int tempLiteral;
	int input;
	int output;

	Node parentNode;

	public Operator(int x, int y, int id) {
		super(x, y, id);

		imageDataManager = getImageDataManager();

		tempLiteral = (int) (p5.random(10));
		input = 0;
		output = tempLiteral;

		name = "Operator " + id;
		// width = (int)p5.textWidth(name);
		height = -15;
		
		hasInNode = true;

	}

	protected ImageDataManager getImageDataManager() {
		return ImageDataManager.getInstance();
	}

	public void setImageDataLink(ImageData _imageData) {
		imageDataLink = _imageData;
	}

	public void setInput(int inputData) {
		input = inputData;
	}

	@Override
	public void setInNode(Node inNode) {

	}
	@Override
	public void setOutNode(Node outNode) {

	}

	public void operate() {

	}

	public int getOutput() {
		return output;
	}

	@Override
	public void setParentNode(Node _parentNode) {
		parentNode = _parentNode;
	}

	protected void drawConnector() {

		p5.noFill();
		p5.stroke(255);

		float pointX1 = pos.x;
		float pointY1 = pos.y + (height * 0.5f);

		float pointX2 = parentNode.pos.x + parentNode.width;
		float pointY2 = parentNode.pos.y + (parentNode.height * 0.5f);

		p5.line(pointX1, pointY1, pointX2, pointY2);

	}

}
