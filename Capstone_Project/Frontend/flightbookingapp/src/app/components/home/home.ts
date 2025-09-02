import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { TravelDate } from '../../service/travel-date';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
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
  departureDate: string = '';

  sourceOptions: string[] = [];
  destinationOptions: string[] = [];

  constructor(private router: Router,private travelDate: TravelDate) {}

  swapCities() {
    [this.source, this.destination] = [this.destination, this.source];
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
    console.log("Source:", this.source);
    console.log("Destination:", this.destination);
    console.log("Date:", this.departureDate);
    this.travelDate.setDate(this.departureDate);
    this.router.navigate(['/search'], {
      queryParams: {
        source: this.source,
        destination: this.destination,
        date: this.departureDate
      }
    });
  }

}
