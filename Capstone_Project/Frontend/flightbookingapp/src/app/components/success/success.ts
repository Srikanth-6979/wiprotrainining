import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { BookingService } from '../../service/booking-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IBooking } from '../../interface/booking';
import jsPDF from 'jspdf'; 
import { TravelDate } from '../../service/travel-date';
import { Flight } from '../../interface/flight';
import { FlightService } from '../../service/flight';
@Component({
  selector: 'app-success',
  imports: [FormsModule,CommonModule,RouterModule],
  templateUrl: './success.html',
  styleUrl: './success.css'
})
export class Success implements OnInit {
  bookingId!: number;
  booking?: IBooking;
  flight?:Flight;
  date: string = '';
  referenceId: string = '';
  
  constructor(
    private route: ActivatedRoute,
    private bookingService: BookingService,
    private travelDate: TravelDate,
    private flightService: FlightService,
    private router: Router
  ) {}

  ngOnInit(): void {
  this.bookingId = Number(this.route.snapshot.paramMap.get('bookingId'));
  console.log('BookingId from route:', this.bookingId);

  this.bookingService.getBooking(this.bookingId).subscribe(b => {
    console.log('Booking fetched:', b);
    this.booking = b;

    if (b?.flightId) {
      this.flightService.getFlightById(b.flightId).subscribe(f => {
        console.log('Flight fetched:', f);
        this.flight = f;
      });
    }
  });
  this.date = this.travelDate.getDate();
  this.referenceId = this.generateReferenceId();
}
private generateReferenceId(): string {
    return `REF-${this.bookingId}-${Math.random().toString(36).substr(2, 5).toUpperCase()}`;
}


  downloadTicket() {
  if (!this.booking) {
    alert("Booking details are missing");
    return;
  }

  const passengerName = this.booking.passengerName || "N/A";
  const email = this.booking.email || "N/A";
  const airline = this.flight?.airline || "N/A";
  const amount = this.booking.amount || 0;
  const from = this.flight?.source || "N/A";
  const to = this.flight?.destination || "N/A";
  const date = this.travelDate.getDate() || "N/A";
  const departureTime = this.flight?.departureTime || "N/A";
  const arrivalTime = this.flight?.arrivalTime || "N/A";

  const doc = new jsPDF();

  doc.setFontSize(18);
  doc.text("E-Ticket Confirmation", 20, 20);

  doc.text(`Reference ID: ${this.referenceId}`, 20, 35);
  doc.text(`Booking ID: ${this.booking.id}`, 20, 45);
  doc.text(`Passenger: ${passengerName}`, 20, 55);
  doc.text(`Email: ${email}`, 20, 65);
  doc.text(`Airline: ${airline}`, 20, 75);
  doc.text(`From: ${from}`, 20, 85);
  doc.text(`To: ${to}`, 20, 95);
  doc.text(`Date: ${date}`, 20, 105);
  doc.text(`Departure Time: ${departureTime}`, 20, 115);
  doc.text(`Arrival Time: ${arrivalTime}`, 20, 125);
  doc.text(`Amount Paid: ₹${amount}`, 20, 135);
  doc.text(`Payment Status: SUCCESSFUL`, 20, 145);


  doc.save(`ticket_${this.booking.id}.pdf`);
}
goHome() {
    this.router.navigate(['/']);
}

}
