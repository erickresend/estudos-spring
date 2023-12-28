import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { ParkingSpotModel } from '../models/parking-spot-model';

@Injectable({
  providedIn: 'root'
})
export class ParkingSpotService {

  //Apagar a parte do develpment do import
  private url = environment.api

  //Tem que importar o HttpClientModule no module
  constructor(private httpClient: HttpClient) {

  }

  getParkingSpots(){
    return this.httpClient.get<ParkingSpotModel[]>(this.url + "/parking-spot")
  }

}
