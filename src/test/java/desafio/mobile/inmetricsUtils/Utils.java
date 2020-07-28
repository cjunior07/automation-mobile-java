package desafio.mobile.inmetricsUtils;

import static desafio.mobile.inmetricsCore.aplicacaoMobile.getDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;

public class Utils {

	public static void capturarTela(Scenario scenario) {
		File screenshot = gerarScreenShot(scenario);
		embedScreenshot(screenshot, scenario.getName());
	}

	public static File gerarScreenShot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem,
					(new File("./target/ScreenShots", scenario.getName() + " - " + scenario.getStatus() + ".png")));
		} catch (IOException e) {

		}
		return imagem;
	}

	public static void embedScreenshot(File file, String description) {
		Path content = Paths.get(file.getPath());
		try (InputStream is = Files.newInputStream(content)) {
			Allure.addAttachment(description, is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void iniciarGravacaoVideo() {
		// Iniciando Gravação
		((CanRecordScreen) getDriver()).startRecordingScreen();
	}

	public static void pararGravacaoVideo(Scenario scenario) {

		String base64String = ((CanRecordScreen) getDriver()).stopRecordingScreen();
		byte[] data = Base64.decodeBase64(base64String);
		// Gravando video do teste dentro do Allure
		Allure.getLifecycle().addAttachment("Video da execução", "video/mp4", "mp4", data);
		String nomeCenario = scenario.getName();
		String destinationPath = "target/Videos/" + System.getProperty("file.separator") + nomeCenario + " - "
				+ scenario.getStatus() + ".mp4";
		// "target/filename.mp4";
		Path path = Paths.get(destinationPath);
		try {
			Files.write(path, data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void clicarPorTexto(String texto) {
		getDriver().findElement(By.xpath("//*[contains(@text,'" + texto + "')]")).click();
	}
	
	public static void clicarSkip() {
		getDriver().findElement(By.xpath("//*[contains(@text,'SKIP')]")).click();
	}
	
	public void esperar(int x) {
		try {
			Thread.sleep(1000 * x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);

	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}

	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}
	
	public boolean existeElemento(By elemento) {
		Boolean exist = getDriver().findElement(elemento).isDisplayed();
		return exist;
	}

	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(PointOption.point(new Point(x, y))).perform();
	}

	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();

		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction<>(getDriver()).press(PointOption.point(new Point(x, start_y))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(new Point(x, end_y))).release()
				.perform();
	}

	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		int y = size.height / 2;
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction<>(getDriver()).press(PointOption.point(new Point(start_x, y))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(new Point(end_x, y))).release()
		.perform();
	}
	
	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height / 2);
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		new TouchAction<>(getDriver()).press(PointOption.point(new Point(start_x, y))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(new Point(end_x, y))).release()
		.perform();
	}
	
	public static void aguardarVisibilidade(Boolean visibilidade, Integer tempoEspera, By by)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(getDriver(), tempoEspera);

		if (visibilidade = true) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}

	}
	
	
}
