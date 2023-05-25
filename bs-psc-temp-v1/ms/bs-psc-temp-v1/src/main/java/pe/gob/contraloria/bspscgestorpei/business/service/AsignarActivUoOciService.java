package pe.gob.contraloria.bspscgestorpei.business.service;

import pe.gob.contraloria.bspscgestorpei.presentation.dto.AsignarActivUoOciRequest;
import pe.gob.contraloria.bspscgestorpei.presentation.dto.AsignarActivUoOciResponse;

import java.util.List;

public interface AsignarActivUoOciService {




    List<AsignarActivUoOciResponse> listaActividadUoOci(int pageSize , int pageNumber, String ordenar);
   AsignarActivUoOciResponse createAsignacion(AsignarActivUoOciRequest req,String ipClient,String userLogin);

}