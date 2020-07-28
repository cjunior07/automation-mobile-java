package desafio.mobile.inmetricsPages;

import static desafio.mobile.inmetricsUtils.Utils.aguardarVisibilidade;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import desafio.mobile.inmetricsCore.aplicacaoMobile;
import desafio.mobile.inmetricsUtils.Utils;
import io.appium.java_client.MobileBy;

public class RealizarLoginPage extends  aplicacaoMobile{
	Utils Utils = new Utils();
	
	public void escreverEmailOuTelefone(String user) {
		Utils.escrever(MobileBy.xpath("//*[contains(@text,'E-mail or phone number')]"), user);
	}
	
	public void escreverEmail(String email) {
		Utils.escrever(MobileBy.xpath("//*[contains(@text,'E-mail')]"), email);
	}
	
	public void escreverTelefone(String telefone) {
		Utils.escrever(MobileBy.xpath("//*[contains(@text,'Phone number')]"), telefone);
	}
	
	public void escreverPassword(String pass) {
		Utils.escrever(MobileBy.xpath("//*[contains(@text,'Password')]"), pass);
	}
	
	public void escreverTextoNocampo(String texto, String campo) {
		Utils.escrever(MobileBy.xpath("//*[contains(@text,'"+campo+"')]"), texto);
	}
	

	public void digitarCodigoVerificacao() {
		Utils.clicar(By.xpath("//*[contains(@text,'Verification Code')]/../android.view.ViewGroup[6]/android.view.ViewGroup[1]"));
		Utils.clicar(By.xpath("//*[contains(@text,'Verification Code')]/../android.view.ViewGroup[6]/android.view.ViewGroup[1]"));
		Utils.clicar(By.xpath("//*[contains(@text,'Verification Code')]/../android.view.ViewGroup[6]/android.view.ViewGroup[1]"));
		Utils.clicar(By.xpath("//*[contains(@text,'Verification Code')]/../android.view.ViewGroup[6]/android.view.ViewGroup[1]"));
	}
	
	public void validarLogin() throws Exception {
		aguardarVisibilidade(true, 10, By.xpath("//*[contains(@text,'Categories')]"));
		assertTrue(Utils.existeElementoPorTexto("Categories"));
	}
	
	public void validarMensagem(String mensagem) {
		assertTrue(Utils.existeElementoPorTexto(mensagem));
	}
	
	public void clicarCarrinho() {
		Utils.clicar(By.xpath("//android.widget.Button[@content-desc=\"Cart, tab, 3 of 5\"]/android.view.ViewGroup"));
	}
}