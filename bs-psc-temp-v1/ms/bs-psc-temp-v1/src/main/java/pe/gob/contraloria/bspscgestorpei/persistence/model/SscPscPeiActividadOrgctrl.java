package pe.gob.contraloria.bspscgestorpei.persistence.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "SSC_PSC_PEI_ACTIVIDAD_ORGCTRL")
public class SscPscPeiActividadOrgctrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NAOC_CODIGO", nullable = false)
    private Long naocCodigo;
    @Column(name = "NACT_CODIGO", nullable = false)
    private Long nactCodigo;
    @Column(name = "CACM_CODIGO", nullable = true)
    private Long cacmCodigo;
    @Column(name = "NAOC_COD_TIPOORGCTRL", nullable = false)
    private Long naocCodTipoorgctrl;
    @Column(name = "CAOC_COD_ORGCTRL", nullable = false)
    private String caocCodOrgctrl;
    @Column(name = "CAOC_FLG_ACTIVO", nullable = true)
    private String caocFlgActivo;
    @Column(name = "DAOC_FEC_INS", nullable = false)
    private Date daocFecIns;
    @Column(name = "CAOC_USU_INS", nullable = false)
    private String caocUsuIns;
    @Column(name = "CAOC_IP_INS", nullable = true)
    private String caocIpIns;
    @Column(name = "DAOC_FEC_UPD", nullable = true)
    private Date daocFecUpd;
    @Column(name = "CAOC_USU_UPD", nullable = true)
    private String caocUsuUpd;
    @Column(name = "CAOC_IP_UPD", nullable = true)
    private String caocIpUpd;
    @Column(name = "CAOC_FLGELI", nullable = true)
    private String caocFlgeli;

    public SscPscPeiActividadOrgctrl(
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
        SscPscPeiActividadOrgctrl other = (SscPscPeiActividadOrgctrl) obj;
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