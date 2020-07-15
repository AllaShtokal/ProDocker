package alla.shtokal.dto.foreigndto.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
public class EventDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String namePowerStation;

    @NotNull
    private TaskType taskType;

    @NotNull
    private BigDecimal powerLoss;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;


}
