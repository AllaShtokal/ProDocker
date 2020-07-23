package alla.shtokal.rest;

import alla.shtokal.model.PowerStation;
import alla.shtokal.service.station.PowerStationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stations")
public class PowerStationRestController {


    private final PowerStationService powerStationService;

    public PowerStationRestController(PowerStationService powerStationService) {
        this.powerStationService = powerStationService;
    }

    /**
     * Get Station By Id
     **/
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<PowerStation>> getPowerStation( @PathVariable("id")  Long powerStationId) {
        if (powerStationId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PowerStation powerStation = this.powerStationService.getById(powerStationId);
        if (powerStation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        List<PowerStation> powerStationList = new ArrayList<>();
//        powerStationList.add(powerStation);

        return new ResponseEntity<>(Collections.singletonList(powerStation), HttpStatus.OK);
    }

    /**
     * Get All Stations
     **/
    @GetMapping(value = "")
    public ResponseEntity<List<PowerStation>> getAllPowerStations() {
        List<PowerStation> stations = (List<PowerStation>) this.powerStationService.getAllPowerStations();
        if (stations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    /**
     * Delete Station By Id
     **/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PowerStation> deleteStation(@PathVariable("id") Long id) {
        PowerStation station = this.powerStationService.getById(id);

        if (station == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.powerStationService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Add Station
     **/
    @PostMapping(value = "/add")
    public ResponseEntity<PowerStation> saveStation(@Validated @RequestBody  PowerStation station) {
        HttpHeaders headers = new HttpHeaders();
        if (station == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.powerStationService.add(station);
        return new ResponseEntity<>(station, headers, HttpStatus.CREATED);
    }

    /**
     * Update Station By Id
     **/
    @PutMapping(value = "/update")
    public ResponseEntity<PowerStation> updateCustomer(
            @PathVariable("id") Long id, @RequestBody PowerStation stationDetails) {
        HttpHeaders headers = new HttpHeaders();
        PowerStation powerStation = this.powerStationService.getById(id);
        if (powerStation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        powerStation.setName(stationDetails.getName());
        powerStation.setPower(stationDetails.getPower());

        this.powerStationService.add(powerStation);

        return new ResponseEntity<>(powerStation, headers, HttpStatus.OK);
    }


}
