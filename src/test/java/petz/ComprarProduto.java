package petz;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home;
import pages.Lista;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ComprarProduto {

    String url; // endereço do site alvo
    WebDriver driver;

    Home home;  // objeto herdando a classe home
    Lista lista; // objeto herdando a classe lista

    // antes do teste, inicializar os 2 conteudos acima
    @Before
    public void iniciar(){
        url = "https://www.petz.com.br/";

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); // informando onde está o chrome driver
        driver = new ChromeDriver(); //instanciar o chrome
        driver.manage().window().maximize(); // maximizar a janela
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);  //ajustar o tempo de resposta ( sendo em segundos ou milisegundos) -> 30 milisegundos

        home = new Home(driver); // instanciar a classe Home
        lista = new Lista(driver); // instanciar a classe lista
    }

    @After // ao finalizar o testes
    public void finalizar(){
        //driver.quit();
    }

    @Dado("^que acesso o site Petz$")
    public void que_acesso_o_site_Petz() {
        driver.get(url); // abre o site da petz
        System.out.println("Passo 1");
    }

    @Quando("^busco por \"([^\"]*)\" E pressiono Enter$")
    public void busco_por_E_pressiono_Enter(String produto)  {
        home.buscarProdutoComEnter(produto);
        home.buscarProdutoComBtnLupa(produto);
        System.out.println("Passo 2");
    }

    @Entao("^e exibido um grid de produtos com \"([^\"]*)\"$")
    public void e_exibido_um_grid_de_produtos_com(String produto)  {
        assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"",lista.lerCabecalhoResultado());
        System.out.println("Passo 3");
    }

    @Quando("^escolho \"([^\"]*)\"$")
    public void escolho(String produto) {
        lista.clicarNoProdutoDesejado(produto);
        System.out.println("Passo 4");
    }

    @Entao("^exibe para o \"([^\"]*)\" o preco de \"([^\"]*)\"$")
    public void exibe_para_o_o_preco_de(String arg1, String arg2) {
        System.out.println("Passo 5");
    }


}
