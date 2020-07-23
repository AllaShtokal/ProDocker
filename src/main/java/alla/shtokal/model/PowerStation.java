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
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "station")
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
    public PowerStation(Long id,String name, int power) {
        this.name = name;
        this.id = id;
        this.power = power;
    }

    public void addEvent(Event ev) {
        this.events.add(ev);
        ev.setStation(this);

    }
}
