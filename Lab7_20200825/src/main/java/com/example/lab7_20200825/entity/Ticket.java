package com.example.lab7_20200825.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ticket", schema = "lab7gtics")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site siteID;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private Technician technicianID;

    @Size(max = 50)
    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "OpenedDate")
    private Instant openedDate;

    @Column(name = "ClosedDate")
    private Instant closedDate;

}