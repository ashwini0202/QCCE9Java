package demo.actiTime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver, this) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userNameTextField;
	
	@FindBy(id="pwd")
	private WebElement passworTextField;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginButton;
	
	@FindBy(xpath="//td[text()='Please identify yourself']")
	private WebElement headText;
	
	@FindBy(xpath="//table[@id='demoCredentials']")
	private WebElement credentials;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getHeadText() {
		return headText;
	}

	public void setHeadText(WebElement headText) {
		this.headText = headText;
	}

	public WebElement getCredentials() {
		return credentials;
	}

	public void setCredentials(WebElement credentials) {
		this.credentials = credentials;
	}

	public void setUserNameTextField(WebElement userNameTextField) {
		this.userNameTextField = userNameTextField;
	}

	public WebElement getPassworTextField() {
		return passworTextField;
	}

	public void setPassworTextField(WebElement passworTextField) {
		this.passworTextField = passworTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	
	//Business Logic
	public void login(String username, String password) {
		getUserNameTextField().sendKeys(username);
		getPassworTextField().sendKeys(password);
		getLoginButton().click();
	}
	public void getDetails1() {
		System.out.println(headText.getText());
		System.out.println(credentials.getText());

		
	}

	public void getDetails() {
		// TODO Auto-generated method stub
		
	}
		
	
	}