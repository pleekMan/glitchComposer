package glitchComposer;

public class Plus extends Operator {
	
		
	public Plus(Main _p5, int x, int y, int id){
		super(_p5, x, y, id);
		
		name = " + " + tempLiteral;
		width = (int)p5.textWidth(name);

				
	}
		
	
	public void operate(){
		
		output = input + tempLiteral;
		
		
	}

}
