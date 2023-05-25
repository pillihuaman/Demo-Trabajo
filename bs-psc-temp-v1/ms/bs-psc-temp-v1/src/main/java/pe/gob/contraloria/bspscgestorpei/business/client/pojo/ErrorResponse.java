package pe.gob.contraloria.bspscgestorpei.business.client.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ErrorResponse {

	@SerializedName("statusCode")
	@Expose
	private String statusCode;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("error")
	@Expose
	@Valid
	private Error error;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public ErrorResponse withStatusCode(String statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ErrorResponse withStatus(String status) {
		this.status = status;
		return this;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public ErrorResponse withError(Error error) {
		this.error = error;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(error, status, statusCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		return Objects.equals(error, other.error) && Objects.equals(status, other.status)
				&& Objects.equals(statusCode, other.statusCode);
	}
}