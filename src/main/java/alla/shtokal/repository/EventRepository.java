package alla.shtokal.repository;

import alla.shtokal.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    //List<Event> findAllByPowerLoss(int powloss);
    //@Query( value ="FROM Event  z join PowerStation ps WHERE z.powerLoss > 500 ORDER BY z.powerLoss desc")
    //List<Event> select1 (int name);
}
