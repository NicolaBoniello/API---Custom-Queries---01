package co.develhope.customqueries1.entities;

import co.develhope.customqueries1.enums.FlightStatusEnum;

import javax.persistence.*;

@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String description;
    private String fromAirport;
    private String toAirport;

    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    private FlightStatusEnum flightStatusEnum;

    public Flight() {
    }

    public Flight(Long id, String description, String fromAirport, String toAirport, FlightStatusEnum flightStatusEnum) {
        this.id = id;
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.flightStatusEnum = flightStatusEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public FlightStatusEnum getFlightStatusEnum() {
        return flightStatusEnum;
    }

    public void setFlightStatusEnum(FlightStatusEnum flightStatusEnum) {
        this.flightStatusEnum = flightStatusEnum;
    }
}