
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
}
    public void enterUsername(String username) {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("txtPassword")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id("btnLogin")).click();
    }
}