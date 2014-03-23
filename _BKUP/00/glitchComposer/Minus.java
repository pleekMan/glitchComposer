package glitchComposer;

public class Minus extends Operator {
	
		
	public Minus(Main _p5, int x, int y, int id){
		super(_p5, x, y, id);
		
		name = " - " + tempLiteral;

				
	}
		
	
	public void operate(){
		
		output = input - tempLiteral;
		
	}

}
