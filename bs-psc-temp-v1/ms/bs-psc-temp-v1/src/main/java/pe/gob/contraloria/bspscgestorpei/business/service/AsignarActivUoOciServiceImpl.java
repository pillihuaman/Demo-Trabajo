package pe.gob.contraloria.bspscgestorpei.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.gob.contraloria.bspscgestorpei.business.client.pojo.HeaderRequest;
import pe.gob.contraloria.bspscgestorpei.persistence.model.SscPscPeiActividadOrgctrl;
import pe.gob.contraloria.bspscgestorpei.persistence.repository.AsignarActivUoOciRepository;
import pe.gob.contraloria.bspscgestorpei.presentation.dto.*;
import pe.gob.contraloria.bspscgestorpei.util.Constantes;
import pe.gob.contraloria.bspscgestorpei.util.LoadConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AsignarActivUoOciServiceImpl implements AsignarActivUoOciService {

    private static final Logger log = LoggerFactory.getLogger(AsignarActivUoOciServiceImpl.class);

    @Autowired
    private LoadConstants constants;
    @Autowired
    private AsignarActivUoOciRepository asignarActivUoOciRepository;

    private HeaderRequest headerRequest = null;

    @Override
    public List<AsignarActivUoOciResponse> listaActividadUoOci(int pageSize, int pageNumber, String ordenar) {

        List<SscPscPeiActividadOrgctrl> resultList = asignarActivUoOciRepository.findAll();


        log.info("AsignarActivUoOciServiceImpl.listaActividadUoOci(id={} )");
        if (resultList == null)
            return null;
        return listActivUoOciResToActividadOrgctrl(resultList);
    }

    @Override
    public List<AsignarActivUoOciResponse> createAsignacion(AsignarActividadRequest req, String ipClient, String userLogin) {
        log.info("SscPscPeiEquipoServiceImpl.createPeiEquipo(request={}, ipClient={}, userLogin={})", req);
    List<AsignarActivUoOciResponse> res= new ArrayList<>();
        if (Boolean.TRUE.equals(isValid(req))) {
            for (OrganoControlRequest reqs:
                    req.getListOrganoControlRequest() ) {
                for (ActividaRequest re :
                        reqs.getListActividad() ) {
                    for (AsignarActivUoOciRequest ret   :
                            re.getListAsignarActivUoOciRequest()) {
                        SscPscPeiActividadOrgctrl sccPsx = ActivUoOciReqToActividadOrgctrl(ret);
                        sccPsx.setCaocUsuIns(userLogin);
                        sccPsx.setCaocIpIns(ipClient);
                        sccPsx.setDaocFecIns(new Date());
                        SscPscPeiActividadOrgctrl saved = asignarActivUoOciRepository.save(sccPsx);
                        res.add(ActivUoOciResToActividadOrgctrl(saved));
                        log.info(" saved = {}  ", saved.toString());
                    }

                }

            }

            return res;
        }
        return null;
    }

    private List<AsignarActivUoOciResponse> listActivUoOciResToActividadOrgctrl(List<SscPscPeiActividadOrgctrl> lsit) {
        List<AsignarActivUoOciResponse> listres = new ArrayList<>();
        if (!lsit.isEmpty()) {
            if (lsit.size() > 0) {
                for (SscPscPeiActividadOrgctrl sscPscPeiActividadOrgctrl :
                        lsit) {
                    AsignarActivUoOciResponse sccPs = AsignarActivUoOciResponse.builder()
                            .caocCodOrgctrl(sscPscPeiActividadOrgctrl.getCaocCodOrgctrl())
                            .caocFlgActivo(sscPscPeiActividadOrgctrl.getCaocFlgActivo())
                            .caocUsuIns(sscPscPeiActividadOrgctrl.getCaocUsuIns())
                            .nactCodigo(sscPscPeiActividadOrgctrl.getNactCodigo())
                            .naocCodTipoorgctrl(sscPscPeiActividadOrgctrl.getNaocCodTipoorgctrl())
                            .naocCodigo(sscPscPeiActividadOrgctrl.getNaocCodigo())
                            .caocFlgeli(sscPscPeiActividadOrgctrl.getCaocFlgeli()).build();
                    listres.add(sccPs);
                }

            }
        }
        return listres;
    }

    private AsignarActivUoOciResponse ActivUoOciResToActividadOrgctrl(SscPscPeiActividadOrgctrl rre) {
        AsignarActivUoOciResponse sccPs = null;
        if (rre != null) {

            sccPs = AsignarActivUoOciResponse.builder()
                    .caocCodOrgctrl(rre.getCaocCodOrgctrl())
                    .caocFlgActivo(rre.getCaocFlgActivo())
                    .caocUsuIns(rre.getCaocUsuIns())
                    .nactCodigo(rre.getNactCodigo())
                    .naocCodTipoorgctrl(rre.getNaocCodTipoorgctrl())
                    .naocCodigo(rre.getNaocCodigo())
                    .caocFlgeli(rre.getCaocFlgeli()).build();
        }
        return sccPs;
    }

    private SscPscPeiActividadOrgctrl ActivUoOciReqToActividadOrgctrl(AsignarActivUoOciRequest re) {
        SscPscPeiActividadOrgctrl resp = new SscPscPeiActividadOrgctrl();
        if (re != null) {

            resp = SscPscPeiActividadOrgctrl.builder()
                    .caocCodOrgctrl(re.getCaocCodOrgctrl())
                    .caocFlgActivo(re.getCaocFlgActivo())
                    .caocUsuIns(re.getCaocUsuIns())
                    .nactCodigo(re.getNactCodigo())
                    .naocCodTipoorgctrl(re.getNaocCodTipoorgctrl())
                    .naocCodigo(re.getNaocCodigo())
                    .caocFlgeli(re.getCaocFlgeli()).build();


        }

        return resp;
    }

    public Boolean isValid(AsignarActividadRequest request) {
        return true;
    }
}
