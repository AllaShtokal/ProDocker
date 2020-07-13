package alla.shtokal.service;

import alla.shtokal.model.Event;
import alla.shtokal.repository.EventRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EventImplementationTest {

    @Mock
    EventRepository eventRepository;

    @InjectMocks
    EventImplementation eventImplementation;

    @Test
    public void test1getById() {
        Event event = new Event("AWARIA", 1L);
        given(eventRepository.getOne(any())).willReturn(event);
        Event byId = eventImplementation.getById(1L);
        then(eventRepository).should().findById(1L);
        assertEquals(byId.getEventType(), "AWARIA");


    }

}