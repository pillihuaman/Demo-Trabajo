package pe.gob.contraloria.bspscgestorpei.presentation.dto;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class OrganoControlRequest {


    private Long ntabCodigo;
    private String ctabCodmaestro;
    private String ctabCodInterno;
    private String ctabNombre;
    private String ctabDescripcion;
    private String ctabAbrevia;
    private Long ntabTipo;
    private Date dtabInivigencia;
    private Date dtabFinvigencia;
    private String ctabEstado;
    private Long ntabPredecesor;
    private Long ntabOrden;
    private String ctabRutaSustento;
    private String ctabValor;
    private String ctabEntrada;
    private String ctabSalida;
    private String ctabIpIns;
    private String ctabIpUpd;
    private String ctabUsuIns;
    private String ctabUsuUpd;
    private Date dtabFecIns;
    private Date dtabFecUpd;
    private String ctabFlgeli;
    private List<ActividaRequest> listActividad;

    public OrganoControlRequest(Long ntabCodigo, String ctabCodmaestro, String ctabCodInterno, String ctabNombre,
                                String ctabDescripcion, String ctabAbrevia, Long ntabTipo, Date dtabInivigencia, Date dtabFinvigencia,
                                String ctabEstado, Long ntabPredecesor, Long ntabOrden, String ctabRutaSustento, String ctabValor,
                                String ctabEntrada, String ctabSalida, String ctabIpIns, String ctabIpUpd, String ctabUsuIns,
                                String ctabUsuUpd, Date dtabFecIns, Date dtabFecUpd, String ctabFlgeli ,List<ActividaRequest> listActividad) {
        super();
        this.ntabCodigo = ntabCodigo;
        this.ctabCodmaestro = ctabCodmaestro;
        this.ctabCodInterno = ctabCodInterno;
        this.ctabNombre = ctabNombre;
        this.ctabDescripcion = ctabDescripcion;
        this.ctabAbrevia = ctabAbrevia;
        this.ntabTipo = ntabTipo;
        this.dtabInivigencia = dtabInivigencia;
        this.dtabFinvigencia = dtabFinvigencia;
        this.ctabEstado = ctabEstado;
        this.ntabPredecesor = ntabPredecesor;
        this.ntabOrden = ntabOrden;
        this.ctabRutaSustento = ctabRutaSustento;
        this.ctabValor = ctabValor;
        this.ctabEntrada = ctabEntrada;
        this.ctabSalida = ctabSalida;
        this.ctabIpIns = ctabIpIns;
        this.ctabIpUpd = ctabIpUpd;
        this.ctabUsuIns = ctabUsuIns;
        this.ctabUsuUpd = ctabUsuUpd;
        this.dtabFecIns = dtabFecIns;
        this.dtabFecUpd = dtabFecUpd;
        this.ctabFlgeli = ctabFlgeli;
        this.listActividad = listActividad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctabAbrevia, ctabCodInterno, ctabCodmaestro, ctabDescripcion, ctabEntrada, ctabEstado,
                ctabFlgeli, ctabIpIns, ctabIpUpd, ctabNombre, ctabRutaSustento, ctabSalida, ctabUsuIns, ctabUsuUpd,
                ctabValor, dtabFecIns, dtabFecUpd, dtabFinvigencia, dtabInivigencia, ntabCodigo, ntabOrden,
                ntabPredecesor, ntabTipo,listActividad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrganoControlRequest other = (OrganoControlRequest) obj;
        return Objects.equals(ctabAbrevia, other.ctabAbrevia) && Objects.equals(ctabCodInterno, other.ctabCodInterno)
                && Objects.equals(ctabCodmaestro, other.ctabCodmaestro)
                && Objects.equals(ctabDescripcion, other.ctabDescripcion)
                && Objects.equals(ctabEntrada, other.ctabEntrada) && Objects.equals(ctabEstado, other.ctabEstado)
                && Objects.equals(ctabFlgeli, other.ctabFlgeli) && Objects.equals(ctabIpIns, other.ctabIpIns)
                && Objects.equals(ctabIpUpd, other.ctabIpUpd) && Objects.equals(ctabNombre, other.ctabNombre)
                && Objects.equals(ctabRutaSustento, other.ctabRutaSustento)
                && Objects.equals(ctabSalida, other.ctabSalida) && Objects.equals(ctabUsuIns, other.ctabUsuIns)
                && Objects.equals(ctabUsuUpd, other.ctabUsuUpd) && Objects.equals(ctabValor, other.ctabValor)
                && Objects.equals(dtabFecIns, other.dtabFecIns) && Objects.equals(dtabFecUpd, other.dtabFecUpd)
                && Objects.equals(dtabFinvigencia, other.dtabFinvigencia)
                && Objects.equals(dtabInivigencia, other.dtabInivigencia)
                && Objects.equals(ntabCodigo, other.ntabCodigo) && Objects.equals(ntabOrden, other.ntabOrden)
                && Objects.equals(ntabPredecesor, other.ntabPredecesor) && Objects.equals(ntabTipo, other.ntabTipo)&& Objects.equals(listActividad, other.listActividad);
    }
}








