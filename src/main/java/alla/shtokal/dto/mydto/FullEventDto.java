package alla.shtokal.dto.mydto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Setter
@Getter
public class FullEventDto {


    @NotNull
    private Long psId;
    @NotNull
    private String psName;
    @NotNull
    private int power;


//
    @NotNull
    private String eventType;

    private Long id;

    @NotNull
    private int powerLoss;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;
}
