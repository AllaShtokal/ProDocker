package alla.shtokal.service;

import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.EventRepository;

import alla.shtokal.service.event.EventImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class EventImplementationTest {

    @Mock
    EventRepository eventRepository;

    @InjectMocks
    EventImplementation eventImplementation;

    @Test
    void testGetById() {
        Event event = new Event("AWARIA", 1L);
        when(eventRepository.findById(1L)).thenReturn(java.util.Optional.of(event));
        Event byId = eventImplementation.getById(1L);
        then(eventRepository).should().findById(1L);
        assertEquals(byId.getEventType(), "AWARIA");


    }

    @Test
    void testAddEvent() {
        Event event = new Event("AWARIA", 1L);

        eventImplementation.add(event);
        then(eventRepository).should().save(event);
        assertEquals( "AWARIA",event.getEventType());


    }

    @Test
    void testGetNumberOfAwariaEventsById() {
        List<Event> events =new ArrayList<>();
        PowerStation powerStation =new PowerStation(1L,"nowa",5000);
        events.add(new Event("AWARIA", 1L,powerStation));
        events.add(new Event("AWARIA", 2L,powerStation));
        events.add(new Event("ReMont", 3L,powerStation));
        events.add(new Event("AWARIA", 4L,powerStation));
        when(eventRepository.findAll()).thenReturn(events);
        int numberOfAwariaEventsById = eventImplementation.getNumberOfAwariaEventsById(1L);
        assertEquals(3, numberOfAwariaEventsById);



    }


}