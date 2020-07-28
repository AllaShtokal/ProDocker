package alla.shtokal.elasticsearch.station;

import alla.shtokal.anotations.LogController;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "/api/v1/stations/search")
@Profile("elasticSearch")
public class StationElasticController {
    private final ElasticSearchStationRepository elasticSearchStationRepository;
    private final StationDtoElasticSearchService stationDtoElasticSearchService;

    public StationElasticController(ElasticSearchStationRepository elasticSearchStationRepository, StationDtoElasticSearchService stationDtoElasticSearchService) {
        this.elasticSearchStationRepository = elasticSearchStationRepository;
        this.stationDtoElasticSearchService = stationDtoElasticSearchService;
    }


    @LogController
    @GetMapping(value = "/getAllFromElastic")
    public ResponseEntity<Collection<StationDtoElasticSearch>> getAllFromElastic() {


        List<StationDtoElasticSearch> stations = (List<StationDtoElasticSearch>) stationDtoElasticSearchService.getAll();

        if (stations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(stations, HttpStatus.OK);
    }


    /**
     * get powerStation By Id
     **/
    @GetMapping(value = "/getByIdFromElastic/{id}")
    public ResponseEntity<List<StationDtoElasticSearch>> getByIdFromElastic(@PathVariable("id") Long psId) {
        if (psId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        StationDtoElasticSearch stationDtoElasticSearch = stationDtoElasticSearchService.getById(psId);
        if (stationDtoElasticSearch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<StationDtoElasticSearch> list = new ArrayList<>();
        list.add(stationDtoElasticSearch);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<List<StationDtoElasticSearch>>getByNameFromElastic(@PathVariable("name") String name) {
        List<StationDtoElasticSearch> firstByName = elasticSearchStationRepository.findByName(name);
        return new ResponseEntity<>(firstByName, HttpStatus.OK);

    }

    @GetMapping(value = "/getByPower/{power}")
    public ResponseEntity<List<StationDtoElasticSearch>>getByPowerFromElastic(@PathVariable("power") int power) {
        List<StationDtoElasticSearch> firstByName = elasticSearchStationRepository.findByPower(power);
        return new ResponseEntity<>(firstByName, HttpStatus.OK);
    }

    @GetMapping(value = "/addAllFromJPA")
    public ResponseEntity<String> addAllFromJPA() {

        String d =  stationDtoElasticSearchService.add();

        return new ResponseEntity<>(d, HttpStatus.OK);
    }


}
