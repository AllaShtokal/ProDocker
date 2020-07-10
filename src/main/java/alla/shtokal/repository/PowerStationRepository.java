package alla.shtokal.repository;

import alla.shtokal.model.PowerStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PowerStationRepository extends JpaRepository<PowerStation, Long> {

    @Query("SELECT p.id FROM PowerStation p WHERE p.name = :name  ")
    List<Integer> findByNamePowerSt(String name);

    Optional<PowerStation> findFirstByName(String name);


}
