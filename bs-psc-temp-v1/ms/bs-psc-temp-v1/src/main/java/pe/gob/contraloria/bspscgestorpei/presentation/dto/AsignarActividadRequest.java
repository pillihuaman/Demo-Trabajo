package pe.gob.contraloria.bspscgestorpei.presentation.dto;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AsignarActividadRequest {
	private static final long serialVersionUID = -7062413792553162962L;
 List<OrganoControlRequest> listOrganoControlRequest;

	public List<OrganoControlRequest> getListOrganoControlRequest() {
		return listOrganoControlRequest;
	}

	public void setListOrganoControlRequest(List<OrganoControlRequest> listOrganoControlRequest) {
		this.listOrganoControlRequest = listOrganoControlRequest;
	}
}