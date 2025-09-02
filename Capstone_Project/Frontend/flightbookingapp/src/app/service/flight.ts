import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Flight } from '../interface/flight';

@Injectable({ providedIn: 'root' })
export class FlightService {
  private baseUrl = 'http://localhost:9999/flight';

  constructor(private http: HttpClient) {}

  searchFlights(source: string, destination: string, date: string): Observable<Flight[]> {
    const params = new HttpParams()
      .set('source', source)
      .set('destination', destination)
      .set('date', date);

    return this.http.get<Flight[]>(`${this.baseUrl}/search`, { params });
  }
  getFlightById(id: number): Observable<Flight> {
  return this.http.get<Flight>(`${this.baseUrl}/${id}`);
}
}
