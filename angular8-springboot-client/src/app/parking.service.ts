import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParkingService {

//  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/parkings/1';
  private baseUrl ='http://localhost:8080/api/v1/parkings';
    // private baseUrl = 'http://localhost:8080/api/get'
  constructor(private http: HttpClient) { }

  getParking(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createParking(parking: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, parking);
  }

  updateParking(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteParking(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getParkingList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
