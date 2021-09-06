package br.com.challenge.model;



import java.util.ArrayList;
import java.util.Collections;


public class Level {
	
	ArrayList<Integer> levels;
	
	
	
	public Level(ArrayList<Integer> levels) {
		super();
		this.levels = levels;
	}


	public void orderLevels() {
		Collections.sort(this.levels);
		Collections.reverse(this.levels);
	}


	public int get(int iLevel) {
		return this.levels.get(iLevel);
	}
	
	public static int compareLevel(Level levels, int waterLevel) {
		int idLevel = 0;
		while (waterLevel <= levels.get(idLevel)-1){
			idLevel++;	
		}
		return idLevel;
	}
	

}
