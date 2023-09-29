package com.example.lab7_20200825.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "site", schema = "lab7gtics")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "SiteName")
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location locationID;

    @Column(name = "InstallationDate")
    private LocalDate installationDate;

    @Size(max = 45)
    @Column(name = "Latitude", length = 45)
    private String latitude;

    @Size(max = 45)
    @Column(name = "Longitude", length = 45)
    private String longitude;


}