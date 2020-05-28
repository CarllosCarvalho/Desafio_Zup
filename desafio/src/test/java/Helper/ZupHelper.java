package Helper;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ZupHelper {
	WebDriver driver;
	WebDriverWait wait;
	
	
	/**
	 * Iniciando Site Magazine Luiza
	 */
	
	protected void iniciarAplicacaoMagazineLuiza(){
		System.setProperty("webdriver.chrome.driver", "C:\\DriverSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.magazineluiza.com.br/");
	}
	
	/**
	 * Escrevendo nome/codigo produto
	 * @param codigoProduto
	 */
	protected void escreverNomeCodigoProduto(String codigoProduto){
		driver.findElement(By.id("inpHeaderSearch")).sendKeys(codigoProduto);
	}
	
	/**
	 * Clicando em Consultar
	 */
	protected void clicarEmConsultar(){
		driver.findElement(By.id("btnHeaderSearch")).click();
	}
	
	/**
	 * Clicando em Consultar
	 */
	protected void pressionarEnter(){
		Actions acao = new Actions(driver);
		acao.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * Verificando Existencia do Produto na Lista
	 * @param codigoProduto
	 */
	protected void verificandoExistenciaProdutoLista(String codigoProduto){
		wait  = new WebDriverWait(driver, 60);
		
		StringBuilder idProdutoLista = new StringBuilder();
		idProdutoLista.append("product_");
		idProdutoLista.append(codigoProduto);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idProdutoLista.toString())));
		
		boolean produtoVisivel = driver.findElement(By.id(idProdutoLista.toString())).isEnabled();
		
		assertEquals("verificandoExistenciaProdutoConsultado",true, produtoVisivel);
		
	}
	
	/**
	 * Selecionando Produto
	 * @param codigoProduto
	 */
	protected void selecionarProduto(String codigoProduto){
		wait  = new WebDriverWait(driver, 60);
		
		StringBuilder idProdutoLista = new StringBuilder();
		idProdutoLista.append("product_");
		idProdutoLista.append(codigoProduto);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idProdutoLista.toString())));
		driver.findElement(By.id(idProdutoLista.toString())).click();
		
	}
	
	protected void adicionarProdutoNoCarrinho() throws InterruptedException {
		wait  = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[5]/div[1]/div[4]/div[2]/button/span")));
		
		boolean selected = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[1]/div[4]/div[2]/button/span")).isEnabled();
		
		if (selected) {												
			Actions actions = new Actions(driver);
			WebElement findElement = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[1]/div[4]/div[2]/button/span"));
			actions.doubleClick(findElement).perform();
		}
	}
	
	
	/**
	 * Verificando a Existência do Produto no Carrinho
	 * @param codigoProduto
	 */
	protected void verificarProdutoCarrinho(String codigoProduto){
		String codigoPagina = driver.getPageSource();
		boolean produtoCarrinho = codigoPagina.contains(codigoProduto);
		assertEquals("verificandoExistenciaProdutoCarrinho",true, produtoCarrinho);
	}
	
	
	/**
	 * Verificando a Existência do Produto no Carrinho
	 * @param codigoProduto
	 */
	protected void verificarMensagemDeErroProdutoNaoEncontrado(String codigoProduto){
		wait  = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nm-not-found-page\"]/div[2]/div[1]")));
		
		String codigoPagina = driver.getPageSource();
		System.out.println(codigoPagina);
		String mensagemErro = "Sua busca por "+codigoProduto+" não encontrou resultado algum :(";
		
		boolean produtoNaoEncontrado = codigoPagina.contains(mensagemErro);
		assertEquals("verificarMsgDeErro",true, produtoNaoEncontrado);
	}
	
}
