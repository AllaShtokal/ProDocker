package alla.shtokal.service;

import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.PowerStationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PowerStationImplementation implements PowerStationService {


    private final PowerStationRepository powerStationRepository;



    public PowerStationImplementation(PowerStationRepository powerStationRepository) {
        this.powerStationRepository = powerStationRepository;
    }

    @Override
    @Transactional
    public PowerStation getById(Long id) {


        PowerStation powerStation = powerStationRepository.findById(id).get();
        powerStation.getEvents().stream().forEach(event -> event.setPowerLoss(event.getPowerLoss() + 19));
        return  powerStation;
    }

    @Override
    @Transactional
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
