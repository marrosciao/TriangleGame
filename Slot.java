
public class Slot {

	private boolean isFull;
	private int x;
	private int y;
	
	//constructors
	public Slot(int x, int y){
		this.x = x;
		this.y = y;
		isFull = true;
	}
	
	public Slot(Slot old){
		x = old.getX();
		y = old.getY();
		isFull = old.isFull();
	}
	
	//accessors
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean isFull(){
		return isFull;
	}
	
	public boolean isEmpty(){
		return !isFull;
	}
	
	public int state(){
		if(isFull){
			return 1;
		}else{
			return 0;
		}
	}
	
	//mutators
	public void toggle(){
		if(isFull){
			isFull = false;
			//System.out.println("Switched (" + x + " , "  +y +") to false");
		}else{
			isFull = true;
			//System.out.println("Switched (" + x + " , "  +y +") to true");
		}
	}
	
}
