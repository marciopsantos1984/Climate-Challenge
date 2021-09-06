package br.com.challenge;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.Assert;
import org.xml.sax.SAXException;

import br.com.challenge.service.ValidateException;
import br.com.challenge.service.WhatToDo;



public class TestTellMeWhatToDo {
	
	@Test
	public void testActionNoIrrigation() throws ParserConfigurationException, SAXException, IOException, ValidateException {
		Assert.assertEquals(WhatToDo.TellMeWhatToDo("Fine", 90), "No Irrigation Needed");
	}
	
	@Test
	public void testActionApplyIrrigation() throws ParserConfigurationException, SAXException, IOException, ValidateException {
		Assert.assertEquals(WhatToDo.TellMeWhatToDo("Medium", 85), "Irrigation to Be Applied");
	}
	
	@Test
	public void testActionDangerousl() throws ParserConfigurationException, SAXException, IOException, ValidateException {
		Assert.assertEquals(WhatToDo.TellMeWhatToDo("Coarse", 75), "Dangerousl Low Soil Moisture");
	}
	
	@Test
	public void testInvalidSoilName() throws ParserConfigurationException, SAXException, IOException, ValidateException {
		
		Assert.assertThrows(ValidateException.class, () -> {
			WhatToDo.TellMeWhatToDo("FINO", 80);
		});

	}
	@Test
	public void testInvalidWaterLeve() throws ParserConfigurationException, SAXException, IOException, ValidateException {
		
		Assert.assertThrows(ValidateException.class, () -> {
			WhatToDo.TellMeWhatToDo("Fine", -1);
		});

	}

}
