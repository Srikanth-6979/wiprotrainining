import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BookingService } from '../../service/booking-service';
import { FlightService } from '../../service/flight';
import { IBooking } from '../../interface/booking';
import { Flight } from '../../interface/flight';
import { IBookingRequest } from '../../interface/ibookin-request';
import { TravelDate } from '../../service/travel-date';

@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './booking.html',
  styleUrls: ['./booking.css']
})
export class Booking implements OnInit {

  bookingDetails: IBookingRequest = {
    passengerName: '',
    email: '',
    flightId: 0,
    amount: 0,
    cardNumber: '',
  };

  flightDetails?: Flight;
  flightId: number = 0;
  date: string = '';
  constructor(
    private bookingService: BookingService,
    private flightService: FlightService,
    private router: Router,
    private route: ActivatedRoute,
    private travelDate:TravelDate
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.flightId = +params['flightId'];
      this.getFlightDetails();
    });
    this.date = this.travelDate.getDate();
  }

  getFlightDetails() {
    this.flightService.getFlightById(this.flightId).subscribe((flight: Flight) => {
      this.flightDetails = flight;
      this.bookingDetails.flightId = flight.id;
      this.bookingDetails.amount = flight.price;
    });
  }

  onBookFlight() {
    this.bookingService.createBooking(this.bookingDetails).subscribe((response: IBooking) => {
      if (response && response.id) {
        this.router.navigate(['/payment', response.id]);
      }
    });
  }
}
