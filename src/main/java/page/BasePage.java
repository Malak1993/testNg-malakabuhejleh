package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	

	public int generateRandomNum(int boundaryNum) {
		Random rnd = new Random();
		return rnd.nextInt(boundaryNum);
	}
	
	
}
