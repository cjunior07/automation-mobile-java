package desafio.mobile.inmetricsCore;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class aplicacaoMobile {

	private static AndroidDriver<MobileElement> driver;

	private static void createDriver() {

		File app = new File("app/test_ifood.apk");

		// capacidades para execucao
		DesiredCapabilities config = new DesiredCapabilities();
		config.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		config.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		config.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		config.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// abrir conexao com dispostivo (sessao)
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), config);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
