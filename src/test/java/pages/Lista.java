package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Lista extends PageBase{
    //@FindBy(css = "h3.nome_produto") sempre pega o primeiro item do grid
    // Chropath -> plugin que ajuda a identificar os mapeamentos de xpath

    // esse modo vai bucar por um elementa no grid que contenha o texto abaixo em formato h3, independe de posição
    // find by faz apenas mapeamento estáticos, não aceita parâmetros
    // esse xpath utiliza sempre o texto Coleira Petz Borboletas Coloridas para Cães
   // @FindBy(xpath = "//h3[contains(text(),'Coleira Petz Borboletas Coloridas para Cães')]")
   // private WebElement produtoDesejado;

    @FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/categoryid[1]/div[2]/div[2]/div[1]/h1[1]")
    WebElement cabecalhoResultado;

    //construtor
    public Lista(WebDriver driver) { super(driver);}

    // método
        public void clicarNoProdutoDesejado(String produto){
        //produtoDesejado.click();
        // esse xpath vai utilizar a mesma busca por um texto h3, porem utilizando um produto, o qual eu posso mudar o nome caso queira
        WebElement produtoDesejado = driver.findElement(By.xpath("//h3[contains(text(),'"+produto+"')]"));
        produtoDesejado.click();
    }

    public String lerCabecalhoResultado(){
        return cabecalhoResultado.getText(); // retorna o texto do titulo da resposta
    }
}
