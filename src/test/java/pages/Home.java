package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends PageBase{
    // Atributos = elementos da página

    // caixa de pesquisa
    @FindBy(id = "search")
    private WebElement busca;

   @FindBy(className = "button-search")
   private WebElement lupa;

    // Construtor
    public Home(WebDriver driver) {
        super(driver);
    }

    // Métodos e Funções
    public void buscarProdutoComEnter(String produto){
        busca.clear(); // limpa qualquer texto da caixa de pesquisa
        busca.sendKeys(produto + Keys.ENTER); // recebendo o nome do produto e apertando Enter
    }

    public void buscarProdutoComBtnLupa(String produto){
        busca.clear();
        busca.sendKeys(produto);
        lupa.click(); // clicar na lupa
    }
}
