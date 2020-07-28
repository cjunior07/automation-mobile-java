package desafio.mobile.inmetricsSteps;

import static desafio.mobile.inmetricsUtils.Utils.clicarPorTexto;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import desafio.mobile.inmetricsPages.RealizarLoginPage;

public class RealizarLoginStep {

	RealizarLoginPage page = new RealizarLoginPage();


	@Dado("^que estou na pagina inicial do app e clico em \"([^\"]*)\"$")
	public void queEstouNaPaginaInicialDoAppEClicoEm(String texto) throws Exception {
	    clicarPorTexto(texto);   
	}

	@Quando("^clico em \"([^\"]*)\"$")
	public void clicoEm(String texto) throws Exception {
	    clicarPorTexto(texto);
	}

	@Quando("^digito o codigo de verificacao$")
	public void digitoOCodigoDeVerificacao() throws Exception {
	    page.digitarCodigoVerificacao();
	}
	
	@Quando("^escrevo \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void escrevoNoCampo(String texto, String campo) throws Exception {
	   page.escreverTextoNocampo(texto, campo);
	}
	
	@Quando("^clico no carrinho$")
	public void clicoNoCarrinho() throws Exception {
	    page.clicarCarrinho();
	}

	@Entao("^vejo a mensagem \"([^\"]*)\"$")
	public void vejoAMensagem(String mensagem) throws Exception {
	   page.validarMensagem(mensagem);
	}

	@Entao("^vejo a tela inicial$")
	public void vejoATelaInicial() throws Exception {
	   page.validarLogin();
	    
	}
}
