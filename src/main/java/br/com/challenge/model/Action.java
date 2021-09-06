package br.com.challenge.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.com.challenge.service.ReadFileParameter;

public class Action {
	
	ArrayList<String> action;

	public Action(ArrayList<String> action) {
		this.action = action;
	}
	
	public static void printAction(String action) {
		System.out.println("\t" + action);
	}
	
	public static String getAction(int index) throws ParserConfigurationException, SAXException, IOException {
		ArrayList<String> actions = new ArrayList<String>();
		ReadFileParameter.setAction(actions);
		return actions.get(index);
	}
	
}
