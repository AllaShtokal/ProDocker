package alla.shtokal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "zdarzenia")
public class Event extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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

    public Event(Long id, Long id1, String eventType, int powerLoss, Timestamp startDate, Timestamp endDate) {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PowerStation getStation() {
        return station;
    }

    public void setStation(PowerStation station) {
        this.station = station;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getPowerLoss() {
        return powerLoss;
    }

    public void setPowerLoss(int powerLoss) {
        this.powerLoss = powerLoss;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
