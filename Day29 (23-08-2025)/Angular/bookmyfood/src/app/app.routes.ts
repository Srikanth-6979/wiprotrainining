import { Routes } from '@angular/router';
import { Logincomp } from './components/logincomp/logincomp';
import { Foodcomp } from './components/foodcomp/foodcomp';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: Logincomp },
  { path: 'foods', component: Foodcomp }
];
