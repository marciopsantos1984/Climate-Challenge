package br.com.challenge.model;

import java.util.ArrayList;

import br.com.challenge.service.ValidateException;

public class Soil {
	
	String name;
	Level level;
		
	public Soil(String name, Level level) {
		this.name = name;
		this.level = level;
	}
	
	public String getSoilName() {
		return this.name;
	}
	
	public Level getSoilLevel(){
		return this.level;
	}
	
	public static Level getLevelByIdSoil(ArrayList<Soil> soils, String nameSoil) throws ValidateException {
		
		for (int i =0; i < soils.size() ; i++) {
			if ((soils.get(i).getSoilName()).toUpperCase().equals(nameSoil.toUpperCase())) {
				return soils.get(i).getSoilLevel();
			}
		}
		throw new ValidateException("Invalid Soil Name.");
		
	}

}
