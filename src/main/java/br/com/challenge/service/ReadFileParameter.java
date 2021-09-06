package br.com.challenge.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.challenge.model.Level;
import br.com.challenge.model.Soil;

public class ReadFileParameter {
	

	private static final String PATH_XML = "src/main/resources/Parameters.xml";
	
	private static Document getDocument() throws SAXException, IOException, ParserConfigurationException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(PATH_XML);
		
		return document;
	}
	
	public static void setSoil(ArrayList<Soil> soils) throws ParserConfigurationException, SAXException, IOException {
		
		Soil soil;
		
		Document document = getDocument();
				
		NodeList soilsXML = document.getElementsByTagName("soil");
		
		for(int i =0; i < soilsXML.getLength(); i++) {
			ArrayList<Integer> levelsList = new ArrayList<Integer>();
			//get Soil Name/Type  
			Element soilItem = (Element) soilsXML.item(i);
			String name = soilItem.getElementsByTagName("name").item(0).getTextContent();
			
			//get level by name
			NodeList levelsXML = soilItem.getElementsByTagName("level");
			
			for (int j =0; j < levelsXML.getLength(); j++ ) {
				String levelItem = soilItem.getElementsByTagName("level").item(j).getTextContent();
				levelsList.add(Integer.parseInt(levelItem));
			}
			
			Level levels = new Level(levelsList);
			levels.orderLevels();
			soil = new Soil(name, levels);
			soils.add(soil);			
			
		}
	}
	
	public static void setAction(ArrayList<String> actions) throws ParserConfigurationException, SAXException, IOException {
			
		Document document = getDocument();
		
		NodeList actionsXML = document.getElementsByTagName("action");
		
		for(int i =0; i < actionsXML.getLength(); i++) {
			//get Action 
			String action = actionsXML.item(i).getTextContent();
			actions.add(action);			
			
		}
	}
	
}
