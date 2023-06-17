package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.CustomerAddingCategoryPage;
import util.BrowserFactory;

public class CustomerAddCategoryTest {
	WebDriver driver;
	CustomerAddingCategoryPage custaddcategory;
	@Test
	void userAbleToAddNewCategory() {
		
	driver=	BrowserFactory.init();
			custaddcategory = PageFactory.initElements(driver, CustomerAddingCategoryPage.class);
			custaddcategory.EnterNewCategory("malak");
			custaddcategory.addNewCategory();
			custaddcategory.validateUserIsAbleToAddNewCategory("malak");
			
	}
	

}
