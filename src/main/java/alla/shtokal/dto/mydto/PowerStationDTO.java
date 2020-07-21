package alla.shtokal.dto.mydto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PowerStationDTO implements Serializable {

    private Long id;
    private String name;
    private int power;

    public PowerStationDTO(Long id, String name, int power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }
}
