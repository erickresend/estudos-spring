package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    @Autowired
    ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        if (parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is alredy in use!");
        }
        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot Number is alredy in use!");
        }
        if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot alredy registred for this apartment/block!");
        }

        var parkingSpotModel = new ParkingSpotModel();
        //Convertendo o dto em model
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) Pageable pageable)  {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isPresent()) {
            ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isPresent()) {
            //ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();
            return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfuly.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto, @PathVariable(value = "id") UUID id) {

        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        var parkingSpotModel = new ParkingSpotModel();
        if (parkingSpotModelOptional.isPresent()) {
            parkingSpotModel = parkingSpotModelOptional.get();
            parkingSpotModel.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
            parkingSpotModel.setLicensePlateCar(parkingSpotDto.getLicensePlateCar());
            parkingSpotModel.setBrandCar(parkingSpotDto.getBrandCar());
            parkingSpotModel.setModelCar(parkingSpotDto.getModelCar());
            parkingSpotModel.setColorCar(parkingSpotDto.getColorCar());
            parkingSpotModel.setResponsibleName(parkingSpotDto.getResponsibleName());
            parkingSpotModel.setApartment(parkingSpotDto.getApartment());
            parkingSpotModel.setBlock(parkingSpotDto.getBlock());
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
    }
}
