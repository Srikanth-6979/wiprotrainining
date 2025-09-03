import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
@Component({
  selector: 'app-failure',
  imports: [],
  templateUrl: './failure.html',
  styleUrl: './failure.css'
})
export class Failure {
  constructor(private router: Router) {}

  goHome() {
    this.router.navigate(['/']);
  }
}

