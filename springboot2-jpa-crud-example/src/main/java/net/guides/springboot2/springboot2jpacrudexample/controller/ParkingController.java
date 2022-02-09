 package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Parking;
import net.guides.springboot2.springboot2jpacrudexample.repository.ParkingRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ParkingController {
	@Autowired
	private ParkingRepository parkingRepository;

	@GetMapping("/parkings")
	public List<Parking> getAllParkings() {
		return parkingRepository.findAll();
	}

	@GetMapping("/parkings/{id}")
	public ResponseEntity<Parking> getParkingById(@PathVariable(value = "id") Long parkingId)
			throws ResourceNotFoundException {
		Parking parking = parkingRepository.findById(parkingId)
				.orElseThrow(() -> new ResourceNotFoundException("Parking not found for this id :: " + parkingId));
		return ResponseEntity.ok().body(parking);
	}

	@PostMapping("/parkings")
	public Parking createParking(@Valid @RequestBody Parking parking) {
		return parkingRepository.save(parking);
	}

	@PutMapping("/parkings/{id}")
	public ResponseEntity<Parking> updateParking(@PathVariable(value = "id") Long parkingId,
			@Valid @RequestBody Parking parkingDetails) throws ResourceNotFoundException {
		Parking parking = parkingRepository.findById(parkingId)
				.orElseThrow(() -> new ResourceNotFoundException("Parking not found for this id :: " + parkingId));

//		parking.setEmailId(parkingDetails.getEmailId());
//		parking.setLastName(parkingDetails.getLastName());
//		parking.setFirstName(parkingDetails.getFirstName());
		parking.setOwnerName(parkingDetails.getOwnerName());
		parking.setEmailId(parkingDetails.getEmailId());
		parking.setCarName(parkingDetails.getCarName());
		parking.setCarNumber(parkingDetails.getCarNumber());
		parking.setEntryTime(parkingDetails.getEntryTime());
		parking.setExitTime(parkingDetails.getExitTime());
		
		
		
		
	
		final Parking updatedParking = parkingRepository.save(parking);
		return ResponseEntity.ok(updatedParking);
	}

	@DeleteMapping("/parkings/{id}")
	public Map<String, Boolean> deleteParking(@PathVariable(value = "id") Long parkingId)
			throws ResourceNotFoundException {
		Parking parking = parkingRepository.findById(parkingId)
				.orElseThrow(() -> new ResourceNotFoundException("Parking not found for this id :: " + parkingId));

		parkingRepository.delete(parking);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
