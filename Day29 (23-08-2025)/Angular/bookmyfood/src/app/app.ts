import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Logincomp } from './components/logincomp/logincomp';

@Component({
  selector: 'app-root',
  standalone: true, 
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrls: ['./app.css'] 
})
export class App {
  protected readonly title = signal('bookmyfood');
}
