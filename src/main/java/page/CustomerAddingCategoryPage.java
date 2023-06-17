package page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CustomerAddingCategoryPage extends BasePage {
	WebDriver driver;
	String xpath;

	@FindBy(how = How.CSS, using = "input[name='categorydata']")
	WebElement CategoryField_Element;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement AddCategoryButton_Element;
	@FindBy(how = How.CSS, using = "div.controls>a>span")
	List<WebElement> CategoryList;
	@FindBy(how = How.CSS, using = "select[name='due_month']>option")
	List<WebElement> MonthDropDown;;

	public CustomerAddingCategoryPage(WebDriver driver) {
		driver = this.driver;
	}

	public String EnterNewCategory(String categoryName) {
		String newCategoryName = categoryName + generateRandomNum(999);
		CategoryField_Element.sendKeys(newCategoryName);
		return newCategoryName;

	}

	public void addNewCategory() {
		AddCategoryButton_Element.click();
		System.out.println("new category has been added");
	}

	public void validateUserIsAbleToAddNewCategory(String categoryName) {
		String lastInsertedCategoryValue = CategoryList.get(CategoryList.size() - 1).getText();
		Assert.assertEquals(lastInsertedCategoryValue, categoryName);
		System.out.println("last category name :" + lastInsertedCategoryValue);
	}

	public void validateDuplicateCatogery(String categoryName) {
		CategoryField_Element.sendKeys(categoryName);
		AddCategoryButton_Element.click();
		for(WebElement catname:CategoryList) {
			if(catname.getText().equals(categoryName)) {System.out.println("duplicated category name");}
			else {System.out.println("the category is NOT there ,  you can add it"); }
		}
	}

	public void validateMonthDropDown() {
		String expectedMonthsArr []= {"None","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		for(int i=1; i<expectedMonthsArr.length; i++) {
			System.out.print(MonthDropDown.get(i).getText()+ " ");
			Assert.assertEquals(MonthDropDown.get(i).getText(), expectedMonthsArr[i]);
			}
		}
	}



