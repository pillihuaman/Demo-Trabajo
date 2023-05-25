package pe.gob.contraloria.bspscgestorpei.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:messages.properties")
public class LoadMessages {

	@Value("${milestones.response.notfoundmessage}")
	public String notFoundMessage; 
	@Value("${milestones.response.okmessage}")
	public String okMessage; 
	@Value("${milestones.response.notaceptablemessage}")
	public String notAceptableMessage; 
	@Value("${milestones.response.deletedmessage}")
	public String deletedMessage; 
	@Value("${milestones.response.createdmessage}")
	public String createdMessage;
}