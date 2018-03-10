/*
 * Copyright 2005-2010 Ignis Software Tools Ltd. All rights reserved.
 */
package com.aqua.services.multiuser;

import java.io.IOException;
import java.util.HashMap;

import jsystem.framework.TestProperties;
import jsystem.framework.scenario.Parameter;
import junit.framework.SystemTestCase4;

import org.junit.Test;

public class HandleUIEventDemonstration extends SystemTestCase4 {

	/**
	 */
	private enum Options{

		setBatteryMAX,
		option_2;
	}
	
	private Options options = Options.setBatteryMAX;
	private String userInput;

	/**
	 */
	@TestProperties(paramsInclude={"options","userInput"})
	@Test public void myTest() throws Exception {
	}
	
	
	public void handleUIEvent(HashMap<String,Parameter> map,String methodName) throws Exception {
		Parameter userInput = map.get("UserInput");
		//boolean enableUserInput = map.get("Options").getValue().equals(Options.user_input.toString());
//		userInput.setVisible(enableUserInput);
		//userInput.setEditable(enableUserInput);
	}
	
	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}


	@Test
	// change battery level value to 100%
	public void setBatteryMAX() throws InterruptedException, IOException {
		String cmd = "adb shell dumpsys battery set level 100";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(cmd);
		pr.waitFor();
	}


}
