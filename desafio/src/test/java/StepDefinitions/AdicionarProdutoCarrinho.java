package StepDefinitions;

import Helper.ZupHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdicionarProdutoCarrinho extends ZupHelper{

		@Given("^Usuario acessar Magazine Luiza$")
		public void usuario_acessar_Magazine_Luiza() throws Throwable {
			//iniciarAplicacaoMagazineLuiza();
			
		}

		@When("^Usuario Consultar Produto para Comprar$")
		public void usuario_Consultar_Produto_para_Comprar() throws Throwable {
			escreverNomeCodigoProduto("efc4c331dj");
			clicarEmConsultar();
			selecionarProduto("efc4c331dj");
		}

		@Then("^Usuario Adiciona Produto no Carrinho$")
		public void usuario_Adiciona_Produto_no_Carrinho() throws Throwable {
			adicionarProdutoNoCarrinho();
		
		}

		@Then("^Verificar produto no carrinho$")
		public void verificar_produto_no_carrinho() throws Throwable {
			verificarProdutoCarrinho("efc4c331dj");
		
		}
	
}
