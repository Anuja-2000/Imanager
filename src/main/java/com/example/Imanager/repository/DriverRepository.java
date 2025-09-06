package com.example.Imanager.repository;


import com.example.Imanager.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findByName(String name);

    Driver findByLicenseNumber(String licenseNumber);

    Driver findByNic(String nic);

    Driver findByContactNumber(String contactNumber);

    Driver findByBankAccountNumber(String bankAccountNumber);

    Driver findByCommissionPercentage(String commissionPercentage);

}
