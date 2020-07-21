package alla.shtokal.service.station;

import alla.shtokal.model.PowerStation;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

public interface PowerStationService {

    PowerStation getById(Long id);
    void add(PowerStation powerStation);
    void delete(Long id);
    Collection<PowerStation> getAllPowerStations();
    Map<Long, Integer> getPowerMapByDate(Timestamp time);
}
