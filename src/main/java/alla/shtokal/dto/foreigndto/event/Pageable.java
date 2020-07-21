package alla.shtokal.dto.foreigndto.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pageable {
    Sort SortObject;
    private float offset;
    private float pageNumber;
    private float pageSize;
    private boolean paged;
    private boolean unpaged;

}