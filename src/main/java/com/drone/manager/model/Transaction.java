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

    @Column(name = "package_reference", nullable = false, unique = true, columnDefinition = "varchar(10)")
    private Long packageReference;

    @Column(name = "drone_id", nullable = false, columnDefinition = "integer")
    private Long droneId;

    @Column(name = "medication_id", nullable = false, columnDefinition = "integer")
    private Long medicationId;
}
