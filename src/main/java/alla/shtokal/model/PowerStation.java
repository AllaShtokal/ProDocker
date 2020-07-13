package alla.shtokal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "elektrownie")
public class PowerStation extends BaseEntity implements Serializable {


    @Id
    @GeneratedValue
    //@NotNull(message = "validation message")
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "station")
    @JsonManagedReference
    private List<Event> events;


    @Column(name = "nazwa")
    private String name;

    @Column(name = "moc")
    private int power;

    public PowerStation() {
    }

    public PowerStation(String name, int power) {
        this.name = name;

        this.power = power;
    }

    public void addEvent(Event ev) {
        this.events.add(ev);

    }
}
