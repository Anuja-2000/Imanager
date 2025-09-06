package com.example.Imanager.dao;

import com.example.Imanager.entity.Trip;
import com.example.Imanager.repository.TripRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Component
public class TripDAO {

    @Autowired
    private TripRepository tripRepository;


    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip getTripById(int tripId) {
        return tripRepository.findById(tripId);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

}
