package br.com.challenge.service;

public class Validate {
	
	public static void validateWaterLevel(int waterLevel) throws ValidateException {
		if (waterLevel > 100 || waterLevel < 0) {
			throw new ValidateException("Invalid Value. Inform value between 0 and 100");
		}
	}

}
