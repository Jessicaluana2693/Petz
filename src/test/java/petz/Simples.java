package petz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Simples {

    String url; // endereço do site alvo
    WebDriver driver;

    // antes do teste, inicializar os 2 conteudos acima
    @Before
    public void iniciar(){
        url = "https://www.petz.com.br/";

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); // informando onde está o chrome driver
        driver = new ChromeDriver(); //instanciar o chrome
        driver.manage().window().maximize(); // maximizar a janela
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);  //ajustar o tempo de resposta ( sendo em segundos ou milisegundos) -> 30 milisegundos
    }

    @After // ao finalizar o testes
    public void finalizar(){
        driver.quit();
    }

    @Test // o teste em si
    public void abrirPagina(){
        driver.get(url); // abrir a página do site
        assertEquals("Pet Shop: Petz o maior pet shop do Brasil.",driver.getTitle()); // validou o texto na guia da página
    }
}
