package pe.gob.contraloria.bspscgestorpei.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pe.gob.contraloria.bspscgestorpei.util.ValidationConstants;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class AsignarActivUoOciRequest {
	private static final long serialVersionUID = -7062413792553162962L;
	private Long naocCodigo;
	@NotNull(message = ValidationConstants.NACT_CODIGO_NOTNULL)
	//@NotEmpty(message = ValidationConstants.NACT_CODIGO_EMPTY)
	@JsonProperty("nactCodigo")
	private Long nactCodigo;


	private Long cacmCodigo;

	@NotNull(message = ValidationConstants.NAOC_COD_TIPOORGCTRL_NOTNULL)
	//@NotEmpty(message = ValidationConstants.NAOC_COD_TIPOORGCTRL_EMPTY)
     @JsonProperty("naocCodTipoorgctrl")
	private Long naocCodTipoorgctrl;


	//@NotNull(message = ValidationConstants.CAOC_COD_ORGCTRL_NOTNULL)
	@NotEmpty(message = ValidationConstants.CAOC_COD_ORGCTRL_EMPTY)
	@JsonProperty("caocCodOrgctrl")
	private String caocCodOrgctrl;

	private String caocFlgActivo;
	private Date daocFecIns;
	private String caocUsuIns;
	private String caocIpIns;
	private Date daocFecUpd;
	private String caocUsuUpd;
	private String caocIpUpd;
	private String caocFlgeli;

	public AsignarActivUoOciRequest(
			Long naocCodigo,
			Long nactCodigo,
			Long cacmCodigo,
			Long naocCodTipoorgctrl,
			String caocCodOrgctrl,
			String caocFlgActivo,
			Date daocFecIns,
			String caocUsuIns,
			String caocIpIns,
			Date daocFecUpd,
			String caocUsuUpd,
			String caocIpUpd,
			String caocFlgeli
	) {
		super();
		this.naocCodigo = naocCodigo;
		this.nactCodigo = nactCodigo;
		this.cacmCodigo = cacmCodigo;
		this.naocCodTipoorgctrl = naocCodTipoorgctrl;
		this.caocCodOrgctrl = caocCodOrgctrl;
		this.caocFlgActivo = caocFlgActivo;
		this.daocFecIns = daocFecIns;
		this.caocUsuIns = caocUsuIns;
		this.caocIpIns = caocIpIns;
		this.daocFecUpd = daocFecUpd;
		this.caocUsuUpd = caocUsuUpd;
		this.caocIpUpd = caocIpUpd;
		this.caocFlgeli = caocFlgeli;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				naocCodigo,
				nactCodigo,
				cacmCodigo,
				naocCodTipoorgctrl,
				caocCodOrgctrl,
				caocFlgActivo,
				daocFecIns,
				caocUsuIns,
				caocIpIns,
				daocFecUpd,
				caocUsuUpd,
				caocIpUpd,
				caocFlgeli

		);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignarActivUoOciRequest other = (AsignarActivUoOciRequest) obj;
		return Objects.equals(naocCodigo, other.naocCodigo) &&
				Objects.equals(nactCodigo, other.nactCodigo) &&
				Objects.equals(cacmCodigo, other.cacmCodigo) &&
				Objects.equals(naocCodTipoorgctrl, other.naocCodTipoorgctrl) &&
				Objects.equals(caocCodOrgctrl, other.caocCodOrgctrl) &&
				Objects.equals(caocFlgActivo, other.caocFlgActivo) &&
				Objects.equals(daocFecIns, other.daocFecIns) &&
				Objects.equals(caocUsuIns, other.caocUsuIns) &&
				Objects.equals(caocIpIns, other.caocIpIns) &&
				Objects.equals(daocFecUpd, other.daocFecUpd) &&
				Objects.equals(caocUsuUpd, other.caocUsuUpd) &&
				Objects.equals(caocIpUpd, other.caocIpUpd) &&
				Objects.equals(caocFlgeli, other.caocFlgeli);
	}
}