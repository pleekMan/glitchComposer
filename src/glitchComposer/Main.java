package glitchComposer;

import glitchComposer.globals.PAppletSingleton;

import processing.core.*;
import java.io.File;

public class Main extends PApplet{

	NodeManager nodeManager;

	public void setup(){
		size(1000,700);
		smooth();
		
		setPAppletSingleton(); // PASS THIS CLASS (WHICH EXTENDES PApplet), AS THE CLASS FOR THE P5 SINGLETON

		nodeManager = new NodeManager();
	}

	public static void main(String args[]){
		PApplet.main(new String[] { Main.class.getName() });
		//PApplet.main(new String[] { "--present", Main.class.getName() }); // PRESENT MODE
	}
	
	private void setPAppletSingleton() {
		PAppletSingleton.getInstance().setP5Applet(this);
	}

	public void draw(){
		background(125);
		
		nodeManager.render();

	}

	public void keyPressed(){

		if(key == '1'){
			nodeManager.addNode("inputImage");
		}
		if(key == '2'){
			int manualNodeIdSelection = 0;
			nodeManager.operateManual(manualNodeIdSelection);
		}
		
		if(key == '3'){
			nodeManager.addNode("pxSelect");
		}
		
		if(key == '4'){
			nodeManager.addNode("outputImage");
		}

		
		
		
		if(key == 'e' || key == 'E'){
			nodeManager.evaluateChain();
		}

	}

}
