package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoComprado extends PageBase{
    public ProdutoComprado(WebDriver driver){ super(driver);}

    public String validarTituloTamanho(){
        WebElement tamanhoDesejado  = driver.findElement(By.xpath("//b[contains(text(),'Tamanho PP')]"));
        WebElement preco = driver.findElement(By.className("current-price-left"));
        return tamanhoDesejado.getText();

    }
    
}
