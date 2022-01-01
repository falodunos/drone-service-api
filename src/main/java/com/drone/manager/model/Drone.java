package com.drone.manager.model;

import com.drone.manager.model.audit.DateAudit;
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

    @Column(name = "model", nullable = false, unique = true, columnDefinition = "varchar(30)")
    private  String model;

    @Column(name = "weight_limit", nullable = false, unique = true, columnDefinition = "varchar(20)")
    private  String weightLimit;

    @Column(name = "battery_capacity", nullable = false, unique = true, columnDefinition = "varchar(10)")
    private  float batteryCapacity;

    @Column(name = "state", nullable = false, unique = true, columnDefinition = "varchar(10)")
    private  String state;


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
