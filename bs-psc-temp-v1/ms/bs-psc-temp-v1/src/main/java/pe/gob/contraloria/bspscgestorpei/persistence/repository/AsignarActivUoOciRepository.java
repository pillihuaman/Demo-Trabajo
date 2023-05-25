package pe.gob.contraloria.bspscgestorpei.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.gob.contraloria.bspscgestorpei.persistence.model.SscPscPeiActividadOrgctrl;

public interface AsignarActivUoOciRepository extends JpaRepository<SscPscPeiActividadOrgctrl, Long> {
    //@Query("SELECT e FROM SscPscPeiComite e WHERE e.ccomFlgTipointeg = :ccomflgtipointeg")
    //Page<SscPscPeiComite> listPeiComite(@Param("ccomflgtipointeg") String ccomflgtipointeg, Pageable pageable);
}



