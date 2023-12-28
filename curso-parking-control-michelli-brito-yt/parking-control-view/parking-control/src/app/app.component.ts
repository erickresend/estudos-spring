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

  parkingSpots: ParkingSpotModel[] = []

  constructor(private parkingSpotService: ParkingSpotService){
    this.getAllParkingSpots()
  }

  getAllParkingSpots(){
    this.parkingSpotService.getParkingSpots()
      .subscribe(parkingSpots => this.parkingSpots = parkingSpots)
  }
}
