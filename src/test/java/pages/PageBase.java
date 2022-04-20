package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    // base para as outras páginas
    // o elo de contrução entre as páginas

    protected WebDriver driver;
    // construtor
    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
