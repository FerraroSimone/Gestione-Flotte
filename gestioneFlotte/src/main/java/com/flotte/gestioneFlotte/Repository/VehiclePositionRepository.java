package com.flotte.gestioneFlotte.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flotte.gestioneFlotte.Entity.VehiclePosition;


public interface VehiclePositionRepository extends JpaRepository<VehiclePosition, Long> {
    List<VehiclePosition> findTop1ByVehicleIdOrderByTimestampDesc(String vehicleId);
}