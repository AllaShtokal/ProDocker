package alla.shtokal.rest;

import alla.shtokal.model.PowerStation;
import alla.shtokal.service.PowerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stations")
public class PowerStationRestController {
    @Autowired
    private PowerStationService powerStationService;

    //getById
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PowerStation> getPowerStation(@PathVariable("id") Long powerStationId) {
        if (powerStationId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PowerStation powerStation = this.powerStationService.getById(powerStationId);
        if (powerStation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(powerStation, HttpStatus.OK);

    }

    //getAll
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<PowerStation>> getAllPowerStations() {
        List<PowerStation> stations = (List<PowerStation>) this.powerStationService.getAllPowerStations();

        if (stations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    //deleteById
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PowerStation> deleteStation(@PathVariable("id") Long id) {
        PowerStation station = this.powerStationService.getById(id);

        if (station == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.powerStationService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //POST add new object
    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<PowerStation> saveStation( PowerStation station) {
        HttpHeaders headers = new HttpHeaders();
        if (station == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.powerStationService.add(station);
        return new ResponseEntity<>(station, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PowerStation> updateCustomer(
            @PathVariable("id") Long id,  PowerStation stationDetails) {
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