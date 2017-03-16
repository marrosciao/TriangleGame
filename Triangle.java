import java.util.ArrayList;

public class Triangle {

	private Slot slotSet[];
	private ArrayList<Jump> path;

	public Triangle(){
		
		path = new ArrayList<Jump>();
		slotSet = new Slot[15];
		int index = 0;
		
		//fills all pegs
		for(int i = 0; i<5; i++){
			for(int j = 0; j<= i; j++){
				slotSet[index] = new Slot(i,j);
				index++;
			}
			
		}
		slotSet[0].toggle();
	}
	
	public Triangle(Triangle old){
		path = new ArrayList<Jump>(old.getPath());
		slotSet = new Slot[15];
		for(int i = 0; i <15; i++){
		slotSet[i] = new Slot(old.get(i));
		}
	}
	
	//accessors
	public int getPegsLeft(){
		int result = 0;
		for(int i = 0; i < 15; i++){
			if(slotSet[i].isFull())
				result++;
		}
		return result;
	}
	
	public Slot get(int x){
		return slotSet[x];
	}
	
	public void display(){
		int index = 0;
		
		System.out.println("Open moves: "+ openMoves());
		System.out.println("Pegs Left: " + getPegsLeft());
		System.out.print("Path: ");
		for(Jump j : path){
			System.out.print("(" + j.getFrom()+","+j.getTo()+") ");
		}
		System.out.println();
		
		for(int i = 0; i<5; i++){
			for(int j = 0; j<= i; j++){
				if(slotSet[index].isFull()){
					System.out.print("1 ");
				}else{
					System.out.print("0 ");
				}
				index++;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int openMoves(){
		int result = 0;
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 15; j++){
				for(int k = 0; k < 15; k++){
					if(jumpExists(k,j,i)){
						result++;
					}
				}
			}
		}
		
		
		return result;
		
		
	}
	
	public ArrayList<Jump> getPath(){
		return path;
	}
	
	public boolean jumpExists(int f, int m, int t){
		
		if(slotSet[f].isFull()&&slotSet[m].isFull()&&slotSet[t].isEmpty()){
		if((slotSet[m].getX() == slotSet[t].getX()-1) && (slotSet[m].getY() == slotSet[t].getY()-1)&&(slotSet[f].getX() == slotSet[m].getX()-1) && (slotSet[f].getY() == slotSet[m].getY()-1)){
			return true;
		}
		if((slotSet[m].getX() == slotSet[t].getX()-1) && (slotSet[m].getY() == slotSet[t].getY())&&(slotSet[f].getX() == slotSet[m].getX()-1) && (slotSet[f].getY() == slotSet[m].getY())){
			return true;
		}
		if((slotSet[m].getX() == slotSet[t].getX()) && (slotSet[m].getY() == slotSet[t].getY()+1)&&(slotSet[f].getX() == slotSet[m].getX()) && (slotSet[f].getY() == slotSet[m].getY()+1)){
			return true;
		}
		if((slotSet[m].getX() == slotSet[t].getX()+1) && (slotSet[m].getY() == slotSet[t].getY()+1)&&(slotSet[f].getX() == slotSet[m].getX()+1) && (slotSet[f].getY() == slotSet[m].getY()+1)){
			return true;
		}
		if((slotSet[m].getX() == slotSet[t].getX()+1) && (slotSet[m].getY() == slotSet[t].getY())&&(slotSet[f].getX() == slotSet[m].getX()+1) && (slotSet[f].getY() == slotSet[m].getY())){
			return true;
		}
		if((slotSet[m].getX() == slotSet[t].getX()) && (slotSet[m].getY() == slotSet[t].getY()-1)&&(slotSet[f].getX() == slotSet[m].getX()) && (slotSet[f].getY() == slotSet[m].getY()-1)){
			return true;
		}
	   }
		return false;
	}
	//mutators	
	public void jump(Jump jump){
		slotSet[jump.getTo()].toggle();
		slotSet[jump.getMid()].toggle();
		slotSet[jump.getFrom()].toggle();
		path.add(jump);
	}
	
	

}

