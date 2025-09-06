import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { TravelDate } from '../../service/travel-date';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatInputModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatIconModule,
    MatNativeDateModule,
  ],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class Home {
  source: string = '';
  destination: string = '';
  departureDate: Date | null = null;   // store as Date, not string!

  sourceOptions: string[] = [];
  destinationOptions: string[] = [];

  constructor(private router: Router, private travelDate: TravelDate) {}

  swapCities() {
    [this.source, this.destination] = [this.destination, this.source];
    console.log("After swap → Source:", this.source, "Destination:", this.destination);
  }

  onSearch(field: string, value: string) {
    if (value.length >= 3) {
      const airports = [
        'Kolkata (CCU)', 'Chennai (MAA)', 'Hyderabad (HYD)',
        'Bangalore (BLR)', 'Delhi (DEL)', 'Mumbai (BOM)'
      ];

      if (field === 'source') {
        this.sourceOptions = airports.filter(a => a.toLowerCase().includes(value.toLowerCase()));
      } else {
        this.destinationOptions = airports.filter(a => a.toLowerCase().includes(value.toLowerCase()));
      }
    }
  }

  searchFlights() {
    if (!this.source || !this.destination) {
      alert("Please select both source and destination");
      return;
    }
    if (this.source === this.destination) {
      alert("Source and destination cannot be the same");
      return;
    }

    let formattedDate = '';
    if (this.departureDate instanceof Date) {
      formattedDate = this.departureDate.toISOString().split('T')[0]; // yyyy-MM-dd
    }

    console.log("Source:", this.source);
    console.log("Destination:", this.destination);
    console.log("Date:", formattedDate);

    this.travelDate.setDate(formattedDate);

    this.router.navigate(['/search'], {
      queryParams: {
        source: this.source,
        destination: this.destination,
        date: formattedDate
      }
    });
  }
}
