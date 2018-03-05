package calculator.example.com;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



/**
 * Unit test for simple App.
 */
public class TestCalculator {
 
 
private static AppiumDriver<MobileElement> appiumDriver;


	private static ScreenCalculator screen;

	@BeforeClass 
	public static void Setup() throws MalformedURLException {                                                                   
		DesiredCapabilities cap = new DesiredCapabilities();                                
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 23");            
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");                    
		cap.setCapability(MobileCapabilityType.VERSION, "6.0");    
		cap.setCapability("plataformName", "Android");
		cap.setCapability("app",new File ("apk/app-android-calculator.apk" ));
		appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		screen = new ScreenCalculator(appiumDriver);
		
	} 
	
	
	@Test
	public void Soma() {
		screen.inserirNumero("3").inserirNumero2("5").closeKeyboard().button_sum.click();
		assertTrue(screen.Resultado().equals("8"));
	}
	
	@Test
	public void Subtraçao() {
		screen.inserirNumero("10").inserirNumero2("5").closeKeyboard().button_sub.click();
		assertTrue(screen.Resultado().equals("5"));
	}
	
	@Test
	public void Divisao() {
		screen.inserirNumero("10").inserirNumero2("10").closeKeyboard().button_div.click();
		assertTrue(screen.Resultado().equals("1"));
	}
	
	@Test
	public void Mutiplicaçao() {
		screen.inserirNumero("10").inserirNumero2("5").closeKeyboard().button_mult.click();
		assertTrue(screen.Resultado().equals("50"));
	}
	
	@Test
	public void dontShouldDivideByZero() {
		screen.inserirNumero("100").inserirNumero2("0").closeKeyboard().button_div.click();
		assertTrue(screen.Resultado().equals("Cannot divide by zero!"));
	}
}

	

   

