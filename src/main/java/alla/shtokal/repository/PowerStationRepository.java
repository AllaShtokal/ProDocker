package alla.shtokal.repository;

import alla.shtokal.model.PowerStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PowerStationRepository extends JpaRepository<PowerStation, Long> {


}
