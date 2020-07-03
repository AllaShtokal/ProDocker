package alla.shtokal.service;

import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.PowerStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PowerStationImplementation implements PowerStationService {

    @Autowired
    PowerStationRepository powerStationRepository;

    @Override
    public PowerStation getById(Long id) {
        return powerStationRepository.findById(id).get();
    }

    @Override
    public void add(PowerStation powerStation) {
        powerStationRepository.save(powerStation);
    }

    @Override
    public void delete(Long id) {
        powerStationRepository.deleteById(id);
    }

    @Override
    public Collection<PowerStation> getAllPowerStations() {
        return powerStationRepository.findAll();
    }

    /**
     * b)Należy przygotować metodę przyjmującą datę,
     * a zwracającą mapę, w której kluczami będą ID elektrowni,
     * a wartościami moc na dany dzień.
     */
    @Override
    public Map<Long, Integer> getPowerMapByDate(Timestamp time) {
        Map<Long, Integer> powerMap = new HashMap<>();
        List<PowerStation> stations = (List<PowerStation>) getAllPowerStations();
        for (PowerStation station : stations) {
            int power = station.getPower();
            List<Event> eventsForCurrentStation = station.getEvents();
            for (Event event : eventsForCurrentStation) {
                if (time.after(event.getStartDate()) && time.before(event.getEndDate()))
                    power -= event.getPowerLoss();
            }
            powerMap.put(station.getId(), power);
        }
        return powerMap;
    }

}
