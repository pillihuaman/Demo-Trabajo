package pe.gob.contraloria.bspscgestorpei.business.client;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import pe.gob.contraloria.bspscgestorpei.util.LoadConstants;

@Configuration
public class RestTemplateConfig {

	private static final Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class);

	@Autowired
	private LoadConstants loadConstants;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplateBuilder builder = new RestTemplateBuilder();
		logger.info("RestTemplateBuilder (setConnectTimeout={}, setReadTimeout={}) ",
				loadConstants.addHistoryItemConnectTimeout, loadConstants.addHistoryItemReadTimeout);
		return builder
				.setConnectTimeout(Duration.ofSeconds(Integer.valueOf(loadConstants.addHistoryItemConnectTimeout)))
				.setReadTimeout(Duration.ofSeconds(Integer.valueOf(loadConstants.addHistoryItemReadTimeout))).build();
	}
}