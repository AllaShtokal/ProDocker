package alla.shtokal.service;

import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.PowerStationRepository;

import alla.shtokal.service.station.PowerStationImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class PowerStationImplementationTest {
    @Mock
    private PowerStationRepository psRepository;

    @InjectMocks
    private PowerStationImplementation eventImplementation;

    @Test
    public void test1getById() {
        PowerStation ps = new PowerStation("AWARIA", 1);
        given(psRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(ps));

        PowerStation byId = eventImplementation.getById(1L);

        then(psRepository).should().findById(1L);
        assertEquals(byId.getName(), "AWARIA");


    }

    @Test
    void testAddPowerStation() {
        PowerStation station = new PowerStation("Nazwa", 1555);

        eventImplementation.add(station);
        then(psRepository).should().save(station);
        assertEquals( "Nazwa",station.getName());


    }

}