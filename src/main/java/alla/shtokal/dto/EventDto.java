package alla.shtokal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class EventDto {

    private Long id;

    @NotBlank
    private String namePowerStation;

    @NotNull
    private TaskType taskType;

    @NotNull
    private int powerLoss;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePowerStation() {
        return namePowerStation;
    }

    public void setNamePowerStation(String namePowerStation) {
        this.namePowerStation = namePowerStation;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
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

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", namePowerStation='" + namePowerStation + '\'' +
                ", taskType=" + taskType +
                ", powerLoss=" + powerLoss +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
