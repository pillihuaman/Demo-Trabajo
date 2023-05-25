package pe.gob.contraloria.bspscgestorpei.presentation.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseApiGeneric {

	@JsonProperty("statusCode")
	private Integer status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	@JsonProperty("status")
	private String message;
	private List<String> errors;

	private ErrorResponseApiGeneric() {
		timestamp = LocalDateTime.now();
	}

	public ErrorResponseApiGeneric(final Integer status, final String message, final List<String> errors) {
		this();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public ErrorResponseApiGeneric(final Integer status, final String message, final String error) {
		this();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(final Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(final List<String> errors) {
		this.errors = errors;
	}

	public void setError(final String error) {
		errors = Arrays.asList(error);
	}
}
