package pe.gob.contraloria.bspscgestorpei.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@Getter
@PropertySource("classpath:constants.properties")
public class LoadConstants {

	@Value("#{${milestones.description.status}}")
	public Map<String, String> descriptionStatus; 
	@Value("${milestones.message.startdate}")
	public String startdate; 
	@Value("${milestones.message.enddate}")
	public String enddate; 
	@Value("${milestones.message.enddatemessage}")
	public String enddatemessage; 
	@Value("${milestones.message.startdatemessage}")
	public String startdatemessage; 
	@Value("${milestones.message.codeexists}")
	public String codeexists;
	
	/* Llaves para addHistoryItem */
	@Value("${addHistoryItem.url}")
	public String addHistoryItemUrl;
	@Value("${addHistoryItem.connecttimeout}")
	public String addHistoryItemConnectTimeout;
	@Value("${addHistoryItem.readtimeout}")
	public String addHistoryItemReadTimeout; 
	@Value("#{${addHistoryItem.action.operaciones}}")
	public Map<String, String> addHistoryItemActionOperaciones;

	@Value("${addHistoryItem.dateTimeOperation.format}")
	public String addHistoryItemDateTimeOperationFormat;
	@Value("${addHistoryItem.iniVigencia.format}")
	public String addHistoryItemIniVigenciaFormat;
	@Value("${addHistoryItem.finVigencia.format}")
	public String addHistoryItemFinVigenciaFormat;
	@Value("${addHistoryItem.codMaestro}")
	public String addHistoryItemCodMaestro;
}