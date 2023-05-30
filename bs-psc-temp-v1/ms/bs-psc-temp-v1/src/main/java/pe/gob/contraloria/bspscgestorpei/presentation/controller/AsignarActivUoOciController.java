package pe.gob.contraloria.bspscgestorpei.presentation.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.gob.contraloria.bspscgestorpei.business.service.AsignarActivUoOciService;
import pe.gob.contraloria.bspscgestorpei.presentation.dto.AsignarActivUoOciRequest;
import pe.gob.contraloria.bspscgestorpei.presentation.dto.AsignarActivUoOciResponse;
import pe.gob.contraloria.bspscgestorpei.presentation.dto.AsignarActividadRequest;
import pe.gob.contraloria.bspscgestorpei.util.Constantes;
import pe.gob.contraloria.bspscgestorpei.util.LoadMessages;
import pe.gob.contraloria.bspscgestorpei.util.ResponseApi;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gestor-PEI/PEI/v1/AsignarActivUoOci")
public class AsignarActivUoOciController {

	private static final Logger logger = LoggerFactory.getLogger(AsignarActivUoOciController.class);

	@Autowired
	private LoadMessages messages;
	@Autowired
	private AsignarActivUoOciService asignarActivUoOciService;


	@PostMapping("/crearActivUoOci")
	@Validated
	public ResponseEntity<ResponseApi<List<AsignarActivUoOciResponse>>> createAsignacion(
			@Parameter(in = ParameterIn.HEADER, required = true) @RequestHeader(value = "ip-client", required = true) String ipClient,
			@Parameter(in = ParameterIn.HEADER, required = true) @RequestHeader(value = "user-login", required = true) String userLogin,
			@Valid @RequestBody AsignarActividadRequest asignarActivUoOciRequest, @RequestHeader HttpHeaders headers) {
		logger.info("AsignarActivUoOciController createAsignacion(ipClient={}, userLogin={} , asignarActivUoOciRequest={} )", ipClient, userLogin, asignarActivUoOciRequest.toString());
		List<AsignarActivUoOciResponse> obj = asignarActivUoOciService.createAsignacion(asignarActivUoOciRequest,ipClient,userLogin);
		if (obj == null)
			return new ResponseEntity<>( new ResponseApi<>(obj, messages.notAceptableMessage, HttpStatus.NOT_ACCEPTABLE.value()), HttpStatus.NOT_ACCEPTABLE);
		logger.info("createAsignacion response: {}  ", obj);
		return new ResponseEntity<>(new ResponseApi<>(obj, messages.createdMessage, HttpStatus.CREATED.value()), HttpStatus.CREATED);
	}

	@GetMapping("/listarActivUoOci")
	public ResponseEntity<ResponseApi<List<AsignarActivUoOciResponse>>> listActividad(
			@Parameter(in = ParameterIn.HEADER, required = true) @RequestHeader(value = "regXPagina", required = true) int regXPagina,
			@Parameter(in = ParameterIn.HEADER, required = true) @RequestHeader(value = "nroPagina", required = true) int nroPagina,
			@Parameter(in = ParameterIn.HEADER, required = true) @RequestHeader(value = "ordenar", required = true) String ordenar,
			@RequestHeader HttpHeaders headers) {
		logger.info("AsignarActivUoOciController listActividad(status={}, flowtype={} )");
		List<AsignarActivUoOciResponse> listSscPscPeiComite = asignarActivUoOciService.listaActividadUoOci( regXPagina,nroPagina,ordenar);
		logger.info("listSscPscPeiComite response: {}  ", listSscPscPeiComite);
		if (null != listSscPscPeiComite && listSscPscPeiComite.size() >= Constantes.NUM_UNO) {
			return new ResponseEntity<>(new ResponseApi<>(listSscPscPeiComite, messages.okMessage, HttpStatus.OK.value()), HttpStatus.OK);
		}
		return new ResponseEntity<>( new ResponseApi<>(listSscPscPeiComite, messages.notFoundMessage, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
	}

	
}