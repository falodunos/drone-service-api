package com.drone.manager.model;

import com.drone.manager.model.audit.DateAudit;
import com.drone.manager.model.enums.DroneModel;
import com.drone.manager.model.enums.DroneState;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Data
@Entity
@Table(name="drone")
@EntityListeners(AuditingEntityListener.class)
public class Drone extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, columnDefinition = "varchar(100)")
    private  String serialNumber;

    @Column(name = "model", nullable = false, columnDefinition = "varchar(30)")
    private  DroneModel model;

    @Column(name = "weight_limit", nullable = false, columnDefinition = "varchar(20)")
    private  String weightLimit;

    @Column(name = "battery_capacity", nullable = false, columnDefinition = "varchar(10)")
    private  double batteryCapacity;

    @Column(name = "state", nullable = false, columnDefinition = "varchar(30) default 'IDLE'")
    DroneState state;

    public Drone() {
    }

    public Drone(String serialNumber, DroneModel model, String weightLimit, double batteryCapacity, DroneState state) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", weightLimit='" + weightLimit + '\'' +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
