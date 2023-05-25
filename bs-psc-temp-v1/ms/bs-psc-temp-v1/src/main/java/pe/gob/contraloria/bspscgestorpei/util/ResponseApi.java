package pe.gob.contraloria.bspscgestorpei.util;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ResponseApi<T> {

	@JsonProperty("data")
	private T data = null;
	private String status;
	private Integer statusCode;

	public ResponseApi(T data, String status, Integer statusCode) {
		super();
		this.data = data;
		this.status = status;
		this.statusCode = statusCode;
	}

	public ResponseApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, status, statusCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseApi other = (ResponseApi) obj;
		return Objects.equals(data, other.data) && Objects.equals(status, other.status)
				&& Objects.equals(statusCode, other.statusCode);
	}
}