package alla.shtokal.dto.foreigndto.event;

import java.util.List;

public class TaskListDto {

    private List<TaskDTO> listEvents;

    public List<TaskDTO> getListEvents() {
        return listEvents;
    }

    public void setListEvents(List<TaskDTO> listEvents) {
        this.listEvents = listEvents;
    }
}
