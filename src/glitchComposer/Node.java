package glitchComposer;

import glitchComposer.globals.PAppletSingleton;
import processing.core.PVector;

public class Node {

	public Main p5;

	public PVector pos;
	int width, height;
	int color;
	Node nodeIn, nodeOut;
	boolean hasInNode;

	public int id;
	String name;

	public Node(int x, int y, int id) {

		p5 = getP5();
		;

		pos = new PVector(x, y);

		name = "Node " + id;
		name = String.valueOf(name);
		width = (int) p5.textWidth(name);

		nodeIn = nodeOut = null;
	}

	// P5 SINGLETON
	protected Main getP5() {
		return PAppletSingleton.getInstance().getP5Applet();
	}

	public void render() {
		p5.fill(200, 0, 200);
		p5.stroke(0);

		p5.rect(pos.x, pos.y, width, height);
		p5.fill(255);
		p5.text(name, pos.x + 2, pos.y - 2);

		drawConnector();
	}

	public int getId() {
		return id;
	}

	public void setName(String _name) {
		name = _name;
		width = (int) p5.textWidth(name);
	}

	protected void drawConnector() {
		// ONLY OPERATORS HAVE (INCOMMING) CONNECTORS
	}

	public void setParentNode(Node _parentNode) {

	}

	public void setInNode(Node inNode) {

	}

	public void setOutNode(Node outNode) {

	}

	public void setInput(int inputData) {

	}

	public int getOutput() {
		return 0;
	}

	public void operate() {

	}

}
