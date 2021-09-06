package br.com.challenge;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.com.challenge.service.ValidateException;
import br.com.challenge.service.WhatToDo;

public class main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ValidateException  {
		
		String nameSoil = "Fine";
		String messsage;
		int waterLevel = 5;

		messsage = WhatToDo.TellMeWhatToDo(nameSoil, waterLevel);


		
			
	}
		




}
