import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver-win64");
        driver = new ChromeDriver();

        // Initialize Page Object
        loginPage = new LoginPage(driver);

        // Navigate to OrangeHRM login page
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
    }

    @Test
    public void successfulLoginTest() {
        // Perform login
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        // Verify login success
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Login failed");
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}