package alla.shtokal.repository;

import alla.shtokal.model.PowerStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PowerStationRepository extends JpaRepository<PowerStation, Long> {

    //@Query("From PowerStation ps where ps.name = :name  ")
    //Optional<PowerStation> dgdd (@Param("name") String name);
}
