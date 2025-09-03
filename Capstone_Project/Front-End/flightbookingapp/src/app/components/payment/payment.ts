import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookingService } from '../../service/booking-service';
import { IBooking } from '../../interface/booking';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './payment.html',
  styleUrls: ['./payment.css']
})
export class Payment implements OnInit {
  bookingId!: number;
  booking?: IBooking;

  cardNumber = '';
  cardHolder = '';
  expiryMonth = '';
  expiryYear = '';
  cvv = '';

  processing = false;

  constructor(
    private route: ActivatedRoute,
    private bookingService: BookingService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.bookingId = Number(this.route.snapshot.paramMap.get('bookingId'));
    this.bookingService.getBooking(this.bookingId).subscribe(b => this.booking = b);
  }

  async pay() {
    if (!this.cardNumber || this.cardNumber.length !== 16) {
      alert("Card number must be 16 digits.");
      return;
    }
    if (!this.cardHolder || !this.expiryMonth || !this.expiryYear || !this.cvv) {
      alert("Please fill all card details.");
      return;
    }

    this.processing = true;

    try {
      
      await this.bookingService.payForBooking(this.bookingId, this.cardNumber).toPromise();

      
      const result = await this.bookingService.waitForBookingResolution(this.bookingId);

      if (result.status === 'SUCCESSFUL') {
        this.router.navigate(['/success', this.bookingId]);
      } else {
        this.router.navigate(['/failure']);
      }
    } catch (err) {
      console.error("Payment error", err);
      this.router.navigate(['/failure']);
    } finally {
      this.processing = false;
    }
  }
}
