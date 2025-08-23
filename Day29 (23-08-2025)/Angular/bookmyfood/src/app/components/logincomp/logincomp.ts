import { Component } from '@angular/core';
import { Login } from '../../interfaces/login';
import { LoginService } from '../../services/loginservice';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-logincomp',
  imports: [FormsModule, CommonModule],
  templateUrl: './logincomp.html',
  styleUrls: ['./logincomp.css']
})
export class Logincomp {

  loginData: Login = { email: '', password: '' };

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {}

  onLogin(): void {
    
    console.log('Sending login data:', this.loginData);

    this.loginService.login(this.loginData).subscribe({
      next: (res) => {
        console.log('Backend response:', res);
        alert('Login successful');

    
        this.router.navigate(['/foods']);
      },
      error: (err) => {
        console.error('Login error:', err);
        alert('Invalid credentials');
      }
    });
  }

}
