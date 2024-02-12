package com.Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Webtest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver Driver=new ChromeDriver();
		Driver.get("https://glueple.com/#/");
		System.out.println("Open the browser and launch the URL");	
		Thread.sleep(5000);

	}

}
