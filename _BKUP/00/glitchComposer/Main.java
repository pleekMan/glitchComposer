package glitchComposer;
import processing.core.*;

public class Main extends PApplet{

	NodeManager nodeManager;

	public void setup(){
		size(500,500);
		smooth();

		nodeManager = new NodeManager(this);
	}

	public static void main(String args[]){
		PApplet.main(new String[] { Main.class.getName() });
		//PApplet.main(new String[] { "--present", Main.class.getName() }); // PRESENT MODE
	}

	public void draw(){
		background(125);
		
		nodeManager.render();

	}

	public void keyPressed(){

		if(key == '1'){
			nodeManager.addNode("plus");
		}
		if(key == '2'){
			nodeManager.addNode("minus");
		}
		
		if(key == 'e' || key == 'E'){
			nodeManager.evaluateChain();
		}

	}


}
