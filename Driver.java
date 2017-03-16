import java.util.ArrayList;
import java.util.List;

public class Driver {
	private static ArrayList<Triangle> results = new ArrayList<Triangle>();
	
public static void main(String[] args){
	long startTime = System.currentTimeMillis();
	
	
	Triangle tri = new Triangle();
	
	System.out.println("Solving...");
	solve(tri);
	System.out.println("Solved");
	readOut();
	
	
	long endTime   = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	System.out.println();
	System.out.println("Run time: " + totalTime+ "ms");
}



public static void solve(Triangle game){
	if(game.openMoves() == 0){
		results.add(game);
	}
	
	for(int i = 0; i < 15; i++){
		for(int j = 0; j < 15; j++){
			for(int k = 0; k < 15; k++){
				if(game.jumpExists(k,j,i)){
					Triangle temp = new Triangle(game);
					temp.jump(new Jump(k,j,i));
					solve(temp);
				}
			}
		}
	}
	
	
}

public static void readOut(){
	for(Triangle e : results){
		e.display();
	}
}

}
