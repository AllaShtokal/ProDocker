package alla.shtokal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Entity
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
    public  void addEvent(Event ev){
        this.events.add(ev);

    }
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
