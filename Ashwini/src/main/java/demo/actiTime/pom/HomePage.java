package demo.actiTime.pom;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HomePage {
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="container_tasks")
		WebElement taskButton;
		
		@FindBy(id="container_reports")
		WebElement reportButton;
		
		@FindBy(id="container_users")
		WebElement userButton;
		
		@FindBy(id="logoutLink")
		WebElement logoutButton;
		
		@FindBy(id="container_tt")
		WebElement TimeTrackButton;

		public WebElement getTaskButton() {
			return taskButton;
		}

		public void setTaskButton(WebElement taskButton) {
			this.taskButton = taskButton;
		}
		
		public void clickOnTask() {
			taskButton.click();
		}
		public void clickOnReport() {
			reportButton.click();
		}
				
		public void clickOnUser() {
			userButton.click();
		}
				
		public void clickOnlogout() {
			logoutButton.click();
		}
		
		public void clickOnTimeTrack() {
			TimeTrackButton.click();
		}	
				
		}


