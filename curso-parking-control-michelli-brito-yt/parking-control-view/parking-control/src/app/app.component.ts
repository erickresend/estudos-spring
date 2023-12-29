import { Observable } from 'rxjs';
import { ParkingSpotModel } from './models/parking-spot-model';
import { ParkingSpotService } from './services/parking-spot.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'parking-control';

  parkingSpots$ = new Observable<ParkingSpotModel[]>()
  displayedColumns = ["parkingSpotNumber", "licensePlateCar", "brandCar", "modelCar",
    "colorCar", "registrationDate", "responsibleName", "apartment", "block", "update"]

  idInput = ''
  parkingSpotNumberInput = ''
  licensePlateCarInput = ''
  brandCarInput = ''
  modelCarInput = ''
  colorCarInput = ''
  responsibleNameInput = ''
  apartmentInput = ''
  blockInput = ''


  constructor(private parkingSpotService: ParkingSpotService){
    this.getAllParkingSpots()
  }

  getAllParkingSpots(){
    this.parkingSpots$ = this.parkingSpotService.getParkingSpots()
  }

  createParkingSpot(){
    this.parkingSpotService.createParkingSpot({
      parkingSpotNumber: this.parkingSpotNumberInput,
      licensePlateCar: this.licensePlateCarInput,
      brandCar: this.brandCarInput,
      modelCar: this.modelCarInput,
      colorCar: this.colorCarInput,
      responsibleName: this.responsibleNameInput,
      apartment: this.apartmentInput,
      block: this.blockInput})
        .subscribe(() => this.getAllParkingSpots())
  }

  updateParkingSport(){
    this.parkingSpotService.updateParkingSpot({
      parkingSpotNumber: this.parkingSpotNumberInput,
      licensePlateCar: this.licensePlateCarInput,
      brandCar: this.brandCarInput,
      modelCar: this.modelCarInput,
      colorCar: this.colorCarInput,
      responsibleName: this.responsibleNameInput,
      apartment: this.apartmentInput,
      block: this.blockInput}, this.idInput)
        .subscribe(() => this.getAllParkingSpots())
  }

  buttonCreateUpdate(){
    if(!this.parkingSpotNumberInput || !this.licensePlateCarInput || !this.brandCarInput
      || !this.modelCarInput || !this.colorCarInput || !this.responsibleNameInput
      || !this.apartmentInput || !this.blockInput){
        return
    }
    else if(this.idInput){
      this.updateParkingSport()
      console.log(this.idInput)
    }
    else {
      this.createParkingSpot()
    }
  }

  deleteParkingSpot(id : string){
    console.log("to aqui " + id)
    this.parkingSpotService.deleteParkingSpot(id)
      .subscribe(() => this.getAllParkingSpots())
  }

  fillInFilds(parkingSpot: ParkingSpotModel){
    this.parkingSpotNumberInput = parkingSpot.parkingSpotNumber
    this.licensePlateCarInput = parkingSpot.licensePlateCar
    this.brandCarInput = parkingSpot.brandCar
    this.modelCarInput = parkingSpot.modelCar
    this.colorCarInput = parkingSpot.colorCar
    this.responsibleNameInput = parkingSpot.responsibleName
    this.apartmentInput = parkingSpot.apartment
    this.blockInput = parkingSpot.block
    this.idInput = parkingSpot.id
  }
}
