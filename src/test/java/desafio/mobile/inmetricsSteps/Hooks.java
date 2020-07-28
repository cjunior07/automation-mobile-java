package desafio.mobile.inmetricsSteps;

import static desafio.mobile.inmetricsCore.aplicacaoMobile.getDriver;
import static desafio.mobile.inmetricsCore.aplicacaoMobile.killDriver;
import static desafio.mobile.inmetricsUtils.Utils.capturarTela;
import static desafio.mobile.inmetricsUtils.Utils.clicarSkip;
import static desafio.mobile.inmetricsUtils.Utils.iniciarGravacaoVideo;
import static desafio.mobile.inmetricsUtils.Utils.pararGravacaoVideo;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void suitUp() {
		getDriver();
		iniciarGravacaoVideo();
		clicarSkip();
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		capturarTela(scenario);
		pararGravacaoVideo(scenario);
		killDriver();
	}

}
