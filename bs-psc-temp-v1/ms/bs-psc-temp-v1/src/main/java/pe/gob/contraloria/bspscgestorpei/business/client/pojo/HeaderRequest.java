package pe.gob.contraloria.bspscgestorpei.business.client.pojo;

import java.util.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeaderRequest {

	private String ipClient;
	private String userLogin;

	@Builder
	public HeaderRequest(String ipClient, String userLogin) {
		super();
		this.ipClient = ipClient;
		this.userLogin = userLogin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ipClient, userLogin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeaderRequest other = (HeaderRequest) obj;
		return Objects.equals(ipClient, other.ipClient) && Objects.equals(userLogin, other.userLogin);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HeaderRequest [ipClient=");
		builder.append(ipClient);
		builder.append(", userLogin=");
		builder.append(userLogin);
		builder.append("]");
		return builder.toString();
	}

}