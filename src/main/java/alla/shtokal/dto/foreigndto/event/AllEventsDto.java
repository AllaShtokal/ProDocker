package alla.shtokal.dto.foreigndto.event;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class AllEventsDto implements Serializable {
    List<TaskDTO> content = new ArrayList<>();
    Pageable pageableObject;
    private boolean last;
    private float totalElements;
    private float totalPages;
    private float number;
    private float size;
    Sort sortObject;
    private float numberOfElements;
    private boolean first;
    private boolean empty;


}


