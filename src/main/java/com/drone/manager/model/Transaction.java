package com.drone.manager.model;

import com.drone.manager.model.audit.DateAudit;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name="transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends DateAudit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "package_reference", nullable = false, unique = false, columnDefinition = "varchar(100)")
    private String packageReference;

    @Column(name = "drone_sn", nullable = false, columnDefinition = "varchar(100)")
    private String droneSn;

    @Column(name = "medication_code", nullable = false, columnDefinition = "varchar(100)")
    private String medicationCode;

    @Override
    public String toString() {
        return "Transaction{" +
                "Id=" + Id +
                ", packageReference='" + packageReference + '\'' +
                ", droneSn='" + droneSn + '\'' +
                ", medicationCode='" + medicationCode + '\'' +
                '}';
    }
}
