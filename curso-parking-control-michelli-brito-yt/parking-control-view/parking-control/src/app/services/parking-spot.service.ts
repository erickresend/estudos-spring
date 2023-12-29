import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { ParkingSpotModel } from '../models/parking-spot-model';

@Injectable({
  providedIn: 'root'
})
export class ParkingSpotService {

  //Apagar a parte do develpment do import
  private url = `${environment.api}/parking-spot`

  //Tem que importar o HttpClientModule no module
  constructor(private httpClient: HttpClient) {

  }

  getParkingSpots(){
    return this.httpClient.get<ParkingSpotModel[]>(this.url)
  }

  createParkingSpot(parkingSpot: ParkingSpotModel){
    return this.httpClient.post<ParkingSpotModel>(this.url, parkingSpot)
  }

  updateParkingSpot(parkingSpot: ParkingSpotModel, id : string){
    return this.httpClient.put<ParkingSpotModel>(`${this.url}/${id}`, parkingSpot)
  }

  deleteParkingSpot(id : string){
    console.log("to aqui tbm" + id)
    return this.httpClient.delete<void>(`${this.url}/${id}`)
  }

}
