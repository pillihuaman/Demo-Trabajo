package pe.gob.contraloria.bspscgestorpei.presentation.exception;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandlerGeneric extends ResponseEntityExceptionHandler {

	// 400
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final List<String> errors = new ArrayList<>();
		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), errors);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final List<String> errors = new ArrayList<>();
		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), errors);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(final TypeMismatchException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final String error = ex.getValue() + " value for " + ex.getPropertyName() + " should be of type "
				+ ex.getRequiredType();

		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(final MissingServletRequestPartException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final String error = ex.getRequestPartName() + " part is missing";
		final ErrorResponseApiGeneric controllerError = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(controllerError, new HttpHeaders(), controllerError.getStatus());
	}

	/*
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException ex, final HttpHeaders headers,final HttpStatus status,final WebRequest request) {
		logger.info(ex.getClass().getName());
		
		final String error = ex.getParameterName() + " parameter is missing";
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}*/

	//
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
			final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		String name = "";
		Class<?> requiredType = ex.getRequiredType();
		if (requiredType != null)
			name = requiredType.getName();

		final String error = ex.getName() + " should be of type " + name;

		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex,
			final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final List<String> errors = new ArrayList<>();
		for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
					+ violation.getMessage());
		}

		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), errors);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	// 404

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.NOT_FOUND.value(),
				ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	// 405

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			final HttpRequestMethodNotSupportedException ex, final HttpHeaders headers, final HttpStatus status,
			final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final StringBuilder builder = new StringBuilder();
		builder.append(ex.getMethod());
		builder.append(" method is not supported for this request. Supported methods are ");

		Set<HttpMethod> supportedHttpMethods = ex.getSupportedHttpMethods();
		if (supportedHttpMethods != null)
			supportedHttpMethods.forEach(t -> builder.append(t + " "));

		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(
				HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getLocalizedMessage(), builder.toString());
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	// 415

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(final HttpMediaTypeNotSupportedException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		logger.info(ex.getClass().getName());
		//
		final StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(" media type is not supported. Supported media types are ");
		ex.getSupportedMediaTypes().forEach(t -> builder.append(t + " "));

		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(
				HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), ex.getLocalizedMessage(),
				builder.substring(0, builder.length() - 2));
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	// 400
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error("HttpMessageNotReadableException");
		logger.error(ex.getMessage(), ex);
		try {
			IOUtils.toString(ex.getHttpInputMessage().getBody(), StandardCharsets.UTF_8.name());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		String message = "La trama tiene un formato incorrecto";
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), message);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	protected ResponseEntity<Object> handleMissingRequestHeaderException(final MissingRequestHeaderException ex) {
		String message = "La solicitud es inválida. Cabecera requerida: " + ex.getHeaderName();
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage(), message);
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	// 500

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
		logger.info(ex.getClass().getName());
		logger.error("error", ex);
		//
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getLocalizedMessage(), "error occurred");
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<Object> handleAll(final Throwable ex, final WebRequest request) {
		logger.info(ex.getClass().getName());
		logger.error("error", ex);
		//
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getLocalizedMessage(), "error occurred");
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	// business
	@ExceptionHandler(EndDateValidation.class)
	protected ResponseEntity<Object> handleEndDateValidationException(final EndDateValidation ex) {
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getFieldName(), ex.getMessage());
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@ExceptionHandler(StatusInactiveEndDateAfterStartDateValidation.class)
	protected ResponseEntity<Object> handleStatusInactiveValidationException(
			final StatusInactiveEndDateAfterStartDateValidation ex) {
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getFieldName(), ex.getMessage());
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}

	@ExceptionHandler(UniqueCodeValidation.class)
	protected ResponseEntity<Object> handleCdeAndNameValidationException(final UniqueCodeValidation ex) {
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(), ex.getMessage());
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}
	
	@ExceptionHandler(DeletedValidation.class)
	protected ResponseEntity<Object> handleDeletedValidationException(final DeletedValidation ex) {
		final ErrorResponseApiGeneric errorResponseApi = new ErrorResponseApiGeneric(HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(), ex.getMessage());
		return new ResponseEntity<>(errorResponseApi, new HttpHeaders(), errorResponseApi.getStatus());
	}
}