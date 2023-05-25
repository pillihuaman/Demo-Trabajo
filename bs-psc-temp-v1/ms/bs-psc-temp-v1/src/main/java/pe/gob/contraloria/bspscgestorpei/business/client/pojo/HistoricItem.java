package pe.gob.contraloria.bspscgestorpei.business.client.pojo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class HistoricItem {

	@JsonProperty("codigo")
	private Integer codigo = null;

	@JsonProperty("codMaestro")
	private String codMaestro = null;

	@JsonProperty("codInterno")
	private String codInterno = null;

	@JsonProperty("nombre")
	private String nombre = null;

	@JsonProperty("descripcion")
	private String descripcion = null;

	@JsonProperty("configuracion")
	private String configuracion = null;

	@JsonProperty("abrevia")
	private String abrevia = null;

	@JsonProperty("tipo")
	private Integer tipo = null;
	@JsonProperty("nombreTipo")
	private String nombreTipo = null;

	@JsonProperty("iniVigencia")
	private String iniVigencia = null;

	@JsonProperty("finVigencia")
	private String finVigencia = null;

	@JsonProperty("estado")
	private String estado = null;
	@JsonProperty("descripcionEstado")
	private String descripcionEstado = null;

	@JsonProperty("orden")
	private Integer orden = null;

	@JsonProperty("rutaSustento")
	private String rutaSustento = null;

	@JsonProperty("idPlantilla")
	private Integer idPlantilla = null;
	@JsonProperty("nombrePlantilla")
	private String nombrePlantilla = null;
	@JsonProperty("predecesor")
	private Integer predecesor = null;
	@JsonProperty("nombrePredecesor")
	private String nombrePredecesor = null;

	@JsonProperty("valor")
	private String valor = null;

	@JsonProperty("entrada")
	private String entrada = null;

	@JsonProperty("salida")
	private String salida = null;

	@JsonProperty("definicion")
	private String definicion = null;
	@JsonProperty("detalleRegla")
	private String detalleRegla = null;

	@JsonProperty("condiciones")
	private String condiciones = null;

	@JsonProperty("ipIns")
	private String ipIns = null;
	@JsonProperty("ipUpd")
	private String ipUpd = null;
	@JsonProperty("usuIns")
	private String usuIns = null;
	@JsonProperty("usUpd")
	private String usUpd = null;
	@JsonProperty("fecIns")
	private String fecIns = null;
	@JsonProperty("fecUpd")
	private String fecUpd = null;
	@JsonProperty("flgEli")
	private String flgEli = null;

	public HistoricItem(Integer codigo, String codMaestro, String codInterno, String nombre, String descripcion,
			String configuracion, String abrevia, Integer tipo, String nombreTipo, String iniVigencia,
			String finVigencia, String estado, String descripcionEstado, Integer orden, String rutaSustento,
			Integer idPlantilla, String nombrePlantilla, Integer predecesor, String nombrePredecesor, String valor,
			String entrada, String salida, String definicion, String detalleRegla, String condiciones, String ipIns,
			String ipUpd, String usuIns, String usUpd, String fecIns, String fecUpd, String flgEli) {
		super();
		this.codigo = codigo;
		this.codMaestro = codMaestro;
		this.codInterno = codInterno;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.configuracion = configuracion;
		this.abrevia = abrevia;
		this.tipo = tipo;
		this.nombreTipo = nombreTipo;
		this.iniVigencia = iniVigencia;
		this.finVigencia = finVigencia;
		this.estado = estado;
		this.descripcionEstado = descripcionEstado;
		this.orden = orden;
		this.rutaSustento = rutaSustento;
		this.idPlantilla = idPlantilla;
		this.nombrePlantilla = nombrePlantilla;
		this.predecesor = predecesor;
		this.nombrePredecesor = nombrePredecesor;
		this.valor = valor;
		this.entrada = entrada;
		this.salida = salida;
		this.definicion = definicion;
		this.detalleRegla = detalleRegla;
		this.condiciones = condiciones;
		this.ipIns = ipIns;
		this.ipUpd = ipUpd;
		this.usuIns = usuIns;
		this.usUpd = usUpd;
		this.fecIns = fecIns;
		this.fecUpd = fecUpd;
		this.flgEli = flgEli;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abrevia, codInterno, codMaestro, codigo, condiciones, configuracion, definicion,
				descripcion, descripcionEstado, detalleRegla, entrada, estado, fecIns, fecUpd, finVigencia, flgEli,
				idPlantilla, iniVigencia, ipIns, ipUpd, nombre, nombrePlantilla, nombrePredecesor, nombreTipo, orden,
				predecesor, rutaSustento, salida, tipo, usUpd, usuIns, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricItem other = (HistoricItem) obj;
		return Objects.equals(abrevia, other.abrevia) && Objects.equals(codInterno, other.codInterno)
				&& Objects.equals(codMaestro, other.codMaestro) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(condiciones, other.condiciones) && Objects.equals(configuracion, other.configuracion)
				&& Objects.equals(definicion, other.definicion) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(descripcionEstado, other.descripcionEstado)
				&& Objects.equals(detalleRegla, other.detalleRegla) && Objects.equals(entrada, other.entrada)
				&& Objects.equals(estado, other.estado) && Objects.equals(fecIns, other.fecIns)
				&& Objects.equals(fecUpd, other.fecUpd) && Objects.equals(finVigencia, other.finVigencia)
				&& Objects.equals(flgEli, other.flgEli) && Objects.equals(idPlantilla, other.idPlantilla)
				&& Objects.equals(iniVigencia, other.iniVigencia) && Objects.equals(ipIns, other.ipIns)
				&& Objects.equals(ipUpd, other.ipUpd) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(nombrePlantilla, other.nombrePlantilla)
				&& Objects.equals(nombrePredecesor, other.nombrePredecesor)
				&& Objects.equals(nombreTipo, other.nombreTipo) && Objects.equals(orden, other.orden)
				&& Objects.equals(predecesor, other.predecesor) && Objects.equals(rutaSustento, other.rutaSustento)
				&& Objects.equals(salida, other.salida) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(usUpd, other.usUpd) && Objects.equals(usuIns, other.usuIns)
				&& Objects.equals(valor, other.valor);
	}
}