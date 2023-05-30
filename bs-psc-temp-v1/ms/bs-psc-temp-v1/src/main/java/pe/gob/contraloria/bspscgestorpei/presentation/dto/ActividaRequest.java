package pe.gob.contraloria.bspscgestorpei.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ActividaRequest {
    private Long codigo;
    //NACT_CODIGO
    private String codInterno;
    private String nombre;

    private List<AsignarActivUoOciRequest> listAsignarActivUoOciRequest;
}
