package glitchComposer;
import processing.core.PVector;

public class Node {

	Main p5;
	
	PVector pos;
	int width, height;
	int color;
	
	int id;
	String name;
	
	
	public Node(Main _p5, int x, int y, int id){
		
		p5 = _p5;
		
		pos = new PVector(x, y);

		name = "Node " + id;
		name = String.valueOf(name);
		width = (int)p5.textWidth(name);
	}
	
	public void render(){
		p5.fill(200,0,200);
		p5.stroke(0);
		
		p5.rect(pos.x,pos.y, width,height);
		p5.fill(255);
		p5.text(name, pos.x + 2, pos.y - 2);
				
	}
	
	/*
	public void operate(){
		
	}
	*/
	
}
