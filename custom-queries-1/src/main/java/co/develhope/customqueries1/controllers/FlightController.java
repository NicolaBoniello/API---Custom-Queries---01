package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.enums.FlightStatusEnum;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @PostMapping("/add")
    public ResponseEntity<List<Flight>> addFlights(){
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Description: " + random.ints(100, 999).findFirst().getAsInt());
            flight.setFromAirport("From Airport: " + random.ints(100, 999).findFirst().getAsInt());
            flight.setToAirport("To Airport: " + random.ints(100, 999).findFirst().getAsInt());
            flight.setFlightStatusEnum(FlightStatusEnum.ONTIME);
            flights.add(flight);
        }
        flightRepository.saveAllAndFlush(flights);
        return ResponseEntity.ok().build();

        }

        @GetMapping("/get_all")
    public List<Flight> getAllFlights(Flight flight){
        return flightRepository.findAll();
    }
    }
