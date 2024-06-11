package com.flotte.gestioneFlotte.Entity;

import java.time.LocalDateTime;

import com.flotte.gestioneFlotte.Util.CryptoUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class VehiclePosition {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String vehicleId;
	    private double latitude;
	    private double longitude;
	    private LocalDateTime timestamp;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		public VehiclePosition(Long id, String vehicleId, double latitude, double longitude, LocalDateTime timestamp) {
			super();
			this.id = id;
			this.vehicleId = vehicleId;
			this.latitude = latitude;
			this.longitude = longitude;
			this.timestamp = timestamp;
		}
	// crittografa quando lo inseriamo in db
	public VehiclePosition() {};
	public void setVehicleId(String vehicleId) {
        try {
            this.vehicleId = CryptoUtil.encrypt(vehicleId);
        } catch (Exception e) {
            // Gestisci l'eccezione o lanciala
            throw new RuntimeException("Errore durante la crittografia del vehicleId", e);
        }
    }

    // Aggiungi un metodo per decrittografare il vehicleId prima di restituirlo
    public String getVehicleId() {
        try {
            return CryptoUtil.decrypt(this.vehicleId);
        } catch (Exception e) {
            // Gestisci l'eccezione o lanciala
            throw new RuntimeException("Errore durante la decrittografia del vehicleId", e);
        }
    }
	
	
}
