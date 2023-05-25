package pe.gob.contraloria.bspscgestorpei.business.client.pojo;

import java.util.Objects;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Error {

	@SerializedName("errorMessage")
	@Expose
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Error withErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorMessage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Error other = (Error) obj;
		return Objects.equals(errorMessage, other.errorMessage);
	}
}