package alla.shtokal.dto.foreigndto.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
public class EventDto {

    private Long id;

    @NotBlank
    private String namePowerStation;

    @NotNull
    private TaskType taskType;

    @NotNull
    private int powerLoss;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;


}
