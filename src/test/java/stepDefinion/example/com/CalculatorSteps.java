package stepDefinion.example.com;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import calculator.example.com.ScreenCalculator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorSteps {

	ScreenCalculator screen;

	public AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 23");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "6.0");
		cap.setCapability("plataformName", "Android");
		cap.setCapability("app", new File("apk/app-android-calculator.apk"));
		return new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@Given("^que insiro os dois numeros$")
	public void que_insiro_os_dois_numeros() throws MalformedURLException {
		screen = new ScreenCalculator(getAndroidDriver());
		screen.inserirNumero("9");
		screen.inserirNumero2("1");
		screen.closeKeyboard();

	}

	@When("^tocar no sum$")
	public void tocar_no_sum() {
		screen.button_sum.click();

	}

	@Then("^devo ver o resultado da soma$")
	public void devo_ver_o_resultado_da_soma() {
		assertTrue(screen.Resultado().equals("10"));
	}

	@When("^tocar no subtract$")
	public void tocar_no_subtract()  {
		screen.button_sub.click();
		
	}

	@Then("^devo ver o resultado da subtração$")
	public void devo_ver_o_resultado_da_subtração()  {
		assertTrue(screen.Resultado().equals("8"));
	}

	@When("^tocar no divide$")
	public void tocar_no_divide() {
		screen.button_div.click();
	}

	@Then("^devo ver o resultado da divisão$")
	public void devo_ver_o_resultado_da_divisão()  {
		assertTrue(screen.Resultado().equals("9"));
	}

	@When("^tocar no multiply$")
	public void tocar_no_multiply() {
		screen.button_mult.click();
	}

	@Then("^devo ver o resultado da multiplicação$")
	public void devo_ver_o_resultado_da_multiplicação() {
		assertTrue(screen.Resultado().equals("9"));
	}

}
