package pe.gob.contraloria.bspscgestorpei.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.gob.contraloria.bspscgestorpei.persistence.model.SscPscPeiActividadOrgctrl;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
public class AsignarActivUoOciResponse implements Serializable {

    private static final long serialVersionUID = -7062413792553162962L;
    private Long naocCodigo;
    private Long nactCodigo;
    private Long cacmCodigo;
    private Long naocCodTipoorgctrl;
    private String caocCodOrgctrl;
    private String caocFlgActivo;
    private Date daocFecIns;
    private String caocUsuIns;
    private String caocIpIns;
    private Date daocFecUpd;
    private String caocUsuUpd;
    private String caocIpUpd;
    private String caocFlgeli;

    public AsignarActivUoOciResponse(
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
        AsignarActivUoOciResponse other = (AsignarActivUoOciResponse) obj;
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