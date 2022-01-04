package com.drone.manager.model;

import com.drone.manager.model.audit.DateAudit;
import com.drone.manager.model.enums.DroneModel;
import com.drone.manager.model.enums.DroneState;
import com.drone.manager.model.enums.MedicationState;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Data
@Entity
@Table(name="medication")
@EntityListeners(AuditingEntityListener.class)
public class Medication extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100)")
    private  String name;

    @Column(name = "weight", nullable = false, unique = true, columnDefinition = "varchar(10)")
    private  String weight;

    @Column(name = "code", nullable = false, unique = true, columnDefinition = "varchar(50)")
    private  String code;

    @Column(name = "image_path", nullable = false, unique = true, columnDefinition = "varchar(255)")
    private  String imagePath;

    @Column(name = "state", nullable = false, unique = true, columnDefinition = "varchar(20)")
    private MedicationState state;


    public Medication() {
    }

    public Medication(String name, String weight, String code, String imagePath, MedicationState state) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.imagePath = imagePath;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", code='" + code + '\'' +
                ", image='" + imagePath + '\'' +
                '}';
    }
}
