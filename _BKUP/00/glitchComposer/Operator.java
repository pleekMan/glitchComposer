package glitchComposer;

public class Operator extends Node {

	int tempLiteral;
	int input;
	int output;
	
	public Operator(Main _p5, int x, int y, int id) {
		super(_p5, x, y, id);
		
		tempLiteral = (int)(p5.random(10));
		input = 0;
		output = tempLiteral;
		
		name = "Operator " + id;
		//width = (int)p5.textWidth(name);
		height = -15;
				
	}

	
	
	public void setInput(int inputData){
		input = inputData;
	}
	
	public void operate(){
		
	}
	
	public int getOutput(){
		return output;
	}

}
