package com.flotte.gestioneFlotte.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flotte.gestioneFlotte.Entity.VehiclePosition;
import com.flotte.gestioneFlotte.Repository.VehiclePositionRepository;

@Service
public class VehiclePositionService {
    @Autowired
    private VehiclePositionRepository repository;
    
// da sempre lultima posizione ( in caso fornisse piu posizioni aggiornate)
    public VehiclePosition getLatestPosition(String vehicleId) {
        List<VehiclePosition> positions = repository.findTop1ByVehicleIdOrderByTimestampDesc(vehicleId);
        return positions.isEmpty() ? null : positions.get(0);
    }
    public void addVehicle(VehiclePosition vehicle) {
		repository.save(vehicle);
	}
    

    public List<VehiclePosition> getAllVehicles() {
        return repository.findAll();
    }
}