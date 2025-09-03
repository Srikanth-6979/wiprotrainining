import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Flight } from '../../interface/flight';
import { FlightService } from '../../service/flight';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-search-results',
  imports:[FormsModule,CommonModule],
  templateUrl: './search-results.html',
  styleUrls: ['./search-results.css']
})
export class SearchResults implements OnInit {
  flights: Flight[] = [];
  filteredFlights: Flight[] = [];

  filters = {
    airline: [] as string[], 
    nonStop: false
  };
  

  constructor(
    private flightService: FlightService,
    private route: ActivatedRoute,
    private router: Router 
  ) {}

 ngOnInit(): void {
  this.route.queryParams.subscribe(params => {
    const source = params['source'];
    const destination = params['destination'];
    let date = params['date'];

    if (date) {
      const parsedDate = new Date(date);
      if (!isNaN(parsedDate.getTime())) {
        date = parsedDate.toISOString().split('T')[0]; // "2025-09-01"
      }
    }

    this.flightService.searchFlights(source, destination, date).subscribe({
      next: (data) => {
        console.log('Flights:', data);
        this.flights = data;
        this.filteredFlights = [...this.flights];
      },
      error: (err) => {
        console.error('Flight search failed:', err);
      }
    });
  });
}


  toggleAirline(airline: string, event: any) {
    if (event.target.checked) {
      this.filters.airline.push(airline);
    } else {
      this.filters.airline = this.filters.airline.filter(a => a !== airline);
    }
    this.applyFilters();
  }

  toggleNonStop(event: any) {
    this.filters.nonStop = event.target.checked;
    this.applyFilters();
  }

  applyFilters() {
    this.filteredFlights = this.flights.filter(flight => {
      let ok = true;

      if (this.filters.airline.length > 0) {
        ok = ok && this.filters.airline.includes(flight.airline);
      }

      if (this.filters.nonStop) {
        ok = ok && true; 
      }

      return ok;
    });
  }

  clearFilters() {
    this.filters = { airline: [], nonStop: false };
    this.filteredFlights = [...this.flights];
  }
  bookFlight(flightId: number) {
    this.router.navigate(['/booking', flightId]);
  }
}
