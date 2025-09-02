import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom, Observable } from 'rxjs';
import { IBooking } from '../interface/booking';
import { IBookingRequest } from '../interface/ibookin-request';


@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseUrl = 'http://localhost:9999/booking';

  constructor(private http: HttpClient) {}

  createBooking(b: IBookingRequest): Observable<IBooking> {
    return this.http.post<IBooking>(`${this.baseUrl}`, b);
  }

  getBooking(id: number): Observable<IBooking> {
    return this.http.get<IBooking>(`${this.baseUrl}/${id}`);
  }

  payForBooking(id: number, cardNumber: string) {
    return this.http.post(`${this.baseUrl}/pay/${id}`, { cardNumber });
  }

  async waitForBookingResolution(id: number): Promise<IBooking> {
    const end = Date.now() + 30000;
    while (Date.now() < end) {
      const booking = await firstValueFrom(this.getBooking(id));
      if (booking.status && booking.status !== 'INITIATED') {
        return booking;
      }
      await new Promise(r => setTimeout(r, 2000));
    }
    return await firstValueFrom(this.getBooking(id));
  }
}
