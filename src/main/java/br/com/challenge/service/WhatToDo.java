package br.com.challenge.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.com.challenge.model.Level;
import br.com.challenge.model.Soil;
import br.com.challenge.model.Action;

public class WhatToDo {
	
	static ArrayList<Soil> soils = new ArrayList<Soil>();
	
	
	public static String TellMeWhatToDo(String nameSoil, int waterLevel) throws ParserConfigurationException, SAXException, IOException, ValidateException {
		//load actions, soils and levels in XML
		ReadFileParameter.setSoil(soils);
		int idMessageToDo;
		Level soilLevel;
		String messageToTell;
		
		Validate.validateWaterLevel(waterLevel);
		soilLevel = Soil.getLevelByIdSoil(soils, nameSoil);
		idMessageToDo = Level.compareLevel(soilLevel, waterLevel);
		messageToTell = Action.getAction(idMessageToDo);
		Action.printAction(messageToTell);
		return messageToTell;
	}
	


}
