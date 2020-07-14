package alla.shtokal.dto.mydto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
public class FullEventDto implements Serializable {

    
    private Long id;

    @NotNull
    private String eventType;

    @NotNull
    private int powerLoss;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;

    @NotNull
    private Long psId;

    @NotNull
    private String psName;

    @NotNull
    private int psPower;

    public FullEventDto(Long id) {
    }

    public FullEventDto() {

    }
}
