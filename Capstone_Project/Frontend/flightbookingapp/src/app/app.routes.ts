import { RouterModule, Routes } from '@angular/router';
import { Booking } from './components/booking/booking';
import { SearchResults } from './components/search-results/search-results';
import { Home } from './components/home/home';
import { Payment } from './components/payment/payment';
import { Success } from './components/success/success';
import { Failure } from './components/failure/failure';


export const routes: Routes = [
     { path: '', component: Home },
  { path: 'search', component: SearchResults },
  { path: 'booking/:flightId', component: Booking },
  { path: 'payment/:bookingId', component: Payment },
  { path: 'success/:bookingId', component: Success },
  { path: 'failure', component: Failure },
  { path: '**', redirectTo: '' }
];
