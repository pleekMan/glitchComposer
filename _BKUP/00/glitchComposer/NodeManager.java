package glitchComposer;

import java.util.ArrayList;

public class NodeManager {

	Main p5;
	int nodeIdCount;

	ArrayList<Operator> operators;

	public NodeManager(Main _p5){
		p5 = _p5;

		operators = new ArrayList<Operator>();
		nodeIdCount = 0;
	}
	
	public void render(){
		for (int i = 0; i < operators.size(); i++) {
			operators.get(i).render();
		}
	}

	public void addNode(String whatNode){

		Operator newOp;
		
		if(whatNode.equals("plus")){
			newOp = new Plus(p5,p5.mouseX,p5.mouseY,nodeIdCount);	
		}
		//else (whatNode.equals("minus")){
		else{
			newOp = new Minus(p5,p5.mouseX,p5.mouseY,nodeIdCount);	

		} 

		operators.add(newOp);
		nodeIdCount++;
	}
	
	public void evaluateChain(){
		
		int resultOut = 0;
		
		for (int i = 1; i < operators.size(); i++) {
			
			Operator actualOp = operators.get(i);
			actualOp.setInput(operators.get(i-1).getOutput());
			actualOp.operate();
			
			resultOut = actualOp.getOutput();
			
		}
		
		p5.println("Chain Result = " + resultOut);
	}
}
