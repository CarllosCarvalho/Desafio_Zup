package StepDefinitions;

import Helper.ZupHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarProduto extends ZupHelper{

	@Given("^Usuario acessar o site Magazine Luiza$")
	public void usuario_acessar_o_site_Magazine_Luiza() throws Throwable {
		iniciarAplicacaoMagazineLuiza();
	}

	@When("^Usuario digita um produto para consulta$")
	public void usuario_digita_um_produto_para_consulta() throws Throwable {
		escreverNomeCodigoProduto("efc4c331dj");
	
	}

	@Then("^Usuario clicar em Consultar$")
	public void usuario_clicar_em_Consultar() throws Throwable {
		clicarEmConsultar();
	
	}

	@Then("^Produto e exibido na lista$")
	public void produto_e_exibido_na_lista() throws Throwable {
		verificandoExistenciaProdutoLista("efc4c331dj");
	}
	
	
}
