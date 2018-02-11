package com.liandong.main;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MainAccess {
	
	
	public static AndroidDriver<AndroidElement> deviceDriver1;
	public static AndroidDriver<AndroidElement> deviceDriver2;


	public static DesiredCapabilities capabilities1=new DesiredCapabilities();
    //设备名称，必须项，但是值可以随便写在安卓平台上
   
    private static void intialDevice() throws MalformedURLException{
    	capabilities1.setCapability(MobileCapabilityType.DEVICE_NAME, "9abce0c7");
	    capabilities1.setCapability("unicodeKeyboard", "True");
	    capabilities1.setCapability("resetKeyboard", "True");
	    capabilities1.setCapability(MobileCapabilityType.UDID, "9abce0c7");
	    capabilities1.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600000);
	    //安装时不对apk进行重签名，设置很有必要，否则有的apk在重签名之后无法正常使用  
	    capabilities1.setCapability("noSign", "True");
	    //应用的起始activity
	    capabilities1.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.dialer");
	    capabilities1.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.dialer.BydDialtactsActivity");
	    capabilities1.setCapability("autoLaunch", "false");
    	deviceDriver1= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities1);
    }
    public static DesiredCapabilities capabilities2=new DesiredCapabilities();
    //设备名称，必须项，但是值可以随便写在安卓平台上
   
    private static void intialDevice1() throws MalformedURLException{
    	capabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "d4a9ac57");
	    capabilities2.setCapability("unicodeKeyboard", "True");
	    capabilities2.setCapability("resetKeyboard", "True");
	    capabilities2.setCapability(MobileCapabilityType.UDID, "d4a9ac57");
	    capabilities2.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600000);
	    //安装时不对apk进行重签名，设置很有必要，否则有的apk在重签名之后无法正常使用  
	    capabilities2.setCapability("noSign", "True");
	    //应用的起始activity
	    capabilities2.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.dialer");
	    capabilities2.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.dialer.BydDialtactsActivity");


	    capabilities2.setCapability("autoLaunch", "false");
//	    capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT,10);
    	deviceDriver2= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4725/wd/hub"), capabilities2);
    }
	public static void main(String[] args) throws Exception{
	   intialDevice();
	   intialDevice1();
	    deviceDriver1.launchApp();
	    deviceDriver2.launchApp();
	    AndroidElement replaceElement1=deviceDriver1.findElement(By.name("拨号"));
	    replaceElement1.click();
	    for(int i=0;i<=100;i++){
	    AndroidElement replaceElement2=deviceDriver1.findElement(By.id("com.android.dialer:id/digits_container"));
	    replaceElement2.sendKeys("18005830939");
	    AndroidElement replaceElement3=deviceDriver1.findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.dialer:id/dialpad_floating_action_button_container\"]/android.widget.TextView[1]"));
	    replaceElement3.click();
	    Thread.sleep(20000);
	    AndroidElement replaceElement4=deviceDriver2.findElement(By.name("接听"));
	    replaceElement4.click();
	    Thread.sleep(10000);
	    AndroidElement replaceElement5=deviceDriver2.findElement(By.name("挂断"));
	    replaceElement5.click();  
	    Thread.sleep(5000);
	    }
	}
	

} 
