package alla.shtokal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "zdarzenia")
public class Event  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_elektrowni")
    @JsonBackReference
    private PowerStation station;

    @Column(name = "typ_zdarzenia")
    private String eventType;

    @Column(name = "ubytek_mocy")
    private int powerLoss;

    @Column(name = "data_rozpoczecia")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp startDate;

    @Column(name = "data_zakonczenia")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp endDate;

    public Event() {
    }

    public Event(Long id, PowerStation station, String eventType , int powerLoss, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.station = station;
        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Event( String eventType, Long id,PowerStation ps) {

        this.eventType = eventType;
        this.id = id;
         this.station =ps;}

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", powerLoss=" + powerLoss +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
