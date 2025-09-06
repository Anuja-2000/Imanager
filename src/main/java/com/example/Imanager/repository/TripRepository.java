package com.example.Imanager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Imanager.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    Trip findById(int tripId);

}
