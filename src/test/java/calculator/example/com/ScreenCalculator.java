package calculator.example.com;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScreenCalculator {
	
 private AppiumDriver<MobileElement> driver;
	 
	 
	 
	public ScreenCalculator(AppiumDriver<MobileElement> appiumDriver) {
		 
		 this.driver = appiumDriver;
		 PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		
	}
	
		@AndroidFindBy(id= "android_field_first_number")
		public MobileElement first_number;
		@AndroidFindBy(id= "android_field_second_number") 
		public MobileElement second_number;
	    @AndroidFindBy(id= "android_button_sum")
	    public MobileElement button_sum;
		@AndroidFindBy(id= "android_button_sub")
		public MobileElement button_sub;
		@AndroidFindBy(id= "android_button_mult") 
		public MobileElement button_mult;
		@AndroidFindBy(id= "android_button_div")
		public MobileElement button_div;
		@AndroidFindBy(id= "android_result_text")
		public MobileElement result_text;
	
	
	
		public ScreenCalculator inserirNumero(String num) {
			first_number.click();
			first_number.clear();
			driver.getKeyboard().sendKeys(num);
			return this;
			
		}
		
		public ScreenCalculator inserirNumero2(String num2) {
			second_number.click();
			second_number.clear();
			driver.getKeyboard().sendKeys(num2);
			return this;
			
		}
		
		public String Resultado() {
			return result_text.getText().toString().trim();
		}
		
		
		public ScreenCalculator closeKeyboard() {
			driver.hideKeyboard();
			return this;
		}
		
	}
	
	
