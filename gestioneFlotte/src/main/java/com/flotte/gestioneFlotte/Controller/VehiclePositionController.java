package com.flotte.gestioneFlotte.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flotte.gestioneFlotte.Entity.VehiclePosition;
import com.flotte.gestioneFlotte.Service.VehiclePositionService;


//@RestController
//@RequestMapping("/api/veicoli")
//public class VehiclePositionController {
//	
//	 @GetMapping
//	    public List<VehiclePosition> getAllVehicles() {
//	        return service.getAllVehicles();
//	 }
//	        
//    @Autowired
//     VehiclePositionService service;
//
//    @GetMapping("/vehicle/position")
//    public VehiclePosition getVehiclePosition(@RequestParam String vehicleId) {
//        return service.getLatestPosition(vehicleId);
//    }
//    
//    @PostMapping("/vehicle/add")
//    public VehiclePosition addVehicle(@RequestBody VehiclePosition entity) {
//    	service.addVehicle(entity);
//        return entity;
//    }
//    
//}
@RestController
@CrossOrigin("*")
@RequestMapping("/api/veicoli")
public class VehiclePositionController {

    @Autowired
    private VehiclePositionService service;

    @GetMapping
    public List<VehiclePosition> getAllVehicles() {
        return service.getAllVehicles();
    }

    @GetMapping("/vehicle/position")
    public VehiclePosition getVehiclePosition(@RequestParam String vehicleId) {
        VehiclePosition position = service.getLatestPosition(vehicleId);
        // Utilizza il metodo getVehicleId() per ottenere il vehicleId decrittografato
        position.setVehicleId(position.getVehicleId());
        return position;
    }

    @PostMapping("/vehicle/add")
    public VehiclePosition addVehicle(@RequestBody VehiclePosition entity) {
        // Utilizza il metodo setVehicleId() per crittografare il vehicleId prima di salvare
        entity.setVehicleId(entity.getVehicleId());
        service.addVehicle(entity);
        return entity;
    }
}