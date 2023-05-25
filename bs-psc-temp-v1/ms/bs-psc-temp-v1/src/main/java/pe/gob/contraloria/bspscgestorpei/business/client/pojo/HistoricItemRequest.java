package pe.gob.contraloria.bspscgestorpei.business.client.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

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
public class HistoricItemRequest {

	@SerializedName("historicItem")
	@Expose
	@Valid
	private HistoricItem historicItem;
	@SerializedName("dateTimeOperation")
	@Expose
	private String dateTimeOperation;
	@SerializedName("supportOperation")
	@Expose
	private String supportOperation;
	@SerializedName("ipClient")
	@Expose
	private String ipClient;
	@SerializedName("userOperation")
	@Expose
	private String userOperation;
	@SerializedName("action")
	@Expose
	private String action;

	public HistoricItemRequest(@Valid HistoricItem historicItem, String dateTimeOperation, String supportOperation,
			String ipClient, String userOperation, String action) {
		super();
		this.historicItem = historicItem;
		this.dateTimeOperation = dateTimeOperation;
		this.supportOperation = supportOperation;
		this.ipClient = ipClient;
		this.userOperation = userOperation;
		this.action = action;
	}

	@Override
	public int hashCode() {
		return Objects.hash(action, dateTimeOperation, historicItem, ipClient, supportOperation, userOperation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricItemRequest other = (HistoricItemRequest) obj;
		return Objects.equals(action, other.action) && Objects.equals(dateTimeOperation, other.dateTimeOperation)
				&& Objects.equals(historicItem, other.historicItem) && Objects.equals(ipClient, other.ipClient)
				&& Objects.equals(supportOperation, other.supportOperation)
				&& Objects.equals(userOperation, other.userOperation);
	}

}