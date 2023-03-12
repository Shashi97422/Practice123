package com.DearDoctor.genericuyility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LisImpClass implements ITestListener {
public void onTestFailure(ITestResult result) {
	JavaUtility jlib=new JavaUtility();
	int randam = jlib.getRanDomNumber();
	String testName = result.getMethod().getMethodName();
	System.out.println(testName+"=============excecute & i am lestening=========");
	String currentdate = jlib.getSystemDate();
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
	File srcfile = edriver.getScreenshotAs(OutputType.FILE);
	File dstfile = new File("./screenshots/"+testName+currentdate+randam+".png");
	try {
		FileHandler.copy(srcfile, dstfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
