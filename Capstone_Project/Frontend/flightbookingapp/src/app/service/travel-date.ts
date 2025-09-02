import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TravelDate {
  private travelDate: string = '';

  setDate(date: string) {
    this.travelDate = date;
    localStorage.setItem("travelDate", date);
  }

  getDate(): string {
    return this.travelDate || localStorage.getItem("travelDate") || '';
  }
}
  