package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }


    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);


    }
//overloading
    public void fillLoginForm1(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());


    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }


    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {

        return
                isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public String getErrorText() {

        return wd.findElement(By.cssSelector("div.error")).getText();
    }
}
