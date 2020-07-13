package alla.shtokal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "zdarzenia")
public class Event extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_elektrowni")
    @JsonBackReference
    private PowerStation station;

    @Column(name = "typ_zdarzenia")
    private String eventType;

    @Column(name = "ubytek_mocy")
    private int powerLoss;

    @Column(name = "data_rozpoczecia")
    private Timestamp startDate;

    @Column(name = "data_zakonczenia")
    private Timestamp endDate;

    public Event() {
    }


    public Event(PowerStation station, String eventType, int powerLoss, Timestamp startDate, Timestamp endDate) {
        this.station = station;
        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(Long id, String eventType, int powerLoss, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Event( String eventType, int powerLoss, Timestamp startDate, Timestamp endDate) {

        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Event( String eventType, Long id) {

        this.eventType = eventType;
        this.id = id;  }


}
