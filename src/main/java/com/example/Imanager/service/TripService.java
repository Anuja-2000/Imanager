package com.example.Imanager.service;
import com.example.Imanager.repository.TripRepository;
import com.example.Imanager.dao.TripDAO;
import com.example.Imanager.dto.TripDTO;
import com.example.Imanager.entity.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripDAO tripDAO;

    public TripDTO createTrip(TripDTO tripDTO) {

        tripDAO.createTrip(tripDTO.getEntity());
        TripDTO createdTrip = new TripDTO(tripDTO.getEntity());
        return createdTrip;
    }

    public TripDTO getTripById(int id) {
        Trip trip = tripDAO.getTripById(id);
        return trip != null ? new TripDTO(trip) : null; 
    }

    public List<TripDTO> getAllTrips() {
        return tripDAO.getAllTrips().stream()
                .map(TripDTO::new)
                .toList();
    }

    public void updateTrip(int id, TripDTO tripDTO) {
        // Logic to update an existing trip
    }

    public void deleteTrip(int id) {
        // Logic to delete a trip
    }
}
