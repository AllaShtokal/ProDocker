package alla.shtokal.dto.foreigndto.event;

import java.util.List;

public class EventListDto  {

    private List<EventDTO> listEvents ;

    public List<EventDTO> getListEvents() {
        return listEvents;
    }

    public void setListEvents(List<EventDTO> listEvents) {
        this.listEvents = listEvents;
    }
}
