package pe.gob.contraloria.bspscgestorpei.business.client.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Generated("jsonschema2pojo")
@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class SuccessResponseCreate {

	@SerializedName("statusCode")
	@Expose
	private Integer statusCode;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("data")
	@Expose
	private String data;

	public SuccessResponseCreate(Integer statusCode, String status, String data) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.data = data;
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
		SuccessResponseCreate other = (SuccessResponseCreate) obj;
		return Objects.equals(data, other.data) && Objects.equals(status, other.status)
				&& Objects.equals(statusCode, other.statusCode);
	}
}