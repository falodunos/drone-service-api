package com.drone.manager.model;

import com.drone.manager.model.audit.DateAudit;
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

    @Column(name = "image", nullable = false, unique = true, columnDefinition = "varchar(255)")
    private  String image;

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
